package networking.code;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.net.*;
import java.io.DataOutputStream;
import java.io.InputStreamReader;

public class MyServerChat {
    public static void main(String[] args) {
        try {
            ServerSocket ss = new ServerSocket(6666);
            Socket s = ss.accept();

            DataInputStream din = new DataInputStream(s.getInputStream());
            DataOutputStream dout = new DataOutputStream(s.getOutputStream());

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String send = "", receive = "";
            while (!send.equals("stop")) {
                receive = din.readUTF();
                System.out.println("Send by Server : " + receive);

                System.out.println("Enter data : ");
                send = br.readLine();
                dout.writeUTF(send);
                dout.flush();
            }

            dout.close();
            din.close();
            br.close();
        } catch (Exception e) {
            // TODO: handle exception
        } finally {

        }
    }
}