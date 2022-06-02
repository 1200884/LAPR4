package eapli.base.app.other.console.connectionmanagement.application.model;

public class ServerFunctions {

    public static byte[] sendMessage(int version, int code, String message) {
        byte[] array = new byte[255];
        array[0] = (byte) version;
        array[1] = (byte) code;
        byte[] stringBytes = message.getBytes();
        array[2] = (byte) (stringBytes.length % 256);
        array[3] = (byte) (stringBytes.length / 256);
        System.arraycopy(stringBytes, 0, array, 4, stringBytes.length);
        return array;
    }

    public static byte[] ACK() {
        byte[] message = new byte[255];
        message[0] = 1;
        message[1] = 2;
        try {
            return message;
        } catch (Exception ignored) {
            System.out.println("There was a problem sending the message");
        }
        return message;
    }
}
