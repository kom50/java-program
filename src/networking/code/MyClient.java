package networking.code;

import java.io.*;
import java.net.*;
// import java.util.Scanner;

public class MyClient {
	public static void main(String[] args) {
		try {
			InetAddress add = InetAddress.getLocalHost();

			Socket s = new Socket(add.getHostAddress().trim(), 6666);
			// Socket s = new Socket("192.168.42.247", 3333);
			// Socket s = new Socket("192.168.42.247", 3333);
			DataOutputStream dout = new DataOutputStream(s.getOutputStream());

			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String msg = br.readLine();
			while (!msg.equals("stop")) {
				dout.writeUTF(msg);
				msg = br.readLine();
			}

			dout.flush();
			dout.close();
			s.close();

		} catch (Exception ignored) {
		}
	}
}