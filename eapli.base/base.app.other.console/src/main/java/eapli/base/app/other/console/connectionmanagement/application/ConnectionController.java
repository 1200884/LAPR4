package eapli.base.app.other.console.connectionmanagement.application;

import eapli.base.app.other.console.connectionmanagement.application.model.ClientConnection;

public class ConnectionController {

    private final ClientConnection CLIENT_CONNECTION = new ClientConnection();

    public boolean establishAGVTwinConnection(){
        return CLIENT_CONNECTION.establishConnection(1);
    }

    public boolean establishAGVManagerConnection(){
        return CLIENT_CONNECTION.establishConnection(2);
    }

    public boolean establishOrdersConnection(){
        System.setProperty("javax.net.ssl.keyStore","Documents/ClientAuth/myKeyStore.jks");
        //specifing the password of the keystore file
        System.setProperty("javax.net.ssl.keyStorePassword","Password1");
        //specifing the trustStore file which contains the certificate & public of the server
        System.setProperty("javax.net.ssl.trustStore","Documents/ClientAuth/myTrustStore.jts");
        //specifing the password of the trustStore file
        System.setProperty("javax.net.ssl.trustStorePassword","Password1");
        return CLIENT_CONNECTION.establishConnection(3);
    }

    public boolean sendMessage(byte version, byte code, String message) {
        return CLIENT_CONNECTION.sendMessage(version, code, message);
    }

    public String receiveMessage() {
        return CLIENT_CONNECTION.receiveMessage();
    }

    public boolean close() {
        return CLIENT_CONNECTION.close();
    }
}
