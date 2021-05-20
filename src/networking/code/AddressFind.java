package networking.code;
import java.net.InetAddress;

public class AddressFind {
    public static void main(String[] args) {
        try {
            InetAddress ad = InetAddress.getLocalHost();
            System.out.println("IP Address " + (ad.getHostAddress()).trim());
            System.out.println("IP Name " + (ad.getHostName()));
        } catch (Exception e) {
            System.out.println("Error : "+e);
        }

    }
}
