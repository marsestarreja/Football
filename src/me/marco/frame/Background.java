package me.marco.frame;

import me.marco.ball.Ball;
import me.marco.player.Player;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;

public class Background extends JPanel implements ActionListener {

    private Image img;
    private Player player;
    private Timer timer;
    private Ball ball;
    private Rectangle rectPlayer;
    private Rectangle rectBall;

    public Background() throws IOException {
        setFocusable(true);
        setDoubleBuffered(true);

        img = ImageIO.read(new File("res/field.png"));

        player = new Player();

        ball = new Ball();

        addKeyListener(new keyboardAdapter());

        timer = new Timer(3, this);
        timer.start();

    }

    public void paint(Graphics g) {

        g.drawImage(img, 0, 0, 985, 665, null);
        g.setColor(Color.black);

        rectPlayer = new Rectangle(player.getX(), player.getY(), player.getWidth(), player.getHeight());
        g.fillRect(rectPlayer.x, rectPlayer.y, rectPlayer.width, rectPlayer.height);

        rectBall = new Rectangle(ball.getX(), ball.getY(), ball.getWidth(), ball.getHeight());
        g.fillRect(rectBall.x, rectBall.y, rectBall.width, rectBall.height);
        g.dispose();

    }

    public void collision() {
        Rectangle rect1 = player.bounds();
        Rectangle rect2 = ball.bounds();

        System.out.println(ball.getY());

        if (rect1.intersects(rect2)) {
            ball.setDx(getRandomInt(5));
            ball.setDy(getRandomInt(5));
        }

        if (ball.getX() >= 937) {
            ball.setDx(-3);
        }

        if(ball.getX() <= 40) {
            ball.setDx(3);
        }

        if (ball.getY() >= 613) {
            ball.setDy(-3);
        }

        if (ball.getX() >= 937) {
            ball.setDx(-3);
        }

        if(ball.getY() <= 40) {
            ball.setDy(3);
        }
    }


    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        player.update();
        ball.update();
        collision();
        repaint();
    }

    private class keyboardAdapter extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent e) {
            player.keyPressed(e);
            ball.keyPressed(e);
        }

        @Override
        public void keyReleased(KeyEvent e) {
            player.keyReleased(e);
        }
    }

    public int getRandomInt(int max) {
        return (int) Math.floor(Math.random() * Math.floor(max));
    }

}


