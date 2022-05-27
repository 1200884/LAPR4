package eapli.base.connectionmanagement.domain.model;

import java.io.*;
import java.net.Socket;

public class AGVClientConnection {

    private static final String AGV_TWIN_HOST = "10.9.22.214";
    private static final int PORT = 8000;

    private static Socket socket;
    private static DataOutputStream sOut;
    private static DataInputStream sIn;

    public boolean establishConnection() {
        try {
            socket = new Socket(AGV_TWIN_HOST, PORT);
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
        String message;
        try {
            message = String.valueOf(sIn.read());
        }catch (Exception ignored) {
            return null;
        }
        return message;
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
