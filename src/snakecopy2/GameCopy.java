package snakecopy2;
import snakecopy2.AI;
import java.awt.EventQueue;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

import javax.swing.JFrame;

public class GameCopy extends JFrame{

	public static AI individual;
	public static LinkedList<AI> individuals = new LinkedList<AI>();
	public static Board myBoard;
	public static int[] scores;
	public static int moves;
    public static int maxMoves;
    public static int gen;
    public static int x;
	
	public boolean randomizeFunction;
	public ArrayList<Double> weightsBefore;
	
	GameCopy() {
	    // G R A F I K
		//myBoard = new Board();
	    /*setResizable(false);
	    pack();
	    setTitle("Snake");
	    setLocationRelativeTo(null);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);*/
	}
	
	public int getCurrentGen(){
		return x;
	} // useless, wrong programming for createFood() after createPattern
	
	public int getCurrentMove(){
		return moves;
	} // useless, wrong programming for createFood() after createPattern
	
	public static void setGenerations(int i){
		gen = i;
	}
	
	public int getGenerations(){
		return gen;
	}
	
	public static void setMoves(int i){
		maxMoves = i;
	}
	
	public int getMaxMoves(){
		return maxMoves;
	}
	
	public void getTotalscore (int generation){
		
	}
	
	public int getGeneration (int generation){
		return generation;
	}
	//for what?
	public void letPlay(int u){
		//select safed AI
		//new class for letting an safed AI play
	}
	//safe individual
	public static void write (String filename, ArrayList<Double>p) throws IOException{
		  BufferedWriter outputWriter = null;
		  outputWriter = new BufferedWriter(new FileWriter(filename));
		  for (int i = 0; i < p.size(); i++) {
		    outputWriter.write(Double.toString((p.get(i))));
		    outputWriter.newLine();
		  }
		  outputWriter.flush();  
		  outputWriter.close();  
		}
	
	public void load(int u){
	}
	
	public static void oneStep(int player){
		
		individual = individuals.get(player);
		for (int k=0;k<100;k++){
        	individual.setInput(k,0);
        	}
        	
        	individual.setInput(myBoard.food.getFoodY()*10 + myBoard.food.getFoodX(), 1);
        	
        	 for (int k=myBoard.snake.getJoints(); k>0;k--) {
        		 
/* D E B U G (Snake x/y location)
        		  * System.out.println(myBoard.inGame);
        		 System.out.println("Y"+k+" "+myBoard.snake.getSnakeY(k));
        		 System.out.println("X"+k+" "+myBoard.snake.getSnakeX(k));*/
        		 
        		 individual.setInput(myBoard.snake.getSnakeY(k)* 10 + myBoard.snake.getSnakeX(k), -2);
        	 }
        	 
individual.setInput(myBoard.snake.getSnakeY(0)* 10 + myBoard.snake.getSnakeX(0), -1);
        	 
        	 // EVALUATE OUTPUT ANN
        	 individual.Layers[1].updateLayer();
        	 individual.Layers[2].updateLayer();
        	 
        	 // GET OUTPUT ANN
        	 double outputUp = individual.getOutput(0);
        	 double outputDown = individual.getOutput(1);
        	 double outputLeft = individual.getOutput(2);
        	 double outputRight = individual.getOutput(3);
        	 
        	 //(!snake.isMovingDown())
        	 
        	 if ((outputUp>outputDown)&&(outputUp>outputLeft)&&(outputUp>outputRight)&&(!myBoard.snake.isMovingDown())){
        		myBoard.snake.setMovingUp(true);
 	            myBoard.snake.setMovingRight(false);
 	            myBoard.snake.setMovingLeft(false);
 	            myBoard.snake.setMovingDown(false);
        	 }
        	 
        	 if ((outputRight>outputDown)&&(outputRight>outputLeft)&&(outputRight>outputUp)&&(!myBoard.snake.isMovingLeft())){
        		myBoard.snake.setMovingUp(false);
  	            myBoard.snake.setMovingRight(true);
  	            myBoard.snake.setMovingLeft(false);
  	            myBoard.snake.setMovingDown(false);
        	 }
        	 
        	 if ((outputLeft>outputDown)&&(outputLeft>outputUp)&&(outputLeft>outputRight)&&(!myBoard.snake.isMovingRight())){
        		myBoard.snake.setMovingUp(false);
  	            myBoard.snake.setMovingRight(false);
  	            myBoard.snake.setMovingLeft(true);
  	            myBoard.snake.setMovingDown(false);
        	 }
        	 
        	 if ((outputDown>outputUp)&&(outputDown>outputLeft)&&(outputDown>outputRight)&&(!myBoard.snake.isMovingUp())){
        		myBoard.snake.setMovingUp(false);
  	            myBoard.snake.setMovingRight(false);
  	            myBoard.snake.setMovingLeft(false);
  	            myBoard.snake.setMovingDown(true);
        	 }
        	 
        	 myBoard.actionPerformed(null);
	}

	public static void main(String[] args) {
		
		for (int day7=0;day7<100;day7++){
			individual = new AI();
			individual.initialize();
			individuals.add(individual);
		}
		
		setGenerations(10000);
// CHANGED
		for (x=0;x<gen;x++){
	
		for (int a=0;a<100;a++){
		
			myBoard = new Board();
		   	 
/* D E B U G (Snake x/y location)
			 * for (int k=myBoard.snake.getJoints(); k>0;k--) {
		   		 
		   		 System.out.println("Y "+myBoard.snake.getSnakeY(k));
		   		 System.out.println("X "+myBoard.snake.getSnakeX(k));
		   		 System.out.println("-----------------------------");
		   	 }*/
			
		/*	G R A F I K
	    EventQueue.invokeLater(new Runnable() {
	    	
	        public void run() {
	            JFrame frame = new GameCopy();
	            frame.setVisible(true);
	        }
	    });*/
			
	    moves =0;
	    setMoves(10000);
	    /*int moves=0;
	     * int maxMoves = 10'000;
	     */
	    while ((myBoard.inGame==true)){
	    	oneStep(a);
	    	moves++;
	    	if (moves > maxMoves){
	    		myBoard.inGame = false;
	    	}
	    } 
	    
	    individuals.get(a).setScore(myBoard.getScore());
	    
	    
/* D E B U G (score individual) (score)
	    if ((x<5000) && (4996<x)){
	    	if (a==0){
	    		System.out.println("Scores:");
	    		System.out.println(x + "-1st" + myBoard.getScore());
	    	}
	    	if (a==13){
	    		System.out.println(x + "-2nd" + myBoard.getScore());
	    	}
	    	if (a==25){
	    		System.out.println(x + "-3rd" + myBoard.getScore());
	    		System.out.println("--------------------------------");
	    	}
	    }*/
	    
/* D E B U G (output individual 0)
	    int oh;
		if (a==0){
			for (oh=0;oh<4;oh++){
				System.out.println(individuals.get(0).getOutput(oh));
			}
		}*/
	    
	}
		
/* D E B U G (mutation, weights) (weights before sort)
	    
				if ((x<5000)&&(4996<x)){
						System.out.println("Before sort:");
						System.out.println("1st--");
						for (int oh=0;oh<4;oh++){
							System.out.println(individuals.get(0).Layers[2].Neurons.get(oh).Weights);
						}
						System.out.println("2nd--");
						for (int oh=0;oh<4;oh++){
							System.out.println(individuals.get(13).Layers[2].Neurons.get(oh).Weights);
							//System.out.println(individual.mutationConst);
						}
						System.out.println("3rd--");
						for (int oh=0;oh<4;oh++){
							System.out.println(individuals.get(25).Layers[2].Neurons.get(oh).Weights);
							//System.out.println(individual.mutationConst);
						}
						System.out.println("----------------------------------");
					}*/
				
		int totalscore=0;
		for (int k=0;k<100;k++){
			totalscore += individuals.get(k).score;
		}
		
// D E B U G (generation score)
		System.out.println("gen "+x+" total "+totalscore);
		
		//Genetic Algorithm
		Collections.sort(individuals);
		LinkedList<AI> newGen = new LinkedList<AI>();
		//13 best + copies
		for (int o=0;o<13;o++){
			for (int z=13;z>o;z--){
				newGen.add(individuals.get(o));
				//individuals 0/90 
			}
		}
		
		for (int n=0;n<9;n++){
			individual = new AI();
			individual.initialize();
			newGen.add(individual);
			//individuals 91/99 
		}
		
/* D E B U G (1/ randomize control) (sort control)
		
		if ((x<5000)&&(4996<x)){
			System.out.println("After sort / Before randomize:");
			System.out.println("1st--");
			for (int oh=0;oh<4;oh++){
				System.out.println(individuals.get(0).Layers[2].Neurons.get(oh).Weights);
				//System.out.println(individual.mutationConst);
			}
			System.out.println("2nd--");
			for (int oh=0;oh<4;oh++){
				System.out.println(individuals.get(13).Layers[2].Neurons.get(oh).Weights);
				//System.out.println(individual.mutationConst);
			}
			System.out.println("3rd--");
			for (int oh=0;oh<4;oh++){
				System.out.println(individuals.get(25).Layers[2].Neurons.get(oh).Weights);
				//System.out.println(individual.mutationConst);
			}
			System.out.println("----------------------------------");
		}*/
		
		// R A N D O M I Z E
		int j = 1;
		int k = 13;
		int jPlus = 13;
		int kPlus = 12;
	
		for (int l=0;l<12;l++){

			for (int r=j;r<k;r++){
				newGen.get(r);
				individual.randomize();
			}
			j = j+jPlus;
			k = k+kPlus;
			jPlus = jPlus -1;
			kPlus = kPlus -1;
		}
		
/* D E B U G (2/ randomize control)
		
		if ((x<5000)&&(4996<x)){
			System.out.println("After randomize:");
			System.out.println("1st--");
			for (int oh=0;oh<4;oh++){
				System.out.println(individuals.get(0).Layers[2].Neurons.get(oh).Weights);
				//System.out.println(individual.mutationConst);
			}
			System.out.println("2nd--");
			for (int oh=0;oh<4;oh++){
				System.out.println(individuals.get(13).Layers[2].Neurons.get(oh).Weights);
				//System.out.println(individual.mutationConst);
			}
			System.out.println("3rd--");
			for (int oh=0;oh<4;oh++){
				System.out.println(individuals.get(25).Layers[2].Neurons.get(oh).Weights);
				//System.out.println(individual.mutationConst);
			}
			System.out.println("--------------------------------");
		}*/
		
		if (x==(gen-1)){
			for (int layer=1;layer<3;layer++){
				for (int n=0;n<newGen.get(0).Layers[layer].Neurons.size();n++){
					
					ArrayList<Double>FinalWeights;
					FinalWeights = new ArrayList<Double>();
					for (int w=0;w<newGen.get(0).Layers[layer].Neurons.get(n).Weights.size();w++){
						FinalWeights.add(newGen.get(0).Layers[layer].Neurons.get(n).Weights.get(w));
					}
					try {
						GameCopy.write("AI_gen("+x+")_layer("+layer+")_neuron("+n+")", FinalWeights);
						System.out.println(FinalWeights);
					} catch (IOException e) {
						e.printStackTrace();
					}
					
				}
			}
		}
	}		
}
}

//Board change game over and initGame()