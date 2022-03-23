package processFromDatabase;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Stream;

public class selectClaim {
	
	 List<String[]> table = new ArrayList<>();
	
	
	
	
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
		           
		      
			   
		 
		   
		 //--------------------------------------------------------------------------------------    
		       System.out.println("The connection is  " + conn);
		       
		  
		
		 String pSQL = "SELECT TOP 10 * FROM dbo.claim;";
         PreparedStatement pstmt = conn.prepareStatement(pSQL);
         ResultSet prs = pstmt.executeQuery();
      
         
         System.out.println("--ClaimNumber-----Examiner---");
        
         int nCol = prs.getMetaData().getColumnCount();
         List<String[]> table = new ArrayList<>();
         while( prs.next()) {
             String[] row = new String[nCol];
             for( int iCol = 1; iCol <= nCol; iCol++ ){
                     Object obj = prs.getObject( iCol );
                     row[iCol-1] = (obj == null) ?null:obj.toString();
             }
             table.add( row );
         }

         // print result
         for( String[] row: table ){
             for( String s: row ){
                 System.out.print( " " + s );
             }
             System.out.println();
         }
         
	       } catch (SQLException e) {
	           System.out.println("Datababse error:");
	           e.printStackTrace();
	       } 
		} 
}
      // print result
		
       
         
  
 
