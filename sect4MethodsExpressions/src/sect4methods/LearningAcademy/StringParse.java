package sect4methods.LearningAcademy;

public class StringParse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String numberAsString = "2018";
		System.out.println("numberAsString " + numberAsString);
		// convert text into number - using parse 
		int number = Integer.parseInt(numberAsString);
		System.out.println("number  = " + number);
		
		numberAsString += 1;  // appends 1 to string 20181
		number += 1;          // 2019 - treats as int 
		System.out.println(numberAsString);
		System.out.println(number);
		
		
		
		
		
		

	}

}
