package eapli.base.app.other.console.connectionmanagement.application.model;

import eapli.base.app.other.console.connectionmanagement.application.ConnectionController;
import eapli.base.warehousemanagement.application.OrderAGVAssignmentController;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class AGVManagerHandler implements Runnable {

    private final Socket socket;
    private DataOutputStream sOut;
    private DataInputStream sIn;
    private static final ConnectionController connectionController = new ConnectionController();

    public AGVManagerHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        connectionController.establishAGVTwinConnection();
        boolean check = true;
        byte version, code, length1, length2;
        InetAddress clientIP = socket.getInetAddress();
        System.out.println("New client connection from " + clientIP.getHostAddress() + ", port number " + socket.getPort());

        try {
            sOut = new DataOutputStream(socket.getOutputStream());
            sIn = new DataInputStream(socket.getInputStream());
            byte[] message = new byte[255];
            do {
                String s = "";
                sIn.read(message);
                version = message[0];
                if (version == 1) {
                    int finalLength;
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
                            sOut.write(ServerFunctions.ACK());
                            break;
                        case 1:
                            sOut.write(ServerFunctions.ACK());
                            check = false;
                            break;
                        case 2:
                            sOut.write(ServerFunctions.ACK());
                            break;
                        case 3:
                            System.out.println("Sending message to the AGV Digital Twin");
                            connectionController.sendMessage(version, code, s);
                            System.out.println("Message sent!");
                            sOut.write(ServerFunctions.sendMessage(1, 3, "The message was sent with success"));
                            break;
                        case 4:
                            sOut.write(ServerFunctions.sendMessage(1, 4, String.valueOf(OrderAGVAssignmentController.assignTaskToAGV(s))));
                            break;
                        default:
                            System.out.println("There is no functionality for this code");
                    }
                }
            } while (check);

            System.out.println("Client " + clientIP.getHostAddress() + ", port number: " + socket.getPort() + " disconnected");
            connectionController.sendMessage((byte) 1, (byte) 1, "");
            connectionController.receiveMessage();
            connectionController.closeClientConnection();
            sOut.close();
            sIn.close();
            socket.close();
        } catch (IOException ex) {
            System.out.println("IOException");
        }
    }
}
