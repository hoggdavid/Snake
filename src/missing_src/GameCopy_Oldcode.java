package missing_src;

public class GameCopy_Oldcode {

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
