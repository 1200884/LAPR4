package eapli.base.app.other.console.connectionmanagement.application;

import java.util.Objects;

public class OrderServerController {
    private final byte VERSION_SERVER=1;
    private final byte CODE_DISCONNECT=1;
    private final byte CODE_VALIDATE=3;
    private final byte CODE_ADD_PRODUCT=4;
    private final byte CODE_SAVE=5;
    private final ConnectionController theController = new ConnectionController();

    public boolean establishConnection() {
        return theController.establishOrdersConnection();
    }

    public boolean validateCustomer(int customer) {
        byte version = VERSION_SERVER;
        byte code = CODE_VALIDATE;
        String message=String.valueOf(customer);
        theController.sendMessage(version,code,message, 0);
        String answer=theController.receiveMessage(0);
        String data = answer.split(";",-2)[4];
        System.out.println("message:"+data);
        return Objects.equals(data, "yes");
    }

    public String addProduct(String name, int quantity) {
        byte version = VERSION_SERVER;
        byte code = CODE_ADD_PRODUCT;
        String message=name+";"+quantity;
        theController.sendMessage(version,code,message, 0);
        String answer=theController.receiveMessage(0);
        return answer.split(";",-2)[4];
    }

    public String saveCart() {
        byte version = VERSION_SERVER;
        byte code = CODE_SAVE;
        String message="";
        theController.sendMessage(version,code,message, 0);
        String answer=theController.receiveMessage(0);
        return answer.split(";",-2)[4];
    }

    public String disconnect() {
        byte version= VERSION_SERVER;
        byte code=CODE_DISCONNECT;
        String message="";
        theController.sendMessage(version,code,message, 0);
        String answer=theController.receiveMessage(0);
        return answer.split(";",-2)[4];
    }
}
