package database;
import java.sql.*;
public class ConnectionTest {
    public static void main(String[] args) {
        String url = "jdbc:oracle:thin:@localhost:1521:xe";
        String user = "system";
        String pass = "12345";
        Connection con;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection(url,user,pass);
            if (con == null)
                System.out.println("Connection fails");
            else
                System.out.println("Connected");


        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
