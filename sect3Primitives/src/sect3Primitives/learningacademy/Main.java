package sect3Primitives.learningacademy;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        int myValue = 10000;
        int myMinIntValue = Integer.MIN_VALUE;
        int myMaxIntValue = Integer.MAX_VALUE;
        int myOtherIntValue = Integer.SIZE;
        int breakMyInt = myMaxIntValue + 1;
        
       System.out.println("other int size: " + myOtherIntValue);
       System.out.println("break it is  " + breakMyInt);   // overflow happens 
       System.out.println("Int min val  is: " + myMinIntValue);
       System.out.println("Int max  val  is: " + myMaxIntValue);
       
       int myUnderscore = 2_147_483_647;
       System.out.println(myUnderscore);
       
       int myTotal = (myUnderscore / 2);
       byte myNewByte = (byte)(myUnderscore / 2);  // cast as a byte
       System.out.println("myNewByte  " + myNewByte);
       
       // floating point  float vs double
       
       double pounds = 200.0;
       double kilograms = 0.0;
       kilograms = (pounds * 0.45359237);
       System.out.println("kilograms is :  " + kilograms);
       
       boolean isTwentyOne = true; 
       
       if (isTwentyOne) {
    	   System.out.println("serve them beer" );
       }
       else {
    	   System.out.println("don't serve");
       }
       String myString = "This is a string";
       myString = myString + ", and also this phrase. ";
       System.out.println(myString);
       
       
       
    		   
    		   
    		   
    		   
       
       
       
       
       
       
      
	}

}
