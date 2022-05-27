package eapli.base.connectionmanagement.application;

import eapli.base.connectionmanagement.domain.model.ClientConnection;

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

    public boolean sendMessage(String message) {
        return CLIENT_CONNECTION.sendMessage(message);
    }

    public String receiveMessage() {
        return CLIENT_CONNECTION.receiveMessage();
    }

    public boolean close() {
        return CLIENT_CONNECTION.close();
    }
}
