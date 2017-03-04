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
    }

    void createFood() {
        super.x = rnd.nextInt(20);
        super.y = rnd.nextInt(30);
    }
}
