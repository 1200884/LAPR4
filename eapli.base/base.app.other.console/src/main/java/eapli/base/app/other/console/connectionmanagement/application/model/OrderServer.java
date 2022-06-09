package eapli.base.app.other.console.connectionmanagement.application.model;


import eapli.base.productmanagement.Product.application.AddProductToCartController;
import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;

public class OrderServer {
    private static Socket skt;
    private static final AddProductToCartController theController = new AddProductToCartController();
    static final int SERVER_PORT=125;
    static final String KEY_STORE="Documents/ClientAuth/myKeyStore.jks";
    static final String TRUSTED_STORE="Documents/ClientAuth/myTrustStore.jts";
    static final String KEYSTORE_PASS="Password1";

    public static void main(String[] args) throws Exception{
        SSLServerSocket sock=null;


        // Trust these certificates provided by authorized clients
        System.setProperty("javax.net.ssl.trustStore", TRUSTED_STORE);
        System.setProperty("javax.net.ssl.trustStorePassword",KEYSTORE_PASS);

        // Use this certificate and private key as server certificate
        System.setProperty("javax.net.ssl.keyStore",KEY_STORE);
        System.setProperty("javax.net.ssl.keyStorePassword",KEYSTORE_PASS);
        SSLServerSocketFactory sslF = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
        try {
            sock = (SSLServerSocket) sslF.createServerSocket(SERVER_PORT);
            sock.setNeedClientAuth(true);
        }
        catch(IOException ex) {
            ex.printStackTrace();
            System.out.println("Server failed to open local port " + SERVER_PORT);
            System.exit(1);
        }

        while(true) {
            skt=sock.accept();
            new Thread(new ClientHandler(skt)).start();
        }
    }


    private static class ClientHandler implements Runnable {

        private final Socket skt;
        private DataOutputStream sOut;
        private DataInputStream sIn;

        public ClientHandler(Socket cli_s) {
            this.skt = cli_s;
        }

        @Override
        public void run() {
            try {
                System.out.println("New client connection");
                DataOutputStream myOutput = new DataOutputStream(skt.getOutputStream());
                DataInputStream myInput = new DataInputStream(skt.getInputStream());
                System.out.println("teste0");
                while (true) {
                    System.out.println("Waiting for message...");
                    byte[] buf = new byte[255];
                    System.out.println("teste");
                    myInput.read(buf);
                    System.out.println("teste1");
                    String answer = readMessage(buf);
                    if (buf[1] != 1) {
                        System.out.println("teste2");
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
