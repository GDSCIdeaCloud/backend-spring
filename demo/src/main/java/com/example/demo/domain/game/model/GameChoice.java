package com.example.demo.domain.game.model;

public enum GameChoice {
    A,B;
    public static GameChoice getChoice(String choice) {
        if(choice.equals("A")) return A;
        return B;
    }
}
