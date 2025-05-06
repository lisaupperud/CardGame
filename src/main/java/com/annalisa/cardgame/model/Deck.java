package com.annalisa.cardgame.model;

import java.util.ArrayList;
import java.util.Random;

public class Deck {
    public static ArrayList<Card> deck;
    private int next;

    public static void generateDeck() {

        deck = new ArrayList<>();

        //deck = new ArrayList<>();
        for (int i = 1; i <= 13; i++) {
            /*deck.add(i, new Card(0, i));
            //System.out.println(deck[i].getSuitAsString(0) + " " + deck[i].getValueAsString(i));
            deck.add(i + 13, new Card(1, i));
            //System.out.println(deck[i].getSuitAsString(1) + " " + deck[i].getValueAsString(i));
            deck.add(i + 26, new Card(2, i));
            //System.out.println(deck[i].getSuitAsString(2) + " " + deck[i].getValueAsString(i));
            deck.add(i + 39, new Card(3, i));
            //System.out.println(deck[i].getSuitAsString(3) + " " + deck[i].getValueAsString(i));*/

            deck.add(new Card(0, i));
            deck.add(new Card(1, i));
            deck.add(new Card(2, i));
            deck.add(new Card(3, i));

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
            temp = deck.get(i);
            deck.set(i, deck.get(rand));
            deck.set(rand, temp);
        }

        for (Card card : deck) {
            System.out.println(Card.getSuitAsString(card.getSuit()) + " " + Card.getValueAsString(card.getValue()));
        }

    }

}
