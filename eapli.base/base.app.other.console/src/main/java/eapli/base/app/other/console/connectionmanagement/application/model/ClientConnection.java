package eapli.base.app.other.console.connectionmanagement.application.model;

import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class ClientConnection {

    private static final String HOST = "localhost";
    private static final int AGV_TWIN_PORT = 123;
    private static final int AGV_MANAGER_PORT = 124;
    private static final int ORDERS_PORT = 125;

    private static SSLSocket socket;
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
            SSLSocketFactory sslsocketfactory = (SSLSocketFactory)SSLSocketFactory.getDefault();
            //specifing the trustStore file which contains the certificate & public of the server
            System.setProperty("javax.net.ssl.trustStore","C:\\Users\\PC\\OneDrive - Instituto Superior de Engenharia do Porto\\Desktop\\Gustavo\\ISEP\\LAPR4\\eapli.base\\Documents\\ClientAuth\\myTrustStore.jts");
            //specifing the password of the trustStore file
            System.setProperty("javax.net.ssl.trustStorePassword","Password1");
            //This optional and it is just to show the dump of the details of the handshake process
            System.setProperty("javax.net.debug","all");
            socket = (SSLSocket) sslsocketfactory.createSocket(host,port);
            sOut = new DataOutputStream(socket.getOutputStream());
            sIn = new DataInputStream(socket.getInputStream());
        }catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean sendMessage(byte version, byte code, String message) {
        try {
            sOut.write(convertToSend(version, code, message));
        }catch (Exception ignored) {
            return false;
        }
        return true;
    }

    public String receiveMessage() {
        String returnable;
        byte[] message = new byte[255];
        try {
            sIn.read(message);
            returnable = convertToReceive(message);
        }catch (Exception ignored) {
            return null;
        }
        return returnable;
    }

    public boolean close() {
        try {
            socket.close();
        }catch (Exception ignored) {
            return false;
        }
        return true;
    }

    private byte[] convertToSend(byte version, byte code, String message) {
        byte[] bytes = new byte[255];
        bytes[0] = version;
        bytes[1] = code;
        byte[] stringBytes = message.getBytes();
        bytes[2] = (byte) (stringBytes.length % 256);
        bytes[3] = (byte) (stringBytes.length / 256);
        System.arraycopy(stringBytes, 0, bytes, 4, stringBytes.length);
        return bytes;
    }

    private String convertToReceive(byte[] bytes) {
        //"1361231
        String string = "", prov = "";
        string += bytes[0] + ";";
        string += bytes[1] + ";";
        string += bytes[2] + ";";
        string += bytes[3] + ";";
        int finalLength;
        if (bytes[2] != 0 || bytes[3] != 0) {
            finalLength = bytes[2] + (256 * bytes[3]);
            byte[] dataArray = new byte[finalLength];
            System.arraycopy(bytes, 4, dataArray, 0, finalLength);
            prov = new String(dataArray, StandardCharsets.UTF_8);
        }
        string += prov;
        return string;
    }
}
