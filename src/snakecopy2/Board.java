package snakecopy2;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.Timer;

public class Board extends JPanel implements ActionListener {

    public final static int BOARDWIDTH = 150;
    public final static int BOARDHEIGHT = 150; //900.630
    public int totaltime = 0;
    int turns;
    public int movesToLastFood;
    public int movesTo2ndLast;
    public final static int PIXELSIZE = 15;
    public final static int BOARDWIDTHVIRT = BOARDWIDTH / PIXELSIZE;
    public final static int BOARDHEIGHTVIRT = BOARDHEIGHT / PIXELSIZE;
    public final static int TOTALPIXELS = (BOARDWIDTH * BOARDHEIGHT) / (PIXELSIZE * PIXELSIZE);
    public boolean inGame = true;
    private Timer timer;
    private int timeperiod = 300;

    public Snake snake = new Snake();
    public Food food = new Food();

    public Board() {
        initializeGame();
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        draw(g);
    }

    void draw(Graphics g) {
        if (inGame == true) {
            g.setColor(Color.black);
            g.fillRect(food.getFoodX() * PIXELSIZE, food.getFoodY() * PIXELSIZE, PIXELSIZE, PIXELSIZE);

            for (int i = 0; i < snake.getJoints(); i++) {
                if (i == 0) {
                    g.setColor(Color.white);
                    g.fillRect(snake.getSnakeX(i) * PIXELSIZE, snake.getSnakeY(i) * PIXELSIZE,
                            PIXELSIZE, PIXELSIZE);
                } else {
                    g.fillRect(snake.getSnakeX(i) * PIXELSIZE, snake.getSnakeY(i) * PIXELSIZE, PIXELSIZE, PIXELSIZE);
                }
            }

            // Sync our graphics together
            Toolkit.getDefaultToolkit().sync();
        } else {
            endGame(g);
        }
    }

    void initializeGame() {

        totaltime = 0;
        turns = 0;
        //food.createPattern();
        snake.setJoints(3);
        GameCopy.patternIndex = 0;
        food.createFood();
        for (int i = 0; i < snake.getJoints(); i++) {
            snake.setSnakeX(BOARDWIDTHVIRT / 2);
            snake.setSnakeY(BOARDHEIGHTVIRT / 2);
        }

        snake.setMovingRight(true);
        snake.move();
        snake.move();
        snake.move();

        //make the game move
        timer = new Timer(timeperiod, this);
        timer.start();
    }

    void checkFoodCollisions() {

        if ((snake.getSnakeX(0) == food.getFoodX()) && (snake.getSnakeY(0) == food.getFoodY())) {

            GameCopy.myBoard.movesTo2ndLast = GameCopy.myBoard.movesToLastFood;
            GameCopy.myBoard.movesToLastFood = 0;
            snake.setJoints(snake.getJoints() + 1);
            food.createFood();
        }
    }

    void checkCollisions() {

        for (int i = snake.getJoints(); i > 0; i--) {

            // Snake can't intersect with itself if it's not larger than 5
            if ((i > 5) && (snake.getSnakeX(0) == snake.getSnakeX(i) && (snake.getSnakeY(0) == snake.getSnakeY(i)))) {
                inGame = false;
                GameCopy.myBoard.movesTo2ndLast = GameCopy.myBoard.movesToLastFood;
                GameCopy.myBoard.movesToLastFood = 0;
            }
        }

        if (snake.getSnakeY(0) >= BOARDHEIGHTVIRT) {
            inGame = false;
        }

        if (snake.getSnakeY(0) < 0) {
            inGame = false;
        }

        if (snake.getSnakeX(0) >= BOARDWIDTHVIRT) {
            inGame = false;
        }

        if (snake.getSnakeX(0) < 0) {
            inGame = false;
        }

        if (!inGame) {
            timer.stop();
        }
    }

    public int getScore() {
        int score = snake.getJoints() - 2;
        return score;
    }

    void endGame(Graphics g) {

        String message = "Game over";
        String info = "Press Enter To Restart";
        Font font = new Font("Times New Roman", Font.BOLD, 20);
        FontMetrics metrics = getFontMetrics(font);
        Font fontinfo = new Font("Times New Roman", Font.ITALIC, 14);
        FontMetrics metricsinfo = getFontMetrics(fontinfo);
        g.setColor(Color.black);
        g.setFont(font);
        g.drawString(message, (BOARDWIDTH - metrics.stringWidth(message)) / 2, BOARDHEIGHT / 2);
        g.setColor(Color.red);
        g.setFont(fontinfo);
        g.drawString(info, (BOARDWIDTH - metrics.stringWidth(info)) / 2 + 33, BOARDHEIGHT / 2 + 20);
        System.out.println("Game Ended");
        System.out.println("Your time: " + totaltime / 1000 + "s");
    }

    public void actionPerformed(ActionEvent e) {
        if (inGame == true) {

            snake.move();
            GameCopy.myBoard.movesToLastFood++;
            checkFoodCollisions();
            checkCollisions();
        }

        totaltime = totaltime + timeperiod;
        // Repaint or 'render' our screen
        repaint();
    }

    private class Keys extends KeyAdapter {

        public void keyPressed(KeyEvent e) {

            int key = e.getKeyCode();

            if ((key == KeyEvent.VK_LEFT) && (!snake.isMovingRight())) {
                snake.setMovingLeft(true);
                snake.setMovingUp(false);
                snake.setMovingDown(false);
            }

            if ((key == KeyEvent.VK_RIGHT) && (!snake.isMovingLeft())) {
                snake.setMovingRight(true);
                snake.setMovingUp(false);
                snake.setMovingDown(false);
            }

            if ((key == KeyEvent.VK_UP) && (!snake.isMovingDown())) {
                snake.setMovingUp(true);
                snake.setMovingRight(false);
                snake.setMovingLeft(false);
            }

            if ((key == KeyEvent.VK_DOWN) && (!snake.isMovingUp())) {
                snake.setMovingDown(true);
                snake.setMovingRight(false);
                snake.setMovingLeft(false);
            }

            if ((key == KeyEvent.VK_ENTER) && (inGame == false)) {

                inGame = true;
                snake.setMovingDown(false);
                snake.setMovingRight(false);
                snake.setMovingLeft(false);
                snake.setMovingUp(false);
                initializeGame();
            }
        }
    }

    private boolean proximity(int a, int b, int closeness) {
        return Math.abs((long) a - b) <= closeness;
    }

    public static int getAllDots() {
        return TOTALPIXELS;
    }

    public static int getDotSize() {
        return PIXELSIZE;
    }

    public static int getBoardHeightVirt() {
        return BOARDHEIGHTVIRT;
    }

    public static int getBoardWidthVirt() {
        return BOARDWIDTHVIRT;
    }
}