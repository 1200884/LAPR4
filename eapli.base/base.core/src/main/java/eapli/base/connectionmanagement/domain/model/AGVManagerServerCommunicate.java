package eapli.base.connectionmanagement.domain.model;

import eapli.base.connectionmanagement.application.ConnectionController;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class AGVManagerServerCommunicate implements Runnable{

    private Socket socket;
    private DataOutputStream sOut;
    private DataInputStream sIn;
    private static final ConnectionController connectionController = new ConnectionController();

    public AGVManagerServerCommunicate(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        connectionController.establishAGVTwinConnection();
        boolean check = true;
        byte version, code, length1, length2;
        InetAddress clientIP=socket.getInetAddress();
        System.out.println("New client connection from " + clientIP.getHostAddress() + ", port number " + socket.getPort());

        try {
            sOut = new DataOutputStream(socket.getOutputStream());
            sIn = new DataInputStream(socket.getInputStream());
            byte[] message = new byte[255];
            byte[] answer = new byte[255];
            do {
                String s = "";
                sIn.read(message);
                version = message[0];
                if (version == 1) {
                    int finalLength = 0;
                    code = message[1];
                    length1 = message[2];
                    length2 = message[3];
                    if (length1 != 0 || length2 != 0) {
                        finalLength = length1 + (256 * length2);
                        byte[] dataArray = new byte[finalLength];
                        System.arraycopy(message, 4, dataArray, 0, finalLength);
                        s = new String(dataArray, StandardCharsets.UTF_8);
                    }
                    switch (code) {
                        case 0:
                            ACK(answer);
                            break;
                        case 1:
                            ACK(answer);
                            check = false;
                            break;
                        case 2:
                            ACK(answer);
                            break;
                        case 3:
                            connectionController.sendMessage(version, code, s);
                        default:
                            System.out.println("There is no functionality for this code");
                    }
                }
            }while(check);

            System.out.println("Client " + clientIP.getHostAddress() + ", port number: " + socket.getPort() + " disconnected");
            connectionController.close();
            socket.close();
        }catch(IOException ex) {
            System.out.println("IOException");
        }
    }

    private void ACK(byte[] message) {
        message[0] = 1;
        message[1] = 2;
        try {
            sOut.write(message);
        }catch (Exception ignored) {
            System.out.println("There was a problem sending the message");
        }
    }
}
