package eapli.base.app.other.console.connectionmanagement.domain.model;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class AGVDigitalTwinServerConnection {
    static Socket sock;

    public static void main(String args[]) throws Exception {

        ServerSocket serverSocket = new ServerSocket(123);
        while(true) {
            try {
                sock = serverSocket.accept();
            }catch(IOException ex) {
                System.out.println("Failed to open socket");
                System.exit(1);
            }
            new Thread(new AGVDigitalTwinServerCommunicate(sock)).start();
        }
    }
}
