package database;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;

public class DataBaseMetaDataDemo {
    public static void main(String[] args) {

        try{
            Connection con = Connect.connectMySQL("root", "12345om", "pythonDB");
            if(con != null) {
                DatabaseMetaData dbMetaData = con.getMetaData();
                System.out.println("dbMetaData.getURL() "+dbMetaData.getURL());
                System.out.println("dbMetaData.getUserName() "+dbMetaData.getUserName());
                System.out.println("dbMetaData.getDriverVersion() "+dbMetaData.getDriverVersion());
                System.out.println("dbMetaData.getDatabaseProductVersion() "+dbMetaData.getDatabaseProductVersion());
                System.out.println("dbMetaData.getDriverName() "+dbMetaData.getDriverName());

//              // show all tables from pythonDB database
                String []tables ={"TABLE"};
                ResultSet rs = dbMetaData.getTables(null, null, null, tables);
                while(rs.next())
                    System.out.println(rs.getString(3));

            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
