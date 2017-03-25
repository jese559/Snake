package com.snake;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by n7701-00-134 on 07.03.2017.
 */

public class Poison extends Point {
    final Color DEFAULT_COLOR = Color.red;
    Random rnd = new Random();

    Poison() {
        super(-1,-1);
        super.color = DEFAULT_COLOR;
        createPoison();
    }

    void createPoison() {
        this.x = rnd.nextInt(29);
        this.y = rnd.nextInt(19);
    }

    boolean isEaten(int x, int y) {
        if ((this.x == x) && (this.y==y))
            return true;
        else
            return false;
    }
}
