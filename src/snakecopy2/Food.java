package snakecopy2;

public class Food {

	private Snake snake = new Snake();
	private int foodX; 
	private int foodY; 
	public int[] patternX;
	public int[] patternY;
	
	public void addPattern(int[] pattern, int value, int place){
		pattern[place] = value;
	}
	
	public void createFood() {

			foodX = GameCopy.patternX[GameCopy.patternIndex];
			foodY = GameCopy.patternY[GameCopy.patternIndex];
	    	GameCopy.patternIndex++;
	    for (int i = 0; i<snake.getJoints();i++){
	    	
	    	if ((foodX == snake.getSnakeX(i)) && (foodY == snake.getSnakeY(i))) {
		        createFood();
		    }
	    }
	}

	public int getFoodX() {
		return foodX;
	}

	public int getFoodY() {
	    return foodY;
	}
}