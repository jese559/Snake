package com.snake;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by Anon on 04.03.2017.
 */
public class Snake {
    ArrayList<Point> snake = new ArrayList<Point>();
    private final int LEFT = 37;
    private final int UP = 38;
    private final int RIGHT = 39;
    private final int DOWN = 40;
    int direction;

    Snake(int x, int y, int length, int direction) {
        for (int i=0;i<length;i++) {
            Point point = new Point(x-i,y);
            snake.add(point);
        }
        this.direction = direction;
    }

    public void paint(Graphics g) {
        for (Point point : snake)
            point.paint(g);
    }

    public void move(){
        int x = snake.get(0).getX();
        int y = snake.get(0).getY();
        if (direction == LEFT) x--;
        if (direction == RIGHT) x++;
        if (direction == UP) y--;
        if (direction == DOWN) y++;
        if (x > GUI.FIELD_WIDTH) x = 0;
        snake.add(0,new Point(x,y));
        snake.remove(snake.size() -1);
    }

    public void setDirection(int direction) {
        if (direction >= LEFT && direction <= DOWN)
            if (Math.abs(this.direction - direction) != 2)
                this.direction = direction;
    }
}
