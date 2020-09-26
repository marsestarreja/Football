package me.marco;

import me.marco.frame.GameFrame;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        try {
            new GameFrame();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
