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
 * SQL Server. Using CSV and Arrays and Collections
 * 
 * @author George Rose
 *
 */
public class QueryCSVArray {

	public static void main(String[] args) throws SQLException {

		Connection conn = null;

		String dbURL = "jdbc:sqlserver://localhost:1433;databaseName=Insurance";
		String user = "SA";
		String pass = "Sqlserver1";
		// Statement stmt = null;
		// -----------------------------------------------------------------------------
		conn = DriverManager.getConnection(dbURL, user, pass); // getConjnection returns a connection object
		if (conn != null) {
			System.out.println("99999999999999999 printing connection 9999999999999999999999 ");
			System.out.println("connection is " + conn);
			DatabaseMetaData dm = (DatabaseMetaData) conn.getMetaData();
			System.out.println("Driver name: " + dm.getDriverName());
			System.out.println("Driver version: " + dm.getDriverVersion());
			System.out.println("Product name: " + dm.getDatabaseProductName());
			System.out.println("Product version: " + dm.getDatabaseProductVersion());
		}
		// --------------------------------------------------------------------------------------
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
				String line = String.format("\", %s\",%s", claimNumber, examinerCode);
				fileWriter.newLine();
				fileWriter.write(line);
			}
			stmt.close();
			fileWriter.close();
		// --------------------------------------------------------------------------------------		

		} catch (SQLException e) {
			System.out.println("Datababse error:");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("File IO error:");
			e.printStackTrace();
		}

	}
}
