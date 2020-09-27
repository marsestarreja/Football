package me.marco.player;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Player implements KeyListener {

    private int x, y;
    private int dx, dy;
    private int width = 20, height = 20;
    private Rectangle rect;

    public Player() {
        x = 118;
        System.out.println(x);
        System.out.println(y);
        y = 316;
    }

    public void update() {
        x += dx;
        y += dy;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();

        if(keyCode == KeyEvent.VK_W) {
            dy = -3;
        }

        if(keyCode == KeyEvent.VK_S) {
            dy = 3;
        }

        if(keyCode == KeyEvent.VK_D) {
            dx = 3;
        }

        if(keyCode == KeyEvent.VK_A) {
            dx = -3;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int keyCode = e.getKeyCode();

        if(keyCode == KeyEvent.VK_W) {
            dy = 0;
        }

        if(keyCode == KeyEvent.VK_S) {
            dy = 0;
        }

        if(keyCode == KeyEvent.VK_D) {
            dx = 0;
        }

        if(keyCode == KeyEvent.VK_A) {
            dx = 0;
        }
    }


    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    @Override
    public void keyTyped(KeyEvent keyEvent) {

    }

    public Rectangle bounds() {
        return (new Rectangle(x, y, 20, 20));
    }
}

