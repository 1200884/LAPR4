package eapli.base.connectionmanagement.domain.model;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class AGVDigitalTwinServerCommunicate implements Runnable{
    private Socket socket;
    private DataOutputStream sOut;
    private DataInputStream sIn;

    public AGVDigitalTwinServerCommunicate(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
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
                String s = null;
                sIn.read(message);
                version = message[0];
                if (version == 1) {
                    code = message[1];
                    length1 = message[2];
                    length2 = message[3];
                    if (length1 != 0 || length2 != 0) {
                        int finalLength = length1 + (256 * length2);
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
                            if (s != null){
                                String[] data = s.split(";", -2);
                                String[] AGVID = data[0].split("=", -2);
                                String[] status = data[1].split("=", -2);

                            }else {
                                System.out.println("The data you sent is empty");
                            }
                            //AGV a = irbuscar.updatestatus
                        default:
                            System.out.println("There is no functionality for this code");
                    }
                }
            }while(check);

            System.out.println("Client " + clientIP.getHostAddress() + ", port number: " + socket.getPort() + " disconnected");
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
