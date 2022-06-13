package eapli.base.app.other.console.connectionmanagement.application;

public class AGVManagerController {

    private final ConnectionController connectionController = new ConnectionController();

    public AGVManagerController() {
        connectionController.establishAGVManagerConnection();
        connectionController.sendMessage((byte) 1, (byte) 5,"", 0);
    }

    public String serverTaskAssign(String orderID) {
        connectionController.sendMessage((byte) 1, (byte) 3, orderID, 0);
        String receivedMessage = connectionController.receiveMessage(0);
        String[] split = receivedMessage.split(";", -2);
        return split[4];
    }

    public void changeStatus(String AGV_ID) {
        String string = "AGV=" + AGV_ID;
        connectionController.sendMessage((byte) 1, (byte) 3, string, 0);
        connectionController.receiveMessage(0);
    }

    public void closeServer() {
        connectionController.sendMessage((byte) 1, (byte) 1, "", 0);
        connectionController.closeClientConnection();
    }
}
