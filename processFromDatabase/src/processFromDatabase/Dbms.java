package processFromDatabase;


import java.sql.*;
import java.util.*;
import java.util.logging.*;


/**
* This program demonstrates how to establish database connection to Microsoft
* SQL Server.
* @author www.codejava.net
*
*/
public class Dbms {
	
	Statement stmt;
	Connection conn;
	

       void dbmsError(SQLException ex, String mode) {
    	   if (ex != null) {
    		   if (mode.compareTo("verbose")==0) {
    			   System.err.println("Message:  " + ex.getMessage());
    			   System.err.println("SQLState:  " + ex.getSQLState());
    			   System.err.println("ErrorCode:  " + ex.getErrorCode());
    			   
    		   }   else
    			   System.err.println(ex.getSQLState()+' '+ex.getErrorCode());
    	   }
    	   
       }	   
    	   
       // public void connect(String url, String user, String server) {
       public void connect() {
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
           Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
           System.out.println("STMT is  " + stmt);
           
          
    	   
         
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
           
       } catch (SQLException ex) {
           dbmsError(ex,"verbose");
       } 
     }
       
     // ================================================================================  
        ResultSet query(String query) {
          
           System.out.println("Enter to query method" + query);	
    	   ResultSet rs = null;
    	  
        try {
        	System.out.println("in query try with query =   " + query);
            rs = stmt.executeQuery(query);
          
            	
           
            System.out.println("after the rs execute query  " + rs);
            
          
                  
            
                 	
        	        	
       } catch(SQLException ex1) {
    	   System.out.println("In SQLException ex1 " + ex1);
    	   dbmsError(ex1,"verbose");
       } 	
       System.out.println("exiting the query method ");
      return rs;   
}
        
}
           
           
           
        