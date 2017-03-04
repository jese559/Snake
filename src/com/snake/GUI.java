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
    public static final int FIELD_WIDTH = 50;
    public static final int FIELD_HEIGHT = 40;
    private final int DX = 15;
    private final int DY = 20;
    private final int START_SNAKE_X = 10;
    private final int START_SNAKE_Y = 10;
    private final int START_DIRECTION = 39;
    private final int SNAKE_LENGTH = 450;
    //private final int FIELD_HEIGHT = 450;
    private Canvas canvas;
    Snake snake;
    Food food;

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
        frame.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                //super.keyPressed(e);
                snake.setDirection(e.getKeyCode());
            }
        });
        while(true)
        {

            snake.move();
            canvas.repaint();
            try {
                Thread.sleep(150);
            } catch (InterruptedException e) { e.printStackTrace(); }
            }

    }

    public class Canvas extends JPanel {
        public void paint(Graphics g) {
            super.paint(g);
            snake.paint(g);
            food.paint(g);
        }
    }


    public void keyPressed(KeyEvent e) {
        System.out.println(e.getKeyCode());
    }
}
