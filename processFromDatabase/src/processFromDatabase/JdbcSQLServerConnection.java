package processFromDatabase;



import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;
import java.util.*;


/**
* This program demonstrates how to establish database connection to Microsoft
* SQL Server.
* @author www.codejava.net
*
*/
public class JdbcSQLServerConnection {

   public static void main(String[] args) throws SQLException {

       Connection conn = null;
     
      

       try {

           String dbURL = "jdbc:sqlserver://localhost:1433;databaseName=Insurance";
           String user = "SA";
           String pass = "Sqlserver1";
     //      Statement stmt = null;
     // -----------------------------------------------------------------------------      
           conn = DriverManager.getConnection(dbURL, user, pass);
           if (conn != null) {
               DatabaseMetaData dm = (DatabaseMetaData) conn.getMetaData();
               System.out.println("Driver name: " + dm.getDriverName());
               System.out.println("Driver version: " + dm.getDriverVersion());
               System.out.println("Product name: " + dm.getDatabaseProductName());
               System.out.println("Product version: " + dm.getDatabaseProductVersion());
           }
     //--------------------------------------------------------------------------------------    
           System.out.println("The connection is  " + conn);
           Statement stmt = conn.createStatement();
           String SQL = "SELECT TOP 10 * FROM dbo.claim;";
           ResultSet rs = stmt.executeQuery(SQL);
           System.out.println("--ClaimNumber-----Examiner---");
               while (rs.next()) {
                   System.out.print(rs.getString("ClaimNumber"));
                   System.out.print("    ");
                   System.out.print(rs.getString("ExaminerCode"));
                   System.out.println("   ");
               }
           stmt.close();
     //--------------------------------------------------------------------------------         
           CallableStatement cstmt = conn.prepareCall("{call dbo.genGWRAutosysAPI}");
           cstmt.execute();
           cstmt.close();
           System.out.println("Stored procedure called successfully");
           Statement verifyRowsStmt = conn.createStatement();
           String verifyRowsSQL = "Select count(*) from dbo.GWRAutosysAPI;";
           ResultSet verifyRowsrs = verifyRowsStmt.executeQuery(verifyRowsSQL);
           while (verifyRowsrs.next()) {
           System.out.println(" The row count after the call is  " + verifyRowsrs.getString(1));
           }   
           verifyRowsStmt.close();
           
     //---------try executing proc and storing result 
           Statement procstmt = conn.createStatement();
           String iresult = null;
           String procsql = "DECLARE @iresult INT " + " Execute @iresult = dbo.genGWRAutosysAPI " + " SELECT 'Return Value' = @iresult ";
           ResultSet procrs = procstmt.executeQuery(procsql);
           //---------------
  //         Statement verifyRowsStmt2 = conn.createStatement();
  //         String verifyRowsSQL2 = "Select count(*) from dbo.GWRAutosysAPI;";
  //         ResultSet verifyRowsrs2 = verifyRowsStmt.executeQuery(verifyRowsSQL2);
  //         while (verifyRowsrs2.next()) {
  //         System.out.println(" The row count after the second call is  " + verifyRowsrs2.getString(1));
  //         }   
  //         verifyRowsStmt2.close();
           //------------
           while (procrs.next()) {
        	   iresult = procrs.getString(1);
        	   int iresult2 = Integer.parseInt(iresult);
        	   if (iresult2 == 0) {
        	       System.out.println(" the proc result is " + iresult);
        	       System.out.println(" the procedure call was a success !");
        	       conn.close();
        	       System.exit(0);
              } 
        	   else {
        		   System.out.println("ERROR: Return Code:  " + iresult);
        		   conn.close();
        		   System.exit(1);
        	   }
           
           }
       } catch (SQLException ex) {
           ex.printStackTrace();
       } finally {
           try {
               if (conn != null && !conn.isClosed()) {
                   conn.close();
               }
           } catch (SQLException ex) {
               ex.printStackTrace();
           }
       }
   }
}