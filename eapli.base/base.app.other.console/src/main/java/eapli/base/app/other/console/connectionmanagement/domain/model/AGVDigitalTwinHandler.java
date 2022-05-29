package eapli.base.app.other.console.connectionmanagement.domain.model;

import eapli.base.AGVmanagement.AGV.domain.AGV;
import eapli.base.AGVmanagement.AGV.domain.Status;
import eapli.base.AGVmanagement.AGV.domain.repository.AGVRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class AGVDigitalTwinHandler implements Runnable{

    private static final AGVRepository agvrepository = PersistenceContext.repositories().AGVs();

    private final Socket socket;
    private DataOutputStream sOut;
    private DataInputStream sIn;

    public AGVDigitalTwinHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        boolean check = true;
        byte version, code, length1, length2;
        InetAddress clientIP=socket.getInetAddress();
        System.out.println("New client connection from " + clientIP.getHostAddress() + ", port number " + socket.getPort());

        try {
            sOut = new DataOutputStream(socket.getOutputStream());
            sIn = new DataInputStream(socket.getInputStream());
            byte[] answer = new byte[255];
            do {
                String s = null;
                byte[] message = new byte[255];
                sIn.read(message);
                version = message[0];
                if (version == 1) {
                    code = message[1];
                    length1 = message[2];
                    length2 = message[3];
                    if (length1 != 0 || length2 != 0) {
                        int finalLength = length1 + (256 * length2);
                        byte[] dataArray = new byte[finalLength];
                        System.arraycopy(message, 4, dataArray, 0, finalLength);
                        s = new String(dataArray, StandardCharsets.UTF_8);
                    }
                    switch (code) {
                        case 0:
                            ACK(answer);
                            break;
                        case 1:
                            ACK(answer);
                            check = false;
                            break;
                        case 2:
                            ACK(answer);
                            break;
                        case 3:
                            if (s != null){
                                int error = 0;
                                String[] data = s.split("/", -2);
                                String[] AGVID = data[0].split("=", -2);
                                String[] status = data[1].split("=", -2);

                                outerLoop:
                                for (AGV agv : agvrepository.findAll()) {
                                    if (agv.getId() == Integer.parseInt(AGVID[1])) {
                                        switch (status[1]) {
                                            case "Available":
                                                agv.getStatus().setAvailability(Status.Availability.AVAILABLE);
                                                System.out.println("Status updated with success");
                                                break outerLoop;
                                            case "Working":
                                                System.out.println("agvID "+ agv.getId());
                                                System.out.println(agv.getStatus().gettasks() + " status");
                                                agv.getStatus().setAvailability(Status.Availability.WORKING);
                                                System.out.println("Status updated with success");
                                                break outerLoop;
                                            default:
                                                System.out.println("This status does not exist");
                                                error = 1;
                                                break outerLoop;
                                        }
                                    }
                                }
                                if (error != 1) {
                                    sOut.write(ServerFunctions.sendMessage(answer, code, "The status update was a success"));
                                }else {
                                    sOut.write(ServerFunctions.sendMessage(answer, code, "There was a problem updating the status"));
                                }
                            }else {
                                System.out.println("The data you sent is empty");
                            }
                            break;
                        default:
                            System.out.println("There is no functionality for this code");
                    }
                }
            }while(check);

            System.out.println("Client " + clientIP.getHostAddress() + ", port number: " + socket.getPort() + " disconnected");
            sOut.close();
            sIn.close();
            socket.close();
        }catch(IOException ex) {
            System.out.println(ex);
            System.out.println("There was a problem with the input/output streams");
        }
    }

    private void ACK(byte[] message) {
        message[0] = 1;
        message[1] = 2;
        try {
            sOut.write(message);
        }catch (Exception ex) {
            System.out.println(ex);
            System.out.println("There was a problem sending the message");
        }
    }
}
