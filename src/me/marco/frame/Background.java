package me.marco.frame;

import me.marco.ball.Ball;
import me.marco.goals.GoalLeft;
import me.marco.goals.GoalRight;
import me.marco.player.Player;
import me.marco.player.PlayerTwo;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.*;

public class Background extends JPanel implements ActionListener {

    private Image img;
    private Player player;
    private PlayerTwo playertwo;
    private Rectangle rectPlayerTwo;
    private Timer timer;
    private Ball ball;
    private Rectangle rectPlayer;
    private Rectangle rectBall;
    private GoalRight goalRight;
    private GoalLeft goalLeft;

    public Background() throws IOException {

        img = ImageIO.read(new File("res/field.png"));

        setFocusable(true);
        setDoubleBuffered(true);

        player = new Player();
        playertwo = new PlayerTwo();

        goalRight = new GoalRight();
        goalLeft = new GoalLeft();

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

        rectPlayerTwo = new Rectangle(playertwo.getX(), playertwo.getY(), playertwo.getWidth(), playertwo.getHeight());
        g.fillRect(rectPlayerTwo.x, rectPlayerTwo.y, rectPlayerTwo.width, rectPlayerTwo.height);

        g.dispose();

    }

    public void collision() {

        Rectangle rect1 = player.bounds();
        Rectangle rect2 = ball.bounds();
        Rectangle rect3 = playertwo.bounds();

        Rectangle rect4 = goalRight.bound();
        Rectangle rect5 = goalLeft.bound();

        if(rect2.intersects(rect4) || rect2.intersects(rect5)) {
            ball.setDx(0);
            ball.setDy(0);
            ball.setX(493);
            ball.setY(332);
            System.out.println("GOAL!");
        }


        if (rect1.intersects(rect2)) {
            ball.setDx(getRandomInt(6));
            ball.setDy(getRandomInt(4));
        }

        if (rect3.intersects(rect2)) {
            ball.setDx(getRandomInt(-6));
            ball.setDy(getRandomInt(-4));
        }

        if(ball.getX() <= 40) {
            ball.setDx(1);
        }

        if (ball.getY() >= 613) {
            ball.setDy(-1);
        }

        if (ball.getX() >= 937) {
            ball.setDx(-1);
        }

        if(ball.getY() <= 40) {
            ball.setDy(1);
        }

    }


    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        player.update();
        playertwo.update();
        ball.update();
        collision();
        repaint();
    }

    private class keyboardAdapter extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent e) {
            player.keyPressed(e);
            ball.keyPressed(e);
            playertwo.keyPressed(e);
        }

        @Override
        public void keyReleased(KeyEvent e) {
            player.keyReleased(e);
            playertwo.keyReleased(e);
        }
    }

    public int getRandomInt(int max) {
        return (int) Math.floor(Math.random() * Math.floor(max));
    }

}



