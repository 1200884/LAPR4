package eapli.base.app.other.console.connectionmanagement.application;

public class AGVManagerController {

    private final ConnectionController connectionController = new ConnectionController();

    public AGVManagerController() {
        connectionController.establishAGVManagerConnection();
    }

    public String serverTaskAssign(String orderID) {
        connectionController.sendMessage((byte) 1, (byte) 4, orderID);
        String receivedMessage = connectionController.receiveMessage();
        String[] split = receivedMessage.split(";", -2);
        return split[4];
    }

    public void changeStatus(String AGV_ID) {
        String string = "AGV=" + AGV_ID;
        connectionController.sendMessage((byte) 1, (byte) 3, string);
        connectionController.receiveMessage();
    }

    public void closeServer() {
        connectionController.sendMessage((byte) 1, (byte) 1, "");
        connectionController.closeClientConnection();
    }
}
