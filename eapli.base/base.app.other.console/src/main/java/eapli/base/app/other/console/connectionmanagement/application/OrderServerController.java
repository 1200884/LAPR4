package eapli.base.app.other.console.connectionmanagement.application;

import java.util.Objects;

public class OrderServerController {
    private final byte VERSION_SERVER=1;
    private final byte CODE_DISCONNECT=1;
    private final byte CODE_VALIDATE=3;
    private final byte CODE_ADD_PRODUCT=4;
    private final byte CODE_SAVE=5;
    private final byte CODE_FIND_ORDERS=6;
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

    public String findOrdersByVAT(int vat){
        byte version = VERSION_SERVER;
        byte code = CODE_FIND_ORDERS;
        String message=String.valueOf(vat);
        theController.sendMessage(version,code,message, 0);
        String answer=theController.receiveMessage(0);
        String data = answer.split(";",-2)[4];
        if(data.equals("no")){
            return "no customer with such VAT";
        }
        if(data.equals("no orders")){
            return "this customer has no orders associated";
        }
        String[] ars = data.split("/", -2);
        String s = "";
        for(String s1: ars){
            s+= s1;
            s+="\n";
        }
        return s;
    }
}
