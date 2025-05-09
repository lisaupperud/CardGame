package com.annalisa.cardgame.model;

import java.util.ArrayList;

public class Hand {

    public static ArrayList<Card> deck;
    public static ArrayList<Card> cardsDealt;
    // public static ArrayList<Card> hand = new ArrayList<>();

    public static void printHand() {
        if (Player.hand == null) {
            System.out.println("Your hand is empty");
        }
        else {
            for (Card card : Player.hand) {
                System.out.println(card.getValueAsString(card.getValue()) + " of " + card.getSuitAsString(card.getSuit()));
            }
        }
    }


    public static void takeCardFromDeck(int n) {

        if (Deck.deck.isEmpty()) {
            throw new IllegalStateException("No more cards left");
        }

        for(int i = 0; i < n; i++) {
            Player.hand.add(Deck.deck.remove(0));
        }

    }

    public static void takeCardFromOpponent(int n) {


    }

}
