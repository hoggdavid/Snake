package snakecopy2;

import java.util.Arrays;

public class PatternGenerator {
    // code by Patrick Spengler
    public static void main(String[] args) {

        int nFoods = 5000;
        int boardSizeX = 150 / 15;
        int boardSizeY = 150 / 15;
        int patternX[];
        int patternY[];

        patternX = new int[nFoods];
        patternY = new int[nFoods];

        for (int i = 0; i < nFoods; i++) {

            patternX[i] = (int) (Math.random() * boardSizeX);
            patternY[i] = (int) (Math.random() * boardSizeY);

        }

        System.out.println("public static int patternX[] = " + Arrays.toString(patternX));
        System.out.println("public static int patternY[] = " + Arrays.toString(patternY));
    }
}
