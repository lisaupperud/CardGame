package com.annalisa.cardgame.model;

import java.util.ArrayList;

public class Hand {

    public static ArrayList<Card> deck;
    public static ArrayList<Card> cardsDealt;
    public ArrayList<Card> hand = new ArrayList<>();
    // TODO - player consists of one hand, one hand is dependent on a list of cards. Implement hand in Player class

    public Hand() {
        hand = new ArrayList<>();
    }

    public ArrayList<Card> getHand() {
        return hand;
    }


    public void printHand(Player player) {
        if (player.hand == null) {
            System.out.println("Your hand is empty");
        }
        else {
            for (Card card : player.hand.hand) {
                System.out.println(card.getValueAsString(card.getValue()) + " of " + card.getSuitAsString(card.getSuit()));
            }
        }
    }


    public void takeCardFromDeck(int n, Player player) {

        if (Deck.deck.isEmpty()) {
            throw new IllegalStateException("No more cards left");
        }

        for(int i = 0; i < n; i++) {
            player.hand.hand.add(Deck.deck.remove(0));
        }

    }

    public static void takeCardFromOpponent(int n) {


    }

}
