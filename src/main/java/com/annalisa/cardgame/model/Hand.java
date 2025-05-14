package com.annalisa.cardgame.model;

import com.annalisa.cardgame.util.ScannerUtility;

import java.util.ArrayList;
import java.util.HashSet;

public class Hand {

    public ArrayList<Card> handArray;
    public ArrayList<Card> pointPile;
    public ArrayList<Integer> valuesOnHand;
    public HashSet<Integer> uniqueValuesOnHand;
    public boolean cardTaken;

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

    //TODO - räcker det med player.hand == null? behöver vi inte också kolla om själva listan är tom?

    public void printHand(Player player) {
        if (player.hand == null) {
            System.out.println("\nYour hand is empty");
        } else {
            for (Card card : player.hand.handArray) {
                System.out.println(card.getValueAsString(card.getValue()) + " of " + card.getSuitAsString(card.getSuit()));
            }
            /*
            *  // Sort the hand by suit first, then by value
        player.hand.handArray.sort((card1, card2) -> {
            if (card1.getSuit() != card2.getSuit()) {
                return Integer.compare(card1.getSuit(), card2.getSuit());
            } else {
                return Integer.compare(card1.getValue(), card2.getValue());
            }
        });

        // Print the sorted hand
        for (Card card : player.hand.handArray) {
            System.out.println(
                card.getValueAsString(card.getValue()) + " of " +
                card.getSuitAsString(card.getSuit())
            );
        }
            * */
        }
    }

    public void takeOneCardFromDeck(Player player, Deck deck) {
        if (deck.deck.isEmpty()) {
            throw new IllegalStateException("\nNo more cards left in the deck");
        }
        System.out.println("\nCard Taken from deck: " + deck.deck.getFirst().getValueAsString(deck.deck.getFirst().getValue()) + " of " + deck.deck.getFirst().getSuitAsString(deck.deck.getFirst().getSuit()));
        player.hand.handArray.add(deck.deck.removeFirst());
    }

    public void takeOneCardFromOpponent(Player player, Player opponent) {
        if (opponent.hand == null) {
            System.out.println("\nOpponent has no cards left");
            return;
        }
        int chosenValue = -1;

        boolean running = true;
        while (running) {
            chosenValue = ScannerUtility.scanInt();
            if (!player.hand.uniqueValuesOnHand.contains(chosenValue)) {
                System.out.println("Not a valid value - choose from your hand");
            } else {
                running = false;
            }
        }

        cardTaken = false;

        for (int i = 0; i < opponent.hand.handArray.size(); i++) {
            Card card = opponent.hand.handArray.get(i);

            if (card.getValue() == chosenValue) {
                player.hand.handArray.add(card);
                opponent.hand.handArray.remove(i);
                i--;
                cardTaken = true;
                System.out.println("\nYou took the following card: " + card.getValueAsString(chosenValue) + " of " + card.getSuitAsString(card.getSuit()));
            }
        }

        if (!cardTaken) {
            System.out.println("\nOpponent has no cards of value " + chosenValue + ".\n\u001B[34mGO FISH!\u001B[0m");
        }
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
                System.out.println("Your four matching cards of value \u001B[31m" + value + "\u001B[0m have been removed from your hand.");
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
        /*
        * Set<String> printableValues = new HashSet<>();
    for (int value : uniqueValuesOnHand) {
        printableValues.add(Card.getValueAsString(value));
    }
    System.out.println(printableValues);

    return uniqueValuesOnHand;
        * */
        System.out.println(uniqueValuesOnHand);
        return uniqueValuesOnHand;
    }

}
