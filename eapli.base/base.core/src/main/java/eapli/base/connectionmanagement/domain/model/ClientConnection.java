package eapli.base.connectionmanagement.domain.model;

import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class ClientConnection {

    private static final String HOST = "192.168.56.1";
    private static final int AGV_TWIN_PORT = 123;
    private static final int AGV_MANAGER_PORT = 124;
    private static final int ORDERS_PORT = 125;

    private static Socket socket;
    private static DataOutputStream sOut;
    private static DataInputStream sIn;

    public boolean establishConnection(int num) {
       switch (num) {
           case 1:
               return establishConnection(HOST, AGV_TWIN_PORT);
           case 2:
               return establishConnection(HOST, AGV_MANAGER_PORT);
           case 3:
               return establishConnection(HOST, ORDERS_PORT);
           default:
               return false;
       }
    }
    private boolean establishConnection(String host, int port) {
        try {
            socket = new Socket(host, port);
            sOut = new DataOutputStream(socket.getOutputStream());
            sIn = new DataInputStream(socket.getInputStream());
        }catch (Exception e) {
            return false;
        }
        return true;
    }

    public boolean sendMessage(String message) {
        try {
            sOut.write(convert(message));
        }catch (Exception ignored) {
            return false;
        }
        return true;
    }

    public String receiveMessage() {
        String string = "", prov = "";
        byte[] message = new byte[255];
        try {
            sIn.read(message);
            string += message[0] + ";";
            string += message[1] + ";";
            string += message[2] + ";";
            string += message[3] + ";";
            int finalLength;
            if (message[2] != 0 || message[3] != 0) {
                finalLength = message[2] + (256 * message[3]);
                byte[] dataArray = new byte[finalLength];
                System.arraycopy(message, 4, dataArray, 0, finalLength);
                prov = new String(dataArray, StandardCharsets.UTF_8);
            }
            string += prov;
        }catch (Exception ignored) {
            return null;
        }
        return string;
    }

    public boolean close() {
        try {
            socket.close();
        }catch (Exception ignored) {
            return false;
        }
        return true;
    }

    private byte[] convert(String message) {
        //"1;4;10;alface"
        String[] strings = message.split(";", -2);
        byte[] bytes = new byte[4+strings[4].length()];
        bytes[0] = strings[0].getBytes()[0];
        bytes[1] = strings[1].getBytes()[0];
        bytes[2] = (byte) (Integer.parseInt(strings[2]) % 256);
        bytes[3] = (byte) (Integer.parseInt(strings[3]) / 256);
        byte[] stringBytes = strings[4].getBytes();
        System.arraycopy(stringBytes, 0, bytes, 4, stringBytes.length);
        return bytes;
    }
}
