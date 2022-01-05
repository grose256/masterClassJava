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
    public  double printConversion(double kilometersPerHour) {

        if(kilometersPerHour < 0.0) {
            return -1;
        } else {
            double milesPerHour = toMilesPerHour(kilometersPerHour);
   //         System.out.println(kilometersPerHour +
   //                 " km/h= " + milesPerHour +
   //                 " mi/h");
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


	
	
