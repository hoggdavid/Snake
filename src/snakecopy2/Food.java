package snakecopy2;

public class Food {

	private Snake snake = new Snake();
	private int foodX; // Stores X pos of our food
	private int foodY; // Stores Y pos of our food
	public int[] patternX;
	public int[] patternY;
	
	public void addPattern(int[] pattern, int value, int place){
		pattern[place] = value;
	}

	/*public void createPattern(){
		
		patternX = new int[game.getMaxMoves()];
		patternY = new int[game.getMaxMoves()];
		
		for (int loop=0;loop<game.getMaxMoves();loop++){
			
			int locationX = (int) (Math.random() * Board.getBoardWidthVirt());
			addPattern(patternX, locationX, loop);
		    //patternX[loop] = locationX;
		    int locationY = (int) (Math.random() * Board.getBoardHeightVirt());
		    addPattern(patternY, locationY, loop);
		    //patternY[loop] = locationY;
		    
		}
	}*/
	
	public void createFood() {

			foodX = GameCopy.patternX[GameCopy.patternIndex];
			foodY = GameCopy.patternY[GameCopy.patternIndex];
	    	
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
