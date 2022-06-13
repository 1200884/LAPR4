package eapli.base.app.other.console.connectionmanagement.application;

import eapli.base.app.other.console.connectionmanagement.application.model.ClientConnection;

import java.net.Socket;
import java.util.List;

public class ConnectionController {

    private final ClientConnection CLIENT_CONNECTION = new ClientConnection();

    public boolean establishAGVTwinConnection() {
        return CLIENT_CONNECTION.establishConnection(1);
    }

    public boolean establishAGVManagerConnection() {
        return CLIENT_CONNECTION.establishConnection(2);
    }

    public boolean establishOrdersConnection() {
        return CLIENT_CONNECTION.establishConnection(3);
    }

    public boolean sendMessage(byte version, byte code, String message, int i) {
        List<Socket> sockets = CLIENT_CONNECTION.getTwinSocket();
        if (!sockets.isEmpty()) {
            return CLIENT_CONNECTION.sendTwinMessage(version, code, message, i);
        }
        return CLIENT_CONNECTION.sendMessage(version, code, message);
    }

    public String receiveMessage(int i) {
        List<Socket> sockets = CLIENT_CONNECTION.getTwinSocket();
        if (!sockets.isEmpty()) {
            return CLIENT_CONNECTION.receiveTwinMessage(i);
        }
        return CLIENT_CONNECTION.receiveMessage();
    }

    public boolean closeClientConnection() {
        List<Socket> sockets = CLIENT_CONNECTION.getTwinSocket();
        if (!sockets.isEmpty()) {
            return CLIENT_CONNECTION.twinClose();
        }
        return CLIENT_CONNECTION.close();
    }
}
