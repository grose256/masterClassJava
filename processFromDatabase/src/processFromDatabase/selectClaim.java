package processFromDatabase;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class selectClaim {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {	   
			   String dbURL = "jdbc:sqlserver://localhost:1433;databaseName=Insurance";
		       String user = "SA";
		       String pass = "Sqlserver1";
			   
			   Connection conn = DriverManager.getConnection(dbURL, user, pass); //getConjnection returns a connection object
		       if (conn != null) {
		           DatabaseMetaData dm = (DatabaseMetaData) conn.getMetaData();
		           System.out.println("Driver name: " + dm.getDriverName());
		           System.out.println("Driver version: " + dm.getDriverVersion());
		           System.out.println("Product name: " + dm.getDatabaseProductName());
		           System.out.println("Product version: " + dm.getDatabaseProductVersion());
		       }		   
		           
		      
			   
		     
			   System.setProperty("java.util.logging.config.file",
			              "/home/grose/java_work1/masterClassJava/logging.properties");
			  
			   Logger logger = Logger.getLogger("com.microsoft.sqlserver.jdbc");
			   logger.setLevel(Level.FINE);
			   logger.info("an info msg");
			   logger.warning("TEST 123 a warning msg");
			   logger.severe("a severe msg");
			   logger.fine("writing fine level logs");
			   logger.finest("writing finest level logs");
		   
		 //--------------------------------------------------------------------------------------    
		       System.out.println("The connection is  " + conn);
		       
		  
		
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
         pstmt.close();
		 } catch (SQLException ex) {
			   ex.printStackTrace();
		   } 
	
         
      
        
	}

}
