package FZFJ_Core_Pkg;
import java.util.Scanner;

public class ReadInput {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Pleas, enter any word: ");
		String word = sc.next();
		System.out.println("you entered  " + word);
		System.out.print("Please enter any integer number ");
        int i = sc.nextInt();
        System.out.println("you entered the integer " + i);
        
	}

}
