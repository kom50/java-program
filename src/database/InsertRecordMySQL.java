package database;
import  java.sql.*;
public class InsertRecordMySQL {
    public static void main(String[] args) throws SQLException {

        Connection con = Connect.connectOracle("system", "12345");

        assert con != null;
        CallableStatement csmt = con.prepareCall("Insert into student Values(23, 'vikash')");
        csmt.execute();

    }
}
