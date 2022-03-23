package FZFJ_Core_Pkg;

public class JavaQuiz1 
{
	int a=10;
	public void method(int a) 
	{
		a += 1;
		System.out.println(++a);
		System.out.println(a++);
	}
	
	public static void main(String[] args)
	{
	    JavaQuiz1 t = new JavaQuiz1();
	    t.method(6);
	}
	
	 

}
