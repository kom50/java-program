package database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.Stack;

public class ResultSetMetaDataTest {

    public static void main(String[] args) {
         try{
             String query = "Select *from Student";
//             Connection con = Connect.connectOracle("system", "12345");
             Connection con = Connect.connectMySQL("root", "12345om", "pythonDB");
             assert con != null;
             Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
             ResultSet rs = stmt.executeQuery(query);
             ResultSetMetaData rsMetaData = rs.getMetaData();
             System.out.println("rsMetaData.getColumnCount() "+rsMetaData.getColumnCount());
             System.out.println("Column LAbel  "+rsMetaData.getColumnLabel(1)+" "+rsMetaData.getColumnLabel(2));
             System.out.println("Column Name  "+rsMetaData.getColumnName(1)+" "+rsMetaData.getColumnName(2));
             System.out.println("Column Type  "+rsMetaData.getColumnType(1)+" "+rsMetaData.getColumnType(2));
             System.out.println("Table Name  "+rsMetaData.getTableName(1));
             System.out.println("Column type name  "+rsMetaData.getColumnTypeName(1)+" "+rsMetaData.getColumnTypeName(2));
             System.out.println("column size  "+rsMetaData.getColumnDisplaySize(1)+" "+rsMetaData.getColumnDisplaySize(2));
             System.out.println("column getSchemaName  "+rsMetaData.getSchemaName(1));
             System.out.println("column getPrecision  "+rsMetaData.getPrecision(2));



//             rs.absolute(5);
//             System.out.println(rs.getInt(1)+" "+rs.getString(2));

             rs.first();
             System.out.println(rs.getInt(1)+" "+rs.getString(2));

             System.out.println("Show all data");
             // show all data
             while (rs.next())
                 System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4));

             int a = 90;
             String str = String.format("%4d", a);
             System.out.println("str "+str);
         }catch(Exception e){
             e.printStackTrace();
         }
    }
}
