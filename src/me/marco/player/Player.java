package me.marco.player;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Player implements KeyListener {

    private int x = 50, y = 50;
    private int dx, dy;
    private int width = 20, height = 20;
    private Rectangle rect;

    public Player() {
        x = 100;
        y = 100;
    }

    public void update() {
        x += dx;
        y += dy;

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();

        if(keyCode == KeyEvent.VK_UP) {
            System.out.println("teste");
            dy = -3;
        }

        if(keyCode == KeyEvent.VK_DOWN) {
            System.out.println("teste");
            dy = 3;
        }

        if(keyCode == KeyEvent.VK_RIGHT) {
            System.out.println("teste");
            dx = 3;
        }

        if(keyCode == KeyEvent.VK_LEFT) {
            System.out.println("teste");
            dx = -3;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int keyCode = e.getKeyCode();

        if(keyCode == KeyEvent.VK_UP) {
            System.out.println("teste");
            dy = 0;
        }

        if(keyCode == KeyEvent.VK_DOWN) {
            System.out.println("teste");
            dy = 0;
        }

        if(keyCode == KeyEvent.VK_RIGHT) {
            System.out.println("teste");
            dx = 0;
        }

        if(keyCode == KeyEvent.VK_LEFT) {
            System.out.println("teste");
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

