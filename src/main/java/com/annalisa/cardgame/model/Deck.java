package com.annalisa.cardgame.model;

import java.util.Random;

public class Deck {
    public static Card[] deck;
    private int next;

    public static void generateDeck() {
        deck = new Card[53];
        for (int i = 1; i <= 13; i++) {
            deck[i] = new Card(0, i);
            //System.out.println(deck[i].getSuitAsString(0) + " " + deck[i].getValueAsString(i));
            deck[i + 13] = new Card(1, i);
            //System.out.println(deck[i].getSuitAsString(1) + " " + deck[i].getValueAsString(i));
            deck[i + 26] = new Card(2, i);
            //System.out.println(deck[i].getSuitAsString(2) + " " + deck[i].getValueAsString(i));
            deck[i + 39] = new Card(3, i);
            //System.out.println(deck[i].getSuitAsString(3) + " " + deck[i].getValueAsString(i));
        }
    }



    public static void shuffleDeck() {
        generateDeck();
        Random randomNumber = new Random();

        Card temp;

        for (int i = 1; i <= 52; i++) {
            // Find a random place in the deck
            int rand = randomNumber.nextInt(52) + 1;
            // Swap cards in deck
            temp = deck[i];
            deck[i] = deck[rand];
            deck[rand] = temp;
        }

        for (Card card : deck) {
            System.out.println(card.getSuitAsString(card.getSuit()) + " " + card.getValueAsString(card.getValue()));
        }

    }

}
