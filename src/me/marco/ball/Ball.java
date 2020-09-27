package me.marco.ball;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Ball implements KeyListener {

    private int x, y;
    private int dx, dy;
    private int width = 5, height = 5;

    public Ball() {
        x = 492;
        y = 332;
    }

    public void update() {

        x += dx;
        y += dy;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Rectangle bounds() {
        return (new Rectangle(x, y, 5, 5));
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void setDx(int dx) {
        this.dx = dx;
    }

    public void setDy(int dy) {
        this.dy = dy;
    }

    public int getDx() {
        return dx;
    }

    public int getDy() {
        return dy;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public void keyTyped(KeyEvent keyEvent) {

    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        int keycode = keyEvent.getKeyCode();

        if(keycode == KeyEvent.VK_SPACE) {
            setDx(getDx() + 5);
        }

        if(keycode == KeyEvent.VK_P) {
            setDx(getDx() - 5);
        }
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {

    }
}
