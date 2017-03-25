package com.snake;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by Anon on 03.03.2017.
 */
public class GUI {
    private JFrame frame;
    private JPanel panel;
    private final String FRAME_TITLE = "Classic Game Snake";
    public static final int FIELD_WIDTH = 30;
    public static final int FIELD_HEIGHT = 20;
    public static final int DX = 15;
    public static final int DY = 20;
    private final int START_SNAKE_X = 10;
    private final int START_SNAKE_Y = 10;
    private final int START_DIRECTION = 39;
    private String GAME_OVER_MSG = "GAME OVER!!!";
    boolean gameOver = false;
    Canvas canvas;
    Snake snake;
    Food food;
    Poison poison;

    public void startGUI() {
        frame = new JFrame(FRAME_TITLE);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        canvas = new Canvas();
        canvas.setBackground(Color.white);
        frame.getContentPane().add(BorderLayout.CENTER,canvas);
        frame.setSize(FIELD_WIDTH*Point.POINT_RADIUS+DX,FIELD_HEIGHT*Point.POINT_RADIUS+DY);
        frame.setVisible(true);

        snake = new Snake(START_SNAKE_X, START_SNAKE_Y, 7, START_DIRECTION);
        food = new Food();
        poison = new Poison();
        frame.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                snake.setDirection(e.getKeyCode());
            }
        });


        do
        {

            //boolean gameOver = false;
            canvas.repaint();
            snake.move();

            gameOver = snake.isEatenYourself(snake.snake.get(0).getX(), snake.snake.get(0).getY());

            if(food.isEaten(snake.snake.get(0).getX(), snake.snake.get(0).getY())) {
                snake.snake.add(0,new Point(food.getX(),food.getY()));
                food.createFood();
            }

            if(poison.isEaten(snake.snake.get(0).getX(), snake.snake.get(0).getY())) {
                for (int i=0;i<2;i++) {
                    snake.snake.remove(snake.snake.size()-1);
                    canvas.repaint();
                    if (snake.snake.size() < 5)
                        gameOver = true;
                }
                for (int i=0;i<2;i++) {
                    poison.createPoison();
                    canvas.repaint();
                }
            }
            /*if (snake.isEatenYourself(snake.snake.get(0).getX(), snake.snake.get(0).getY()))
                System.out.println("true");*/

            try {
                Thread.sleep(150);
            } catch (InterruptedException e) { e.printStackTrace(); }
            } while (gameOver == false);

    }

    public class Canvas extends JPanel {
        public void paint(Graphics g) {
            super.paint(g);
            snake.paint(g);
            food.paint(g);
            poison.paint(g);
            if (gameOver)
            {
                g.setColor(Color.red);
                g.setFont(new Font("Arial", Font.BOLD, 40));
                FontMetrics fm = g.getFontMetrics();
                g.drawString(GAME_OVER_MSG, (FIELD_WIDTH * Point.POINT_RADIUS + DX - fm.stringWidth(GAME_OVER_MSG))/2, (FIELD_HEIGHT * Point.POINT_RADIUS + DY)/2);
            }
        }
    }
}
