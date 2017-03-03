package com.snake;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Anon on 03.03.2017.
 */
public abstract class GUI {
    private static JFrame frame;
    private static JPanel panel;
    private final static String FRAME_TITLE = "SNAKE GAME";

    public static void startGUI() {
        frame = new JFrame(FRAME_TITLE);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel = new JPanel();
        frame.getContentPane().add(BorderLayout.CENTER,panel);
        frame.setSize(750,450);
        frame.setVisible(true);
    }
}
