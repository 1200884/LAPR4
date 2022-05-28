package eapli.base.connectionmanagement.application;

import java.util.Objects;

public class OrderServerController {
    private final byte VERSION_SERVER=1;
    private final byte CODE_VALIDATE=3;
    private final byte CODE_SAVE=4;
    private final ConnectionController theController = new ConnectionController();

    public boolean establishConnection() {
        return theController.establishOrdersConnection();
    }

    public boolean validateCustomer(int customer) {
        byte version = VERSION_SERVER;
        byte code = CODE_VALIDATE;
        String message=String.valueOf(customer);
        theController.sendMessage(version,code,message);
        String answer=theController.receiveMessage();
        String data = answer.split(";",-2)[4];
        System.out.println("message:"+data);
        return Objects.equals(data, "yes");
    }
}
