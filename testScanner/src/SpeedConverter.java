
import java.util.Scanner;	
public class SpeedConverter {
    private double kilometersPerHour;

// constructor

SpeedConverter(double kph) {
    
    kilometersPerHour = kph;

}


//-------------------------------------------------------------------------------------------
    public  double toMilesPerHour() {

        if(kilometersPerHour <= 0) {
            return -1;
        }

        return (kilometersPerHour / 1.609);
    }
/***-------------------------------------------------------------------------------------
    public  double printConversion(double kilometersPerHour) {

        if(kilometersPerHour <0) {
            System.out.println("Invalid Value");
        } else {
            double milesPerHour = toMilesPerHour(kilometersPerHour);
            
            return milesPerHour;

        }
     */

    }   
 //-----------------------------------------------------------------------------------------------       
      


