package FZFJ_Core_Pkg;

import java.util.Random;

public class StringsTheory {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        System.out.println("======= String Methods =======");
        String s = " hello ";
        System.out.println("s.length  " + s.length());
        System.out.println(" s contains(\"he\")  " + s.contains("he"));
        System.out.println("s is empty   " + s.isEmpty());
        s.replace("ll","LL");
        System.out.println("new s is  " + s);
        System.out.println("  here is an escape \n     and then more");
        
        
        Random r = new Random();
        System.out.println("random " + r.nextInt());
        System.out.println(r.nextInt(100)); // any int from 0 to 99
        System.out.println(r.nextInt(100) + 1); // any int from 1 to 100
        System.out.println(r.nextInt(48)); // any int from 0 to 47
        
        
        
        
        
        
        
	}

}
