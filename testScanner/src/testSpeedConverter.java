
import java.util.Scanner;	

public class testSpeedConverter { 
	
	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter kilometers per hour:  ");
		double inputkph = scanner.nextDouble();
        System.out.println("input number is: " + inputkph);
		// scanner.nextLine(); saved as string input
        // scanner.nextInt(); saved as integer input
		
		
		SpeedConverter converter = new SpeedConverter(inputkph);
		double mph = converter.toMilesPerHour();
        System.out.println("Kilometers per hour of:  " + inputkph + "  equals MPH of: " + mph);

        scanner.close();
		
		
	}

}