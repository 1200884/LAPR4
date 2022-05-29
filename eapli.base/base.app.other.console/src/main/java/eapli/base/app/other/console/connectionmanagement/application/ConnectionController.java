package eapli.base.app.other.console.connectionmanagement.application;

import eapli.base.app.other.console.connectionmanagement.domain.model.ClientConnection;

public class ConnectionController {

    private final ClientConnection CLIENT_CONNECTION = new ClientConnection();

    public boolean establishAGVTwinConnection(){
        return CLIENT_CONNECTION.establishConnection(1);
    }

    public boolean establishAGVManagerConnection(){
        return CLIENT_CONNECTION.establishConnection(2);
    }

    public boolean establishOrdersConnection(){
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
