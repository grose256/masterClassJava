package processFromDatabase;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class printClaims {
	private static arrayClaims arrayClaim;


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x = 0;
		arrayClaim = new arrayClaims();
		List<String[]> varRow = arrayClaim.getTable() ;
		System.out.println(varRow);
		System.out.println("print something");
		for (x = 1;x < 2;x++) {
			System.out.println("test for");
		}
        for( String[] row: arrayClaim.getTable() ){
        	System.out.println("after 1st for ");
            for( String s: row ){
            	System.out.println("in for loop");
                System.out.print( " " + s );
            }
            System.out.println();
        }
   
        
    System.out.println("print after ");
	}
		

	}

