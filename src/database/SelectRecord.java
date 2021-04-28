package database;
import java.sql.*;
public class SelectRecord {
    public static void main(String[] args) throws  SQLException {
        String user = "system";
        String pass = "12345";
        Connection con = Connect.connectOracle(user, pass);
        if (con != null) {
            Statement smt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
            String query = "SELECT * FROM student";
            ResultSet rs = smt.executeQuery(query);
            System.out.println(rs.getFetchSize());
            rs.next();
            System.out.println(rs.getRow());
            System.out.println(rs.getInt("roll") + " \t" + rs.getString("name"));

            while(rs.next()){
                System.out.println(rs.getInt("roll")+" \t"+ rs.getString("name"));
            }
            System.out.println(rs.getRow());

        }
    }
}
