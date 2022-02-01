package processFromDatabase;
import java.io.*;
import java.sql.*;

public class readCSVIntoArray {



 public static void main(String[] args) {
     

     String csvFilePath = "Reviews-simple.csv";

     int batchSize = 20;

     Connection connection = null;

     try {

         
         BufferedReader lineReader = new BufferedReader(new FileReader(csvFilePath));
         String lineText = null;

         int count = 0;

         lineReader.readLine(); // skip header line

         while ((lineText = lineReader.readLine()) != null) {
             String[] data = lineText.split(",");
             String courseName = data[0];
             String studentName = data[1];
             String timestamp = data[2];
             String rating = data[3];
             String comment = data.length == 5 ? data[4] : "";


             Timestamp sqlTimestamp = Timestamp.valueOf(timestamp);
            

             Float fRating = Float.parseFloat(rating);
             

            
         }

         lineReader.close();

         // execute the remaining queries
      

       

     } catch (IOException ex) {
         System.err.println(ex);
     } 

        
     }

 }

