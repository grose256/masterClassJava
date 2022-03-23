package processFromDatabase;



import java.sql.Connection;
import java.io.*;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;
import java.util.*;
import java.util.logging.*;


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
    	   System.setProperty("java.util.logging.config.file",
    	              "/home/grose/java_work1/masterClassJava/logging.properties");
    	  
    	   Logger logger = Logger.getLogger("com.microsoft.sqlserver.jdbc");
    	   logger.setLevel(Level.FINE);
    	   logger.info("an info msg");
    	   logger.warning("TEST 123 a warning msg");
    	   logger.severe("a severe msg");
    	   logger.fine("writing fine level logs");
    	   logger.finest("writing finest level logs");
    	  
    	   
    	   
    	   
           String dbURL = "jdbc:sqlserver://localhost:1433;databaseName=Insurance";
           String user = "SA";
           String pass = "Sqlserver1";
     //      Statement stmt = null;
     // -----------------------------------------------------------------------------      
           conn = DriverManager.getConnection(dbURL, user, pass); //getConjnection returns a connection object
           if (conn != null) {
        	   System.out.println("99999999999999999 printing connection 9999999999999999999999 ");
        	   System.out.println("connection is " + conn);
               DatabaseMetaData dm = (DatabaseMetaData) conn.getMetaData();
               System.out.println("Driver name: " + dm.getDriverName());
               System.out.println("Driver version: " + dm.getDriverVersion());
               System.out.println("Product name: " + dm.getDatabaseProductName());
               System.out.println("Product version: " + dm.getDatabaseProductVersion());
           }
     //--------------------------------------------------------------------------------------    
           try {
           String csvFilePath = "MyRowCounts.csv";
           System.out.println("777777777777 Print to CSV - The connection is  " + conn);
           Statement stmt = conn.createStatement();
           String SQL = "SELECT TOP 10 * FROM dbo.claim;";
           ResultSet rs = stmt.executeQuery(SQL);
           BufferedWriter fileWriter = new BufferedWriter(new FileWriter(csvFilePath));
           fileWriter.write("--ClaimNumber-----Examiner---");
           System.out.println("--ClaimNumber-----Examiner---");
               while (rs.next()) {
                   String claimNumber = rs.getString("ClaimNumber");
                   
                   String examinerCode = rs.getString("ExaminerCode");
                   String line  = String.format("\", %s\",%s",claimNumber, examinerCode);
                   fileWriter.newLine();
                   fileWriter.write(line);  
               }
           stmt.close();
           fileWriter.close();
           
       } catch (SQLException e) {
           System.out.println("Datababse error:");
           e.printStackTrace();
       } catch (IOException e) {
           System.out.println("File IO error:");
           e.printStackTrace();
       }
     //----------------------PreparedStatement----------------------------------------------------------
           System.out.println("The PREPARED Statement connection is  " + conn);
           String pSQL = "SELECT TOP 10 * FROM dbo.claim;";
           PreparedStatement pstmt = conn.prepareStatement(pSQL);
           ResultSet prs = pstmt.executeQuery();
          
           System.out.println("--ClaimNumber-----Examiner---");
               while (prs.next()) {
                   System.out.print(prs.getString("ClaimNumber"));
                   System.out.print("    ");
                   System.out.print(prs.getString("ExaminerCode"));
                   System.out.println("   ");
               }
          
     //--------------------------------------------------------------------------------      
           CallableStatement cstmt = conn.prepareCall("{call dbo.genGWRAutosysAPI}");
           cstmt.executeUpdate();
           cstmt.close();
           System.out.println("Callable Stored procedure called successfully");
           Statement verifyRowsStmt = conn.createStatement();
           String verifyRowsSQL = "Select count(*) from dbo.GWRAutosysAPI;";
           ResultSet verifyRowsrs = verifyRowsStmt.executeQuery(verifyRowsSQL);
           while (verifyRowsrs.next()) {
           System.out.println(" Callable Stmt The row count after the call is  " + verifyRowsrs.getString(1));
           }   
           verifyRowsStmt.close();
           
     //---------try executing proc and storing result 
           Statement procstmt = conn.createStatement();
           String iresult = null;
           // String procsql = "DECLARE @iresult INT " + " Execute @iresult = dbo.genGWRAutosysAPI " + " SELECT 'Return Value' = @iresult ";
         String procsql = "DECLARE @iresult INT  " + " Execute @iresult = dbo.genGWRAutosysAPI ;" + " SELECT 'Return Value' = @iresult ";
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