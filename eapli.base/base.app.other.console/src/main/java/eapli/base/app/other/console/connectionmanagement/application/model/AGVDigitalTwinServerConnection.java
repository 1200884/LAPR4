package eapli.base.app.other.console.connectionmanagement.application.model;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class AGVDigitalTwinServerConnection {
    static Socket[] sock = new Socket[5];

    private static final int STARTING_AGV_PORT = 125;
    private static final int NUMBER_OF_AGVS = 5;
    public static void main(String args[]) throws Exception {

        ServerSocket[] serverSockets = new ServerSocket[NUMBER_OF_AGVS];
        for (int i = STARTING_AGV_PORT; i < (STARTING_AGV_PORT+NUMBER_OF_AGVS);i++) {
            serverSockets[i-STARTING_AGV_PORT] = new ServerSocket(i);
        }
        while(true) {
            for (int i = STARTING_AGV_PORT; i < (STARTING_AGV_PORT+NUMBER_OF_AGVS); i++) {
                try {
                    System.out.println("Waiting...");
                    System.out.println(i);
                    sock[i-STARTING_AGV_PORT] = serverSockets[i-STARTING_AGV_PORT].accept();
                    System.out.println("Connection established!");
                }catch(IOException ex) {
                    System.out.println("Failed to connect to the agvmanager");
                    System.exit(1);
                }
                new Thread(new AGVDigitalTwinHandler(sock[i-STARTING_AGV_PORT])).start();
            }
        }
    }
}
