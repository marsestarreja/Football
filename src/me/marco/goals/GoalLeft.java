package me.marco.goals;

import java.awt.*;

public class GoalLeft {

    private int x, y;

    public GoalLeft() {
        x = 30;
        y = 318;
    }

    public Rectangle bound() {
        return (new Rectangle(x, y, 20, 30));
    }

}
