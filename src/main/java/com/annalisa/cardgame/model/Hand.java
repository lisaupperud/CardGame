package com.annalisa.cardgame.model;

import com.annalisa.cardgame.util.ScannerUtility;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Objects;

public class Hand {

    public ArrayList<Card> handArray;
    public ArrayList<Card> pointPile;
    public ArrayList<Integer> valuesOnHand;
    public HashSet<Integer> uniqueValuesOnHand;

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
            throw new IllegalStateException("No more cards left in the deck");
        }
        player.hand.handArray.add(deck.deck.remove(0));
    }

    public void takeOneCardFromOpponent(Player player, Player opponent) {
        if (opponent.hand == null) {
            System.out.println("Opponent has no cards left");
            return;
        }
        int chosenValue = ScannerUtility.scanInt();
        boolean cardTaken = false;

        // Loop through the opponent's hand to find cards with the chosen value
        for (int i = 0; i < opponent.hand.handArray.size(); i++) {
            Card card = opponent.hand.handArray.get(i);

            // Check if the card's value matches the chosen value
            if (card.getValue() == chosenValue) {
                // Add the card to the player's hand
                player.hand.handArray.add(card);
                // Remove the card from the opponent's hand
                opponent.hand.handArray.remove(i);
                i--; // Adjust the index to account for the removed card
                cardTaken = true;
                //System.out.println("You took card with value: " + chosenValue);
                System.out.println("You took the following card: " + card.getValueAsString(chosenValue) + " of " + card.getSuitAsString(card.getSuit()));
            }
        }

        // If no cards with the chosen value were found
        if (!cardTaken) {
            System.out.println("No cards with value " + chosenValue + " were found in opponent's hand.");
        }

        /*
        for (Integer cardValues : player.hand.uniqueValuesOnHand) {
            System.out.println(cardValues);
            if (Objects.equals(chosenValue, cardValues)) {
                player.hand.handArray.add(opponent.hand.handArray.remove());
                System.out.println("You took cards " + chosenValue);
                break;
            }
        }*/




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

    public HashSet printIndividualValues(Player player) {
        valuesOnHand = new ArrayList<>();

        for (Card card : player.hand.handArray) {
            valuesOnHand.add(card.getValue());
        }

        uniqueValuesOnHand = new HashSet<>(valuesOnHand);
        System.out.println(uniqueValuesOnHand);
        return uniqueValuesOnHand;
    }

}
