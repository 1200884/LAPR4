package eapli.base.app.other.console.connectionmanagement.application.model;

import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class AGVDigitalTwinServerConnection {
    static Socket[] sock = new Socket[5];
    static final String KEY_STORE="Documents/ClientAuth/server3_J.jks";
    static final String TRUSTED_STORE="Documents/ClientAuth/server3_J.jks";
    static final String KEYSTORE_PASS="Password1";

    private static final int STARTING_AGV_PORT = 125;
    private static final int NUMBER_OF_AGVS = 5;
    public static void main(String args[]) throws Exception {


        // Trust these certificates provided by authorized clients
        System.setProperty("javax.net.ssl.trustStore", TRUSTED_STORE);
        System.setProperty("javax.net.ssl.trustStorePassword",KEYSTORE_PASS);

        // Use this certificate and private key as server certificate
        System.setProperty("javax.net.ssl.keyStore",KEY_STORE);
        System.setProperty("javax.net.ssl.keyStorePassword",KEYSTORE_PASS);
        SSLServerSocketFactory sslF = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
        SSLServerSocket[] serverSockets = new SSLServerSocket[NUMBER_OF_AGVS];
        for (int i = STARTING_AGV_PORT; i < (STARTING_AGV_PORT+NUMBER_OF_AGVS);i++) {
            serverSockets[i-STARTING_AGV_PORT] = (SSLServerSocket)sslF.createServerSocket(i);
        }
        while(true) {
            for (int i = STARTING_AGV_PORT; i < (STARTING_AGV_PORT+NUMBER_OF_AGVS); i++) {
                try {
                    System.out.println("Waiting...");
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
