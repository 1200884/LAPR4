package eapli.base.app.other.console.connectionmanagement.application.model;

import eapli.base.productmanagement.Product.application.AddProductToCartController;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class OrderServer {
    private static Socket skt;
    private static final AddProductToCartController theController = new AddProductToCartController();

    public static void main(String[] args) {
        ServerSocket myServerSocket;
        try {
            myServerSocket = new ServerSocket(124);
            while (true) {
                System.out.println("Waiting...");

                skt = myServerSocket.accept();
                System.out.println("Accepted");
                // create a new thread object
                ClientHandler clientSock = new ClientHandler(skt);

                // This thread will handle the client separately
                new Thread(clientSock).start();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
            System.out.println("Failed");
        }
    }


    private static class ClientHandler implements Runnable {

        private final Socket skt;

        public ClientHandler(Socket socket) {
            this.skt = socket;
        }

        @Override
        public void run() {
            try {
                DataOutputStream myOutput = new DataOutputStream(skt.getOutputStream());
                DataInputStream myInput = new DataInputStream(skt.getInputStream());
                while (true) {
                    System.out.println("Waiting for message...");
                    byte[] buf = new byte[255];
                    myInput.read(buf);
                    String answer = readMessage(buf);
                    if (buf[1] != 1) {
                        myOutput.write(writeMessage(answer));
                    } else {
                        break;
                    }
                }
            } catch (IOException ex) {
                ex.printStackTrace();
                System.out.println("Failed");
            }
        }
    }

    private static String readMessage(byte[] buf) throws IOException {
        int finalLength;
        String prov = "";
        int code = buf[1];
        if (buf[2] != 0 || buf[3] != 0) {
            finalLength = buf[2] + (256 * buf[3]);
            byte[] dataArray = new byte[finalLength];
            System.out.println(finalLength);
            System.arraycopy(buf, 4, dataArray, 0, finalLength);
            prov = new String(dataArray, StandardCharsets.UTF_8);
        }
        System.out.println(prov);
        return chooseAction(code, prov);
    }

    private static String chooseAction(int code, String message) throws IOException {
        switch (code) {
            case 0:
                return "";
            case 1:
                skt.close();
                return "";
            case 2:
                return "";
            case 3:
                if (theController.validateCustomer(Integer.parseInt(message))) {
                    return "yes";
                } else {
                    return "no";
                }
            case 4:
                String name = message.split(";", -2)[0];
                int quantity = Integer.parseInt(message.split(";", -2)[1]);
                if (theController.addProduct(name, quantity)) {
                    return "Product added successfully";
                } else {
                    return "Product name is not valid";
                }
            case 5:
                theController.saveCart();
                return "Cart saved successfully";
            default:
                return "Error while connecting with the server!";
        }
    }

    private static byte[] writeMessage(String answer) {
        byte[] bytes = new byte[255];
        bytes[0] = 1;
        bytes[1] = 3;
        bytes[2] = (byte) (answer.length() % 256);
        bytes[3] = (byte) (answer.length() / 256);
        byte[] stringBytes = answer.getBytes();
        System.arraycopy(stringBytes, 0, bytes, 4, stringBytes.length);
        return bytes;
    }
}
