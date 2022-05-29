package eapli.base.app.other.console.connectionmanagement.domain.model;

public class ServerFunctions {

    public static byte[] sendMessage(byte[] array, int code, String message) {
        array[0] = 1;
        array[1] = (byte) code;
        byte[] stringBytes = message.getBytes();
        array[2] = (byte) (stringBytes.length % 256);
        array[3] = (byte) (stringBytes.length / 256);
        System.arraycopy(stringBytes, 0, array, 4, stringBytes.length);
        return array;
    }
}
