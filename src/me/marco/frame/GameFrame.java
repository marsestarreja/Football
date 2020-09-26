package me.marco.frame;

import javax.swing.*;
import java.io.IOException;

public class GameFrame extends JFrame {

    public GameFrame() throws IOException {
        add(new Background());
        setTitle("Football");
        setSize(1000, 700);
        setResizable(false);
        setVisible(true);
    }

}
