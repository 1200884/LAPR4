package eapli.base.connectionmanagement.application;

import eapli.base.connectionmanagement.domain.model.AGVClientConnection;

public class ConnectionController {

    private static final AGVClientConnection CLIENT_CONNECTION = new AGVClientConnection();

    public boolean establishAGVConnection(){
        return CLIENT_CONNECTION.establishConnection();
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
