package processFromDatabase;

import java.sql.*;


public class jdbcTryWithResources {
	
	static String url = "jdbc:sqlserver://localhost:1433;databaseName=Insurance";
    static String userName = "SA";
    static String password = "Sqlserver1";
	
	public static void main(String[] args) throws SQLException {
		
        
		try(Connection conn = DriverManager.getConnection(url, userName, password)) {
			
			
		
	        
	
	 //       String sql = "insert into dbo.GWRAutosysAPI (stat, tradetype) values (?, ?)";
	//		String sql = "update dbo.GWRAutosysAPI set stat = ? where tradetype = 'reit'"; 
			String sql = "insert into dbo.GWRAutosysAPI (stat, tradetype) values (?,?)";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, 4096);
			pstmt.setString(2,"commonstock");
			pstmt.executeUpdate();
			
			
			
	        
	        int rowsaffected = pstmt.executeUpdate();
	        System.out.println("rows affected is:  " + rowsaffected);
	   	}
		catch (SQLException ex) {
	        ex.printStackTrace();
	    } 
	}   
		
        	
      
		
	}
	
	
	


