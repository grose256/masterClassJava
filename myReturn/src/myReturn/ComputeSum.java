package myReturn;

public class ComputeSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
    int sum = Add(4,6);
    System.out.println("The sum is : " + sum);
    String shouldBeUpper = caps("make me all upper case");
    System.out.println("The all upper case string is: " + shouldBeUpper);
    
    int[] myArray = getArrayFromInts(3,7,1);
    System.out.println(myArray);
    System.out.println(myArray[0]);
    System.out.println(myArray[1]);
    System.out.println(myArray[2]);
	}
	
	public static int Add(int a, int b) {
		int sum = 0;
	     sum = a + b;
		return sum;
	}
	
	public static String caps(String s) {
		return s.toUpperCase();
	}

	  public static int[] getArrayFromInts(int a , int b, int c) {
		  int[] array = new int[3];
		  array[0] = a;
		  array[1] = b;
		  array[2] = c;
		  return array;
	  }
}
