package eapli.base.app.other.console.connectionmanagement.application.model;

import java.util.Random;

public class ServerFunctions {

    public static byte[] sendMessage(int version, int code, String message) {
        byte[] array = new byte[1023];
        array[0] = (byte) version;
        array[1] = (byte) code;
        byte[] stringBytes = message.getBytes();
        array[2] = (byte) (stringBytes.length % 256);
        array[3] = (byte) (stringBytes.length / 256);
        System.arraycopy(stringBytes, 0, array, 4, stringBytes.length);
        return array;
    }

    public static byte[] ACK() {
        byte[] message = new byte[1023];
        message[0] = 1;
        message[1] = 2;
        try {
            return message;
        } catch (Exception ignored) {
            System.out.println("There was a problem sending the message");
        }
        return message;
    }

    public static int randomiseLocation() {
        Random rnd = new Random();
        int number = rnd.nextInt(20);
        return number;
    }
}
