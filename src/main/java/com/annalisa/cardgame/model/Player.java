package com.annalisa.cardgame.model;

import java.util.ArrayList;

public class Player {

    public static String name;
    public static ArrayList<Card> hand = new ArrayList<>();


    public Player(String name, ArrayList<Card> hand) {
        this.name = name;
        this.hand = hand;
    }

}
