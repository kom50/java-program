package networking.code;

import java.net.*;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;

public class MyClientChat {
    public static void main(String[] args) throws Exception {
        // InetAddress add = InetAddress.getLocalHost();

        // Socket socket = new Socket(add.getHostAddress().trim(), 6666);
        Socket socket = new Socket("localhost", 6666);

        DataInputStream din = new DataInputStream(socket.getInputStream());
        DataOutputStream dout = new DataOutputStream(socket.getOutputStream());

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String send = "", receive = "";

        while (!send.equals("stop")) {
            System.out.println("Enter data : ");
            send = br.readLine();
            dout.writeUTF(send);

            receive = din.readUTF();
            System.out.println("Send by Server : " + receive);
        }

        din.close();
        dout.close();
        br.close();
    }
}