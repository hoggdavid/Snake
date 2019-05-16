package missing_src;

import snakecopy2.AI;
import snakecopy2.Board;

import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;

public class Game extends JFrame {

    public static AI individual;
    //public static ArrayList<AI> individuals;
    public static AI[] individuals;
    public static Board myBoard;
    public static int[] scores;

    Game() {
        add(new Board());
        setResizable(false);
        pack();
        individual = new AI();
        //Ai deklarieren
        setTitle("Snake");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void oneStep() {
        for (int k = 0; k < 100; k++) {
            individual.setInput(k, 0);
        }

        individual.setInput(myBoard.food.getFoodY() * 10 + myBoard.food.getFoodX(), 1);

        for (int k = myBoard.snake.getJoints(); k > 0; k--) {
            individual.setInput(myBoard.snake.getSnakeY(k) * 10 + myBoard.snake.getSnakeX(k), -1);
        }

        // EVALUATE OUTPUT

        double outputUp = individual.getOutput(0);
        double outputDown = individual.getOutput(1);
        double outputLeft = individual.getOutput(2);
        double outputRight = individual.getOutput(3);
        //(!snake.isMovingDown())

        if ((outputUp > outputDown) && (outputUp > outputLeft) && (outputUp > outputRight)) {
            myBoard.snake.setMovingUp(true);
            myBoard.snake.setMovingRight(false);
            myBoard.snake.setMovingLeft(false);
            myBoard.snake.setMovingDown(false);
        }

        if ((outputRight > outputDown) && (outputRight > outputLeft) && (outputRight > outputUp)) {
            myBoard.snake.setMovingUp(false);
            myBoard.snake.setMovingRight(true);
            myBoard.snake.setMovingLeft(false);
            myBoard.snake.setMovingDown(false);
        }

        if ((outputLeft > outputDown) && (outputLeft > outputUp) && (outputLeft > outputRight)) {
            myBoard.snake.setMovingUp(false);
            myBoard.snake.setMovingRight(false);
            myBoard.snake.setMovingLeft(true);
            myBoard.snake.setMovingDown(false);
        }

        if ((outputDown > outputUp) && (outputDown > outputLeft) && (outputDown > outputRight)) {
            myBoard.snake.setMovingUp(false);
            myBoard.snake.setMovingRight(false);
            myBoard.snake.setMovingLeft(false);
            myBoard.snake.setMovingDown(true);
        }

        myBoard.actionPerformed(null);
    }

    public static void main(String[] args) {

        //10'000er LOOP

        // Creates a new thread so our GUI can process itself
        EventQueue.invokeLater(new Runnable() {

            //100er LOOP

            public void run() {
                JFrame frame = new Game();
                frame.setVisible(true);
                // SWITCH OFF
            }
        });
    }
}

//--> in board change game over and initGame()
// --> Controls or Controller