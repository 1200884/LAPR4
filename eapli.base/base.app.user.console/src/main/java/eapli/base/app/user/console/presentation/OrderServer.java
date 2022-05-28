package eapli.base.app.user.console.presentation;


import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;

public class OrderServer {
    public static void main(String[] args) {
        try{
            ServerSocket myServerSocket = new ServerSocket(125);
            System.out.println("Waiting");
            Socket skt = myServerSocket.accept();
            //BufferedReader myInput = new BufferedReader(new InputStreamReader(skt.getInputStream()));
            //PrintStream myOutput = new PrintStream(skt.getOutputStream());
            DataOutputStream myOutput = new DataOutputStream(skt.getOutputStream());
            DataInputStream myInput = new DataInputStream(skt.getInputStream());
            System.out.println("accepted");
            byte[] buf=new byte[255];
            myInput.read(buf);
            System.out.println("server read:"+ Arrays.toString(buf));
            String message="yes";
            byte[] bytes = new byte[255];
            bytes[0] = 1;
            bytes[1] = 3;
            bytes[2] = (byte) (message.length() % 256);
            bytes[3] = (byte) (message.length() / 256);
            byte[] stringBytes = message.getBytes();
            System.arraycopy(stringBytes, 0, bytes, 4, stringBytes.length);
            myOutput.write(bytes);
            /*if(buf !=null){
                System.out.println("server read:"+buf);
            }*/
            skt.close();
            System.out.println("server is exiting");
        }catch (IOException ex){
            ex.printStackTrace();
            System.out.println("Failed");
        }
    }
}
