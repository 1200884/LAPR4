package eapli.base.app.other.console.presentation.agvmanageruser;

import eapli.base.connectionmanagement.application.ConnectionController;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;

public class ConnectAGVManagerUI extends AbstractUI {

    private static final ConnectionController CONNECTION_CONTROLLER = new ConnectionController();

    @Override
    protected boolean doShow() {
        print("Establishing connection with the AGV Digital Twin server");
        if (CONNECTION_CONTROLLER.establishAGVManagerConnection()) {
            print("Connection established with success!");
        }else {
            print("There was a problem with the connection to the server");
        }
        String message;
        do {
            message = Console.readLine("Please insert the message you wish to send to the server:");
            if (!CONNECTION_CONTROLLER.sendMessage(message)) {
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
            if (answer.equals("")) {
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
        return "Creating Connection to AGV Manager";
    }

    private void print(String string) {
        System.out.println(string);
    }
}
