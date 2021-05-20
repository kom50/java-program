package networking.code;

import java.io.DataInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class MyServer {
    public static void main(String[] args) {
        try {
            ServerSocket ss = new ServerSocket(6666);
            Socket s = ss.accept();
            DataInputStream din = new DataInputStream(s.getInputStream());
            String msg = (String) din.readUTF();
            do {
                System.out.println(msg);
                msg = (String) din.readUTF();
            } while (!msg.equals("stop"));
            ss.close();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}