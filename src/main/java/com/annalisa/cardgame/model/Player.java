package com.annalisa.cardgame.model;

import java.util.ArrayList;

public class Player {

    public String name;
    //public ArrayList<Card> hand;
    public Hand hand;


    public Player(String name) {
        this.name = name;
        hand = new Hand();
    }

    public String getName() {
        return name;
    }

    public Hand getHand() {
        return hand;
    }

    public void setHand(Hand hand) {
        this.hand = hand;
    }
}
