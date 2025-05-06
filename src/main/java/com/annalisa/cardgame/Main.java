package com.annalisa.cardgame;

import com.annalisa.cardgame.model.Deck;

public class Main {
    public static void main(String[] args) {
        Deck deck = new Deck();
        // deck.generateDeck();
        deck.shuffleDeck();
    }
}
