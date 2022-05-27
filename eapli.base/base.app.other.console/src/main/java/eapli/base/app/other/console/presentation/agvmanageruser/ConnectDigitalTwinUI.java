package eapli.base.app.other.console.presentation.agvmanageruser;

import eapli.base.connectionmanagement.application.ConnectionController;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;

public class ConnectDigitalTwinUI extends AbstractUI {

    private static final ConnectionController CONNECTION_CONTROLLER = new ConnectionController();

    @Override
    protected boolean doShow() {
        print("Establishing connection with the AGV Manager server");
        if (CONNECTION_CONTROLLER.establishAGVTwinConnection()) {
            print("Connection established with success!");
        }else {
            print("There was a problem with the connection to the server");
        }
        byte version, code;
        String message, finalMessage = "";
        do {
            do {
                try {
                    version = Byte.parseByte(Console.readLine("Please insert the version of the message you wish to send to the server:"));
                    break;
                } catch (Exception e) {
                    print("The version you inserted is not a valid one");
                }
            }while (true);
            do {
                try {
                    code = Byte.parseByte(Console.readLine("Please insert the code of the message you wish to send to the server:"));
                    break;
                } catch (Exception e) {
                    print("The version you inserted is not a valid one");
                }
            }while (true);
            message = Console.readLine("Please insert the message you wish to send to the server:");
            finalMessage += version + ";" + code + ";" + message.length() + ";" + message;
            if (!CONNECTION_CONTROLLER.sendMessage(finalMessage)) {
                print("There was a problem sending your message to the server");
                CONNECTION_CONTROLLER.close();
                break;
            }
            String answer = CONNECTION_CONTROLLER.receiveMessage();
            if (answer == null) {
                print("The server could not receive the message");
                CONNECTION_CONTROLLER.close();
                break;
            }
            if (code == 2) {
                print("The connection will be ended now!");
                CONNECTION_CONTROLLER.close();
                break;
            }
            print(answer);
        }while (true);
        return true;
    }

    @Override
    public String headline() {
        return "Creating Connection to AGV Digital Twin";
    }

    private void print(String string) {
        System.out.println(string);
    }
}
