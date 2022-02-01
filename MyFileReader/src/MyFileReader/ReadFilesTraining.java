package MyFileReader;
import java.io.*;
import java.util.*;
// read file in line by line, concat each read line to a string with a newline, and
// then write to a file

public class ReadFilesTraining  {

//	public static void main(String[] args) throws FileNotFoundException {
	public static void main(String[] args) throws IOException {     //needed for filewriter
		// TODO Auto-generated method stub
		File file = new File("/home/grose/java_work1/masterClassJava/mirth_chapter_1.txt");
		Scanner scan = new Scanner(file);
		String fileContent = "";      
		while (scan.hasNextLine()) {
	        fileContent = fileContent.concat(scan.nextLine() + "\n");		
//		System.out.println(scan.nextLine());     to print each line as read 
		
		
		}
		FileWriter writer = new FileWriter("/home/grose/java_work1/masterClassJava/chapter_1_output.txt");
		writer.write(fileContent);
		writer.close();
		
		scan.close();

	}

}
