package eapli.base.app.other.console.connectionmanagement.application.model;

import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class AGVManagerServerConnection {
    static Socket sock;
    static final String KEY_STORE="Documents/ClientAuth/server2_J.jks";
    static final String TRUSTED_STORE="Documents/ClientAuth/server2_J.jks";
    static final String KEYSTORE_PASS = "Password1";

    public static void main(String args[]) throws Exception {
        SSLServerSocket socket=null;
// Trust these certificates provided by authorized clients
        System.setProperty("javax.net.ssl.trustStore", TRUSTED_STORE);
        System.setProperty("javax.net.ssl.trustStorePassword", KEYSTORE_PASS);

        // Use this certificate and private key as server certificate
        System.setProperty("javax.net.ssl.keyStore", KEY_STORE);
        System.setProperty("javax.net.ssl.keyStorePassword", KEYSTORE_PASS);
        SSLServerSocketFactory sslF = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();

        try{
            socket=(SSLServerSocket) sslF.createServerSocket(123);
            socket.setNeedClientAuth(true);

        }catch (IOException e){
            System.out.println("AGVManagerServerConenction error");
            System.exit(1);
        }
        while (true) {
            try {
                System.out.println("Waiting...");
                sock = socket.accept();
                System.out.println("Connection established!");
            } catch (IOException ex) {
                System.out.println("Failed to connect to the client");
                System.exit(1);
            }
            new Thread(new AGVManagerHandler(sock)).start();
        }
    }
}