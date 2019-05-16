package snakecopy2;

import java.util.LinkedList;

import snakecopy2.Neuron;
import snakecopy2.NeuronLayer;

public class AI implements Comparable<AI> {

    public int score;
    public int movesToScore;
    public int fitness;
    public double dice;
    public double uniformRate = 0.5; //constant
    public double crossoverProb = 0.6; //0.6
    public double mutationConst = 0.1; //0.15
    public double mutationRate = 0.1; //0.001
    public Neuron[] InputNeurons;
    public Neuron[] HiddenNeurons;
    public Neuron[] OutputNeurons;
    public NeuronLayer[] Layers;

    public static void addNeuron(Neuron[] Neurons, int anzahl) {
        for (int i = 0; i < anzahl; i++) {
            Neurons[i] = new Neuron();
        }
    }

    public static void addLayer(NeuronLayer[] Layers, int anzahl) {
        for (int i = 0; i < anzahl; i++) {
            Layers[i] = new NeuronLayer();
        }
    }

    public void crossover(AI child, AI indiv1, AI indiv2, LinkedList<AI> generation) {
        if (Math.random() <= crossoverProb) {
            for (int i = 1; i < 3; i++) {
                for (int j = 0; j < this.Layers[i].Neurons.size(); j++) {
                    for (int k = 0; k < this.Layers[i].Neurons.get(j).Weights.size(); k++) {

                        if (Math.random() <= uniformRate) {
                            this.Layers[i].Neurons.get(j).Weights.set(k, indiv1.Layers[i].Neurons.get(j).Weights.get(k));
                        } else {
                            this.Layers[i].Neurons.get(j).Weights.set(k, indiv2.Layers[i].Neurons.get(j).Weights.get(k));
                        }
                    }
                }
            }
            returnSol(child);
            mutate();
            generation.add(child);
        } else {
            generation.remove(child);
        }
    }

    public AI returnSol(AI sol) {
        return sol;
    }

    public void mutate() {
        for (int i = 1; i < 3; i++) {
            for (int j = 0; j < Layers[i].Neurons.size(); j++) {
                for (int k = 0; k < Layers[i].Neurons.get(j).Weights.size(); k++) {
                    double w = Layers[i].Neurons.get(j).Weights.get(k);
                    if (Math.random() <= mutationRate) {
                        w = w + mutationConst * (Math.random() * 2 - 1);
                    }
                    Layers[i].Neurons.get(j).Weights.set(k, w);
                }
            }
        }
    }

    public int compareTo(AI o) {
        double f1 = this.dice;
        double f2 = o.dice;

        if (f1 < f2)
            return 1;
        else if (f1 > f2)
            return -1;
        else
            return 0;
    }

    public void Fitness() {
        this.fitness = this.score * 5000 - this.movesToScore;
    }

    public void setMovesToScore(int a) {
        this.movesToScore = a;
    }

    public void setInput(int num, double output) {
        InputNeurons[num].setOutput(output);
    }

    public double getOutput(int num) {
        return OutputNeurons[num].getOutput();
    }

    public void setScore(int newScore) {
        score = newScore;
    }

    public void initialize() {

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

        for (int hidden = 0; hidden < 5; hidden++) {
            for (int inner = 0; inner < 100; inner++) {
                HiddenNeurons[hidden].connectTo(InputNeurons[inner], 2 * Math.random() - 1.0);
            }

            Layers[1].addNeuron(HiddenNeurons[hidden]);

            for (int outer = 0; outer < 4; outer++) {
                OutputNeurons[outer].connectTo(HiddenNeurons[hidden], 2 * Math.random() - 1.0);
            }
        }

        for (int inner = 0; inner < 100; inner++) {
            Layers[0].addNeuron(InputNeurons[inner]);
        }

        for (int outer = 0; outer < 4; outer++) {
            Layers[2].addNeuron(OutputNeurons[outer]);
        }
    }
}