package sect4methods.LearningAcademy;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// section 4
 	boolean gameOver = true;
 	int score = 800;
 	int levelCompleted = 5;
 	int bonus = 500;
 	
    int highScore = 	calculateScore(gameOver,score,levelCompleted,bonus);
    System.out.println("Your final score was  " + highScore);
 	
 	score = 10000;
 	levelCompleted = 8;
 	bonus = 200;
 	
 	calculateScore(gameOver,score,levelCompleted,bonus);
	
	
		

	}
	
	
	
	 public static int calculateScore(boolean gameOver,int score, int levelCompleted, int bonus) {

	        if(gameOver) {
	            int finalScore = score + (levelCompleted * bonus);
	            finalScore += 2000;
	//            System.out.println("Your final score was " + finalScore);
	            return finalScore;
	        }

	        return -1;   //send back if game over isn't true - if equal false

	    }

}
