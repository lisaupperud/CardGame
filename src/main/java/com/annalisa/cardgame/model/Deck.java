package com.annalisa.cardgame.model;

public class Deck {


    public static Card[] deck;
    private int next;

    public static void generateDeck() {

        deck = new Card[53];

        for (int i = 1; i <= 13; i++) {
            deck[i] = new Card(0, i);
            deck[i+13] = new Card(1, i);
            deck[i+26] = new Card(2, i);
            deck[i+39] = new Card(3, i);
        }

    }



}
