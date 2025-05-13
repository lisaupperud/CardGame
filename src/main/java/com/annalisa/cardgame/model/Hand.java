package com.annalisa.cardgame.model;

import java.util.ArrayList;

public class Hand {

    public ArrayList<Card> handArray;
    public ArrayList<Card> pointPile;

    public Hand() {
        handArray = new ArrayList<>();
        pointPile = new ArrayList<>();
    }

    public ArrayList<Card> getHandArray() {
        return handArray;
    }

    public ArrayList<Card> getPointPile() {
        return pointPile;
    }

    public void printHand(Player player) {
        if (player.hand == null) {
            System.out.println("Your hand is empty");
        } else {
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

    public void removeFourMatchingCards(Player player) {
        for (int value = 1; value <= 13; value++) {
            int count = 0;
            for (Card card : player.hand.handArray) {
                if (card.getValue() == value) {
                    count++;
                }
            }

            if (count == 4) {
                for (Card card : player.hand.handArray) {
                    if (card.getValue() == value) {
                        player.hand.pointPile.add(card);
                    }
                }
                player.hand.handArray.removeAll(player.hand.pointPile);
                break;
            }
        }
    }

}
