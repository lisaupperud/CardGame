package com.annalisa.cardgame.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Deck {
    public static ArrayList<Card> deck;
    public static ArrayList<Card> cardsDealt;

    public static void generateDeck() {
        deck = new ArrayList<>();
        for (int i = 1; i <= 13; i++) {
            deck.add(new Card(0, i));
            deck.add(new Card(1, i));
            deck.add(new Card(2, i));
            deck.add(new Card(3, i));
        }
    }

    public static void shuffleDeck() {
        Collections.shuffle(deck, new Random());
    }

    public static void printDeck() {
        for (Card card : deck) {
            System.out.println(card.getValueAsString(card.getValue()) + " of " + card.getSuitAsString(card.getSuit()));
        }
    }

    public static void dealCard(int n) {
        cardsDealt = new ArrayList<>();

        if (deck.isEmpty()) {
            throw new IllegalStateException("No more cards left");
        }

        for(int i = 0; i < n; i++) {
            cardsDealt.add(deck.remove(0));
        }

    }

    public static void cardsLeft() {
        System.out.println(deck.size());
    }


}
