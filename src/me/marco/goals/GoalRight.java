package me.marco.goals;

import java.awt.*;

public class GoalRight {

    private int x, y;

    public GoalRight() {
        x = 942;
        y = 318;
    }

    public Rectangle bound() {
        return (new Rectangle(x, y, 10, 30));
    }

}
