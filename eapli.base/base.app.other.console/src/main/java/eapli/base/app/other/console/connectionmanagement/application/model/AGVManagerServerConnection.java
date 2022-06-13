package eapli.base.app.other.console.connectionmanagement.application.model;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class AGVManagerServerConnection {
    static Socket sock;

    public static void main(String args[]) throws Exception {

        ServerSocket serverSocket = new ServerSocket(123);
        while(true) {
            try {
                System.out.println("Waiting...");
                sock = serverSocket.accept();
                System.out.println("Connection established!");
            }catch(IOException ex) {
                System.out.println("Failed to connect to the client");
                System.exit(1);
            }
            new Thread(new AGVManagerHandler(sock)).start();
        }
    }
}