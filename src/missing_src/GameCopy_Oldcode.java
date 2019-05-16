package missing_src;

public class GameCopy_Oldcode {

    //public static int identical;

    public void getTotalscore(int generation) {
        // not yet used for optimizing mutationConst
    }

    public void letPlay(int u) {
        //select safed AI out of files
        //new class for letting an safed AI play
    }

    //after board myboard new board
	
	/*	G R A F I K
    EventQueue.invokeLater(new Runnable() {
    	
        public void run() {
            JFrame frame = new GameCopy();
            frame.setVisible(true);
        }
    });*/


    GameCopy_Oldcode() { // actually "GameCopy()"
        // G R A F I K
        //myBoard = new Board();
	    /*setResizable(false);
	    pack();
	    setTitle("Snake");
	    setLocationRelativeTo(null);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);*/
    }
	
	/*for (int o=0;o<14;o++){
		newGen.add(individuals.get(o));
	}
	for (int r=14;r<93;r++){
		newGen.add(individuals.get(r));
	}		between crossover and newPop		*/
	
/* D E B U G (are the lists the same?)
	if (individuals==newGen){
		System.out.println("same");
	}else{
		System.out.println("different"); //then sort() works--> other parents
	}		then "individuals = newGen			"*/
	
	/* ZWITTERVERFAHREN (13 best + copies)
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
	}*/
	
	
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
	
	
	/* ZWITTERVERFAHREN, ALLE MUTIEREN
	int j = 1;
	int k = 13;
	int jPlus = 13;
	int kPlus = 12;

	for (int l=0;l<12;l++){

		for (int r=j;r<k;r++){
			newGen.get(r);
			individual.mutate();
		}
		j = j+jPlus;
		k = k+kPlus;
		jPlus = jPlus -1;
		kPlus = kPlus -1;
	}*/
	
	
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
}

/* D E B U G (Snake x/y location)
System.out.println(myBoard.inGame);
System.out.println("Y"+k+" "+myBoard.snake.getSnakeY(k));
System.out.println("X"+k+" "+myBoard.snake.getSnakeX(k));*/


/* D E B U G (Snake x/y location)
 * for (int k=myBoard.snake.getJoints(); k>0;k--) {
		 
		 System.out.println("Y "+myBoard.snake.getSnakeY(k));
		 System.out.println("X "+myBoard.snake.getSnakeX(k));
		 System.out.println("-----------------------------");
	 }*/
/* D E B U G (score individual) (score)
if (a==0){
	System.out.println("Scores:");
	System.out.println("gen: "+ x +" score: "+ myBoard.getScore()+" moves: "+moves+" index "+patternIndex);
}
if (a==1){
	System.out.println("gen: "+ x +" score: "+ myBoard.getScore()+" moves: "+moves+" index "+patternIndex);	    	
}
if (a==2){
	System.out.println("gen: "+ x +" score: "+ myBoard.getScore()+" moves: "+moves+" index "+patternIndex);
	System.out.println("--------------------------------");
}*/

/* D E B U G (output individual 0)
int oh;
if (a==0){
for (oh=0;oh<4;oh++){
	System.out.println(individuals.get(0).getOutput(oh));
}
}*/

/* D E B U G (mutation, weights) (weights before sort)

if ((x<5000)&&(4996<x)){
		System.out.println("Before sort:");
		System.out.println("1st--");
		for (int oh=0;oh<4;oh++){
			System.out.println(individuals.get(0).Layers[2].Neurons.get(oh).Weights);
		}
		System.out.println("2nd--");
		for (int oh=0;oh<4;oh++){
			System.out.println(individuals.get(7).Layers[2].Neurons.get(oh).Weights);
			//System.out.println(individual.mutationConst);
		}
		System.out.println("3rd--");
		for (int oh=0;oh<4;oh++){
			System.out.println(individuals.get(8).Layers[2].Neurons.get(oh).Weights);
			//System.out.println(individual.mutationConst);
		}
		System.out.println("----------------------------------");
	}*/


/*for (int m=1;m<3;m++){
for (int j=0;j<individuals.get(0).Layers[i].Neurons.size();j++){
	for (int k=0;k<individuals.get(0).Layers[i].Neurons.get(j).Weights.size();k++){
		double weight1 = individuals.get(0).Layers[i].Neurons.get(j).Weights.get(k);
		double weight2 = individuals.get(1).Layers[i].Neurons.get(j).Weights.get(k);
		if (weight1==weight2){
			identical++;
		}
	}
}
}	

while (identical==520){
indiv2 = individuals.get(2);
}			has to be in a loop			*/


/* D E B U G (1/ ArrayList Size) 		
System.out.println("indiv1: "+individuals.size());
System.out.println("newGen1: "+newGen.size());*/


/* D E B U G (2/ ArrayList Size)
System.out.println("indiv2: "+individuals.size());
System.out.println("newGen1: "+newGen.size());*/


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


/*try{
GameCopy.write("score", Numbers);
} catch (IOException e) {
e.printStackTrace();
}*/