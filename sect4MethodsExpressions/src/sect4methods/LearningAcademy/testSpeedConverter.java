package sect4methods.LearningAcademy;

import java.util.Scanner;

public class testSpeedConverter { 
	
	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter kilometers per hour:  ");
		int kph = scanner.nextInt();
		scanner.nextLine();
		
		double mph = 0.0;
		SpeedConverter2 converter = new SpeedConverter2();
		mph = converter.printConversion(kph);
		System.out.println(mph);
		
		
		
		
		
		
		
		
	}
	
}