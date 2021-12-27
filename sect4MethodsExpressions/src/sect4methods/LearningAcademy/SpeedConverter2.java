package sect4methods.LearningAcademy;

import java.util.Scanner;	
public class SpeedConverter2 {
//-------------------------------------------------------------------------------------------
    public static double toMilesPerHour(double kilometersPerHour) {

        if(kilometersPerHour < 0) {
            return -1;
        }

        return Math.round(kilometersPerHour / 1.609);
    }
//-------------------------------------------------------------------------------------
    public static double printConversion(double kilometersPerHour) {

        if(kilometersPerHour <0) {
            System.out.println("Invalid Value");
        } else {
            double milesPerHour = toMilesPerHour(kilometersPerHour);
            System.out.println(kilometersPerHour +
                    " km/h= " + milesPerHour +
                    " mi/h");
            return milesPerHour;

        }
    }   
 //-----------------------------------------------------------------------------------------------       
     
   /*** 
    public static void main(String[] args) {	  
    	  printConversion(25.42);
    	  printConversion(30.70);
    	  printConversion(0);
    	  printConversion(-1);
      }
   **/
    
}   

public class testSpeedConverter { 
	
	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter kilometers per hour:  ");
		int kph = scanner.nextInt();
		scanner.nextLine();
		
		double mph = 0.0;
		SpeedConverter2 converter = new SpeedConverter2();
		mph = converter.printConversion(kph);
		
		
		
		
		
		
		
		
	}
	
	
	
}