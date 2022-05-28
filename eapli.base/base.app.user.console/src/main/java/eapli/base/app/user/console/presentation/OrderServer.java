package eapli.base.app.user.console.presentation;


import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class OrderServer {
    public static void main(String[] args) {
        try{
            ServerSocket myServerSocket = new ServerSocket(125);
            System.out.println("Waiting...");

            Socket skt = myServerSocket.accept();
            System.out.println("Accepted");
            DataOutputStream myOutput = new DataOutputStream(skt.getOutputStream());
            DataInputStream myInput = new DataInputStream(skt.getInputStream());

            System.out.println("Waiting for message...");
            byte[] buf=new byte[255];
            myInput.read(buf);
            readMessage(buf);

            myOutput.write(writeMessage());

            skt.close();
            System.out.println("server is exiting");

        }catch (IOException ex){
            ex.printStackTrace();
            System.out.println("Failed");
        }
    }

    private static void readMessage(byte[] buf) {
        int finalLength;
        String prov="";
        if (buf[2] != 0 || buf[3] != 0) {
            finalLength = buf[2] + (256 * buf[3]);
            byte[] dataArray = new byte[finalLength];
            System.arraycopy(buf, 4, dataArray, 0, finalLength);
            prov = new String(dataArray, StandardCharsets.UTF_8);
        }
        System.out.println(prov);
    }

    private static byte[] writeMessage(){
        String message="yes";
        byte[] bytes = new byte[255];
        bytes[0] = 1;
        bytes[1] = 3;
        bytes[2] = (byte) (message.length() % 256);
        bytes[3] = (byte) (message.length() / 256);
        byte[] stringBytes = message.getBytes();
        System.arraycopy(stringBytes, 0, bytes, 4, stringBytes.length);
        return bytes;
    }
}
