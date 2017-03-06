package com.snake;

import java.awt.*;
import java.util.Random;

/**
 * Created by Anon on 04.03.2017.
 */
public class Food extends Point {
    final Color FOOD_COLOR = Color.green;
    Random rnd = new Random();

    Food() {
        super(-1,-1);
        super.color = FOOD_COLOR;
        createFood();
    }

    void createFood() {
        super.x = rnd.nextInt(29);
        super.y = rnd.nextInt(19);
    }

    boolean isEaten(int x, int y) {
        if ((this.x == x) && (this.y==y))
                return true;
        else
            return false;
    }
}
