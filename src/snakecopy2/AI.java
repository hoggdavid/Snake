package snakecopy2;
import snakecopy2.Neuron;
import snakecopy2.NeuronLayer;

public class AI implements Comparable<AI>{
	
	public int score;
	public double  mutationConst = 0.32;
	public Neuron[] InputNeurons;
	public Neuron[] HiddenNeurons;
	public Neuron[] OutputNeurons;
	public NeuronLayer[] Layers;
	
	public int generation;
	
	public static void addNeuron(Neuron[] Neurons, int anzahl){
		for (int i=0;i<anzahl;i++){
			Neurons[i] = new Neuron();
		}
	}
	
	public static void addLayer(NeuronLayer[] Layers, int anzahl){
		for (int i=0;i<anzahl;i++){
			Layers[i] = new NeuronLayer();
		}
	}
	
	public void randomize(){
		for (int i=1;i<3;i++){
			for (int j=0;j<Layers[i].Neurons.size();j++){
				for (int k=0;k<Layers[i].Neurons.get(j).Weights.size();k++){
					double w = Layers[i].Neurons.get(j).Weights.get(k);
					w = w + mutationConst * (Math.random()*2-1);
					Layers[i].Neurons.get(j).Weights.set(k, w);
					
	// lower mutationConstant if present generationScore is higher than predecessors generationScore
	// otherwise increase the mutationConstant
	// int generation; w void getGen and getTotal it could work
					
				}
			}
		}
	}
	
	public int compareTo(AI o) {
        int f1 = this.score;
        int f2 = o.score;
 
        if (f1 < f2)
            return 1;
        else if (f1 > f2)
            return -1;
        else
            return 0;
    }

	public void setInput(int num, double output){
		InputNeurons[num].setOutput(output);
	}
	
	public double getOutput(int num){
		return OutputNeurons[num].getOutput();
	}
	
	public void setScore(int newScore){
		score = newScore;
	}
	
	public void initialize(){
		
		int in, hid, out, layer;
		in = 100;
		hid = 5;
		out = 4;
		layer = 3;
		
		InputNeurons = new Neuron[in];
		addNeuron(InputNeurons, in);
		HiddenNeurons = new Neuron[hid];
		addNeuron(HiddenNeurons, hid);
		OutputNeurons = new Neuron[out];
		addNeuron(OutputNeurons, out);
		
		Layers = new NeuronLayer[layer];
		addLayer(Layers, layer);
		
		// CONNECTING
		for (int hidden=0;hidden<5;hidden++){
			for (int inner=0;inner<100;inner++){
				HiddenNeurons[hidden].connectTo(InputNeurons[inner], 2*Math.random()-1.0);
			}
			
			Layers[1].addNeuron(HiddenNeurons[hidden]);
			
			for (int outer=0;outer<4;outer++){
				OutputNeurons[outer].connectTo(HiddenNeurons[hidden], 2*Math.random()-1.0);
			}
		}
		
		for (int inner=0;inner<100;inner++){
			Layers[0].addNeuron(InputNeurons[inner]);
		}
		
		for (int outer=0;outer<4;outer++){
			Layers[2].addNeuron(OutputNeurons[outer]);
		}
	}
}