package eapli.base.connectionmanagement.domain.model;

import java.io.IOException;
import java.net.Socket;

public class AGVDigitalTwinServerConnection {
    static Socket sock;

    public static void main(String args[]) throws Exception {

        while(true) {
            try {
                sock = new Socket("", 8000);
            }catch(IOException ex) {
                System.out.println("Failed to open socket");
                System.exit(1);
            }
            new Thread(new AGVDigitalTwinServerCommunicate(sock)).start();
        }
    }
}
