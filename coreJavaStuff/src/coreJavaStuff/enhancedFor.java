package coreJavaStuff;

public class enhancedFor {
	
	public static void main(String args[]) {
		int nums[] = {1,2,3,4,5,6,7,8,9,10};
		int sum = 0;
		boolean found = false;
		
		for (int x : nums) {
			if (x == 5) {
				System.out.println("We found a 5");
				found = true;
				break;
			}
			else if (x != 5) {
				System.out.println("the non 5 value is " + x);
			}
			
				
			
		}
		
		if (found) {
			System.out.println("Yes we found it!");
		}
		
		
		
	}
	
}
