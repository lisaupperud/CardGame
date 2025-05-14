package com.annalisa.cardgame.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Deck {
    public ArrayList<Card> deck = new ArrayList<>();
    public boolean matchingCardFound;
    public int indexOfCard;

    public void generateDeck() {
        for (int i = 1; i <= 13; i++) {
            deck.add(new Card(0, i));
            deck.add(new Card(1, i));
            deck.add(new Card(2, i));
            deck.add(new Card(3, i));
        }
    }

    public void shuffleDeck() {
        Collections.shuffle(deck, new Random());
    }

    public void printDeck() {
        for (Card card : deck) {
            System.out.println(card.getValueAsString(card.getValue()) + " of " + card.getSuitAsString(card.getSuit()));
        }
    }

    public void dealCard(int n, Player player) {
        if (deck.isEmpty()) {
            throw new IllegalStateException("\nNo more cards left");
        }

        for (int i = 0; i < n; i++) {
            player.hand.handArray.add(deck.remove(0));
        }
    }

    public void cardsLeft() {
        System.out.println(deck.size());
    }

    public void findSpecificCard(int suit, int value) {
        matchingCardFound = false;

        for (Card card : deck) {
            if (card.getSuit() == suit && card.getValue() == value) {
                matchingCardFound = true;
                System.out.println("\nCard found: " + card.getSuitAsString(suit) + " " + card.getValueAsString(value));
                indexOfCard = deck.indexOf(card);
                break;
            }
        }

        if (!matchingCardFound) {
            System.out.println("\nCard not found");
        }
    }
}
