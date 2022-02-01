package MyFileReader;

import java.io.*;


public class MyBufReader {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] names = {"New York","London","Paris"};
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter("/home/grose/java_work1/masterClassJava/bufwriter_output.txt"));
			writer.write("Writing to a file.");
			writer.write("\nHere is another line");
			for (String name : names) {
				writer.write("\n" + name);
			}
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
			
		}
		
		try {
			BufferedReader reader = new BufferedReader(new FileReader("/home/grose/java_work1/masterClassJava/bufwriter_output.txt"));
			String line;
			while((line = reader.readLine())  != null) {
				
			System.out.println("The read line is "  + line);
			
		}
			reader.close();

	} catch (IOException e)  {
		e.printStackTrace();
	}
		
	}
}
