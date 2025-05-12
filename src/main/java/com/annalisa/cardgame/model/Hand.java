package com.annalisa.cardgame.model;

import java.util.ArrayList;

public class Hand {

    public ArrayList<Card> handArray;

    public Hand() {
        handArray = new ArrayList<>();
    }

    public ArrayList<Card> getHandArray() {
        return handArray;
    }

    public void printHand(Player player) {
        if (player.hand == null) {
            System.out.println("Your hand is empty");
        }
        else {
            for (Card card : player.hand.handArray) {
                System.out.println(card.getValueAsString(card.getValue()) + " of " + card.getSuitAsString(card.getSuit()));
            }
        }
    }

    public void takeOneCardFromDeck(Player player, Deck deck) {
        if (deck.deck.isEmpty()) {
            throw new IllegalStateException("No more cards left");
        }

        player.hand.handArray.add(deck.deck.remove(0));
    }

    public void takeOneCardFromOpponent(Player player, Player opponent, int index) {
        if (opponent.hand == null) {
            throw new IllegalStateException("Opponent has no cards left");
        }

        player.hand.handArray.add(opponent.hand.handArray.remove(index));
    }

}
