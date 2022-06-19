package eapli.base.app.other.console.connectionmanagement.application.model;


import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import javax.security.cert.X509Certificate;

public class ClientConnection {

    private static final String HOST = "localhost";
    private static final int AGV_MANAGER_PORT = 123;
    private static final int ORDERS_PORT = 124;
    private static final int AGV_TWIN_PORT_START = 125;
    private static final int NUM_AGVS = 5;

    private static SSLSocket socket;
    private static DataOutputStream sOut;
    private static DataInputStream sIn;
    private List<SSLSocket> twinSocket = new ArrayList<>();
    private List<DataOutputStream> twinSOut = new ArrayList<>();
    private List<DataInputStream> twinSIn = new ArrayList<>();

    public boolean establishConnection(int num) {
        switch (num) {
            case 1:
                for (int i = AGV_TWIN_PORT_START; i < (AGV_TWIN_PORT_START + NUM_AGVS); i++) {
                    if (!establishTwinConnection(HOST, i, i - AGV_TWIN_PORT_START)) {
                        System.out.println("Nao foi feita a conexao com os agvs digital twins");
                        return false;
                    }

                }
                System.out.println("Foi feita a conexao com os agvs digital twins");
                return true;
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
            SSLSocketFactory sslsocketfactory = (SSLSocketFactory) SSLSocketFactory.getDefault();
            socket = (SSLSocket) sslsocketfactory.createSocket(host,port);
            socket.startHandshake();
            SSLSession ssl = socket.getSession();
            System.out.println("------------------------------------------------------");
            System.out.println("SSL/TLS version: " + ssl.getProtocol() +
                    "         Cypher suite: " + ssl.getCipherSuite());

            X509Certificate[] chain=ssl.getPeerCertificateChain();
            System.out.println("------------------------------------------------------");
            System.out.println("Certificate subject: " + chain[0].getSubjectDN());
            System.out.println("------------------------------------------------------");
            System.out.println("Certificate issuer: " + chain[0].getIssuerDN());
            System.out.println("------------------------------------------------------");
            System.out.println("Not before: " + chain[0].getNotBefore());
            System.out.println("------------------------------------------------------");
            System.out.println("Not after:  " + chain[0].getNotAfter());
            System.out.println("------------------------------------------------------");
            sOut = new DataOutputStream(socket.getOutputStream());
            sIn = new DataInputStream(socket.getInputStream());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    private boolean establishTwinConnection(String host, int port, int i) {
        try {

            SSLSocketFactory sslsocketfactory = (SSLSocketFactory) SSLSocketFactory.getDefault();
            twinSocket.add((SSLSocket) sslsocketfactory.createSocket(host,port));
            twinSocket.get(i).startHandshake();
            SSLSession ssl = twinSocket.get(i).getSession();
            System.out.println("------------------------------------------------------");
            System.out.println("SSL/TLS version: " + ssl.getProtocol() +
                    "         Cypher suite: " + ssl.getCipherSuite());

            X509Certificate[] chain=ssl.getPeerCertificateChain();
            System.out.println("------------------------------------------------------");
            System.out.println("Certificate subject: " + chain[0].getSubjectDN());
            System.out.println("------------------------------------------------------");
            System.out.println("Certificate issuer: " + chain[0].getIssuerDN());
            System.out.println("------------------------------------------------------");
            System.out.println("Not before: " + chain[0].getNotBefore());
            System.out.println("------------------------------------------------------");
            System.out.println("Not after:  " + chain[0].getNotAfter());
            System.out.println("------------------------------------------------------");
            twinSOut.add(new DataOutputStream(twinSocket.get(i).getOutputStream()));
            twinSIn.add(new DataInputStream(twinSocket.get(i).getInputStream()));
        } catch (Exception e) {
            System.out.println("Erro na conexao - " + e);
            return false;
        }
        return true;
    }

    public boolean sendMessage(byte version, byte code, String message) {
        try {
            sOut.write(convertToSend(version, code, message));
        } catch (Exception ignored) {
            return false;
        }
        return true;
    }

    public boolean sendTwinMessage(byte version, byte code, String message, int i) {
        try {
            twinSOut.get(i - AGV_TWIN_PORT_START).write(convertToSend(version, code, message));
        } catch (Exception ignored) {
            return false;
        }
        return true;
    }

    public String receiveMessage() {
        String returnable;
        byte[] message = new byte[1023];
        try {
            sIn.read(message);
            returnable = convertToReceive(message);
        } catch (Exception ignored) {
            return null;
        }
        return returnable;
    }

    public String receiveTwinMessage(int i) {
        String returnable;
        byte[] message = new byte[255];
        try {
            twinSIn.get(i - AGV_TWIN_PORT_START).read(message);
            returnable = convertToReceive(message);
        } catch (Exception ignored) {
            return null;
        }
        return returnable;
    }

    public boolean close() {
        try {
            socket.close();
        } catch (Exception ignored) {
            return false;
        }
        return true;
    }

    public boolean twinClose() {
        try {
            for (int i = AGV_TWIN_PORT_START; i < (AGV_TWIN_PORT_START + NUM_AGVS); i++) {
                twinSocket.get(i - AGV_TWIN_PORT_START).close();
            }
        } catch (Exception ignored) {
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

    public List<SSLSocket> getTwinSocket() {
        return twinSocket;
    }
}
