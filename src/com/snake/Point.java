package com.snake;

import java.awt.*;

/**
 * Created by Anon on 04.03.2017.
 */
public class Point {
    final Color DEFAULT_COLOR = Color.black;
    final static int POINT_RADIUS = 20;

    public int x, y;
    Color color = DEFAULT_COLOR;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public void paint(Graphics g) {
        g.setColor(color);
        g.fillOval(x*POINT_RADIUS,y*POINT_RADIUS,POINT_RADIUS,POINT_RADIUS);
    }
    public int getX() { return x; }
    public int getY() { return y; }
    public static int getPOINT_RADIUS() { return POINT_RADIUS; }

}
