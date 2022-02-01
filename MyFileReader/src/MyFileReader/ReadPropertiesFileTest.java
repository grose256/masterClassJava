package MyFileReader;
import java.io.*;
import java.util.*;

public class ReadPropertiesFileTest {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String accountid = null;
		String pwd = null;
		Properties prop = readPropertiesFile("/home/grose/java_work1/masterClassJava/credentials.properties");
	        accountid =   prop.getProperty("username");
	        pwd = prop.getProperty("password");
	        
	     if (accountid.equals(prop.getProperty("username"))) {
	    	  System.out.println("username admin admin: "+ prop.getProperty("username"));
	    	  System.out.println("Perform special admin actions...");
	      } else {
	    	  System.out.println("Perform non-admin actions");
	    	  System.out.println("username non admin: "+ prop.getProperty("username"));
	      }
		  System.out.println("username: "+ prop.getProperty("username"));
	      System.out.println("password: "+ prop.getProperty("password"));
	      System.out.println("The string admin is "+ accountid);
	   }
	   public static Properties readPropertiesFile(String fileName) throws IOException {
	      FileInputStream fis = null;
	      Properties prop = null;
	      try {
	         fis = new FileInputStream(fileName);
	         prop = new Properties();
	         prop.load(fis);
	      } catch(FileNotFoundException fnfe) {
	         fnfe.printStackTrace();
	      } catch(IOException ioe) {
	         ioe.printStackTrace();
	      } finally {
	         fis.close();
	      }
	      return prop;
	   }
	}