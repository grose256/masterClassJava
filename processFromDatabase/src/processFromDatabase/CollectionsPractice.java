package processFromDatabase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CollectionsPractice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
    int[] myArray = new int[10];
    
    int[] nextArray = new int[] {1,2,3,4,5,6,7,8,9,0};
    System.out.println("nextarray "+nextArray[3]);
     System.out.println("myArray " + myArray);
    
    myArray[0] = 3;
    myArray[1] = 4;
    myArray[9] = 5;
    System.out.println(Arrays.mismatch(myArray,nextArray));
    System.out.println("myArray " + myArray);
    int id = myArray[0];
    System.out.println(id);
	for(int num: myArray) {
		System.out.println(num);
	}

	System.out.println(myArray.length);
	
	Arrays.sort(myArray);    // sort array
	System.out.println(Arrays.toString(myArray));
	System.out.println(Arrays.toString(args));
	
	// - ------------------ arraylist
	
	ArrayList arrl1 = new ArrayList();
	ArrayList arrl2 = new ArrayList(100);  //older java 5 syntax
	ArrayList<String> colors = new ArrayList<String>();
	colors.add("blue");
	colors.add("red");
	colors.add("white");
	colors.add(1,"orange");
	System.out.println("the second color is " + colors.get(1));
	
	
	for(String color: colors) {
		System.out.println("the color is " + color);
	}
	
	colors.remove(1);
	for(String color: colors) {
		System.out.println("the color is " + color);
	}
	
	// convert array to list
	String[] shapes = new String[] {"square","circle","triangle"};
	List shapeList = Arrays.asList(shapes);
	System.out.println(shapeList);
	
	System.out.println(shapeList.getClass().getName());
	System.out.println(colors.getClass().getName());
	
	List<String> shapeList3 = new ArrayList<> ();
	for(String shape: shapes) {
		shapeList3.add(shape);
	}
	System.out.println("Array shapeList3 "+shapeList3);
	
	System.out.println("element 1 of arraylist  " + shapeList3.get(1));
	
    	
	
	
	
	
	
	

   } //method main
	
} //class