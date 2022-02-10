package FZFJ_Core_Pkg;

import java.util.Arrays;

/**
 * javadoc for Application
 * 
 * @author grose
 *
 */

public class Comments_Data_Types {
	/**
	 * the entry point to the program
	 * 
	 * @param args input arguments
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub - comment
		/*
		 * -------------------------------
		 * 
		 * multi line comments
		 * 
		 * 
		 * 
		 * -------------------------
		 */

		// javadoc - generate javadoc html doc out of class

		byte mybyte = 111;
		int bin = 0b1011; // 0b prefix
		int oct = 07205; // 0 prefix
		int hex = 0x13AE; // 0x prefix
		int band = 0xACDC;

		System.out.println("bin val is : " + bin);

		System.out.println("The byte val is " + mybyte);
		System.out.println("oct is  " + oct);
		System.out.println("hex is   " + hex);
		System.out.println("band is  " + band);

		int[] arr;
		arr = new int[10];
		System.out.println("arr length " + arr.length);
		System.out.println("arr first member " + arr[0]);
		double[] arr2 = new double[10];
		int[] arr5 = { 3, 2, 1 };
		int[][] matrix = { { 1, 2, 3 }, { 4, 5, 6 } };
		int[][] matrix2 = new int[10][10];
		System.out.println(Arrays.toString(matrix2));
		int i = 1;
		int a1 = 0;
		System.out.println("a1  " + a1);
        a1 = 10;
        System.out.println("a1  " + a1);
        a1 = ++i;
        System.out.println("i  is " + i);
        System.out.println("a1  " + a1);
        a1 = i++;
        System.out.println("a1  " + a1);
        System.out.println("i  is " + i);
	}

}




