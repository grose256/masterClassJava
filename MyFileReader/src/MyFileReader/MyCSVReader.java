package MyFileReader;

import java.io.*;
import java.util.*;


public class MyCSVReader {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(new File("/home/grose/java_work1/masterClassJava/raw_sales.csv"));
		sc.useDelimiter(",");
		while (sc.hasNext()) {
			System.out.println("the csv line is  :  " + sc.next());
		}
		sc.close();
		
		
		
		}		

	}

