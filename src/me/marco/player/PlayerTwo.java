package me.marco.player;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class PlayerTwo implements KeyListener {

    private int x, y;
    private int dx, dy;
    private int width = 20, height = 20;
    private Rectangle rect;

    public PlayerTwo() {
        x = 844;
        y = 316;
    }

    public void update() {
        x += dx;
        y += dy;

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();

        if (keyCode == KeyEvent.VK_UP) {
            dy = -3;
        }

        if (keyCode == KeyEvent.VK_DOWN) {
            dy = 3;
        }

        if (keyCode == KeyEvent.VK_RIGHT) {
            dx = 3;
        }

        if (keyCode == KeyEvent.VK_LEFT) {
            dx = -3;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int keyCode = e.getKeyCode();

        if (keyCode == KeyEvent.VK_UP) {
            dy = 0;
        }

        if (keyCode == KeyEvent.VK_DOWN) {
            dy = 0;
        }

        if (keyCode == KeyEvent.VK_RIGHT) {
            dx = 0;
        }

        if (keyCode == KeyEvent.VK_LEFT) {
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