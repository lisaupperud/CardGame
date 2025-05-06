package com.annalisa.cardgame.model;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class DeckTest {

    private final int SPADES = 0;
    private final int HEARTS = 1;
    private final int DIAMONDS = 2;
    private final int CLUBS = 3;

    ArrayList<Card> testDeck;

    @Test
    @DisplayName("Generate an unshuffled deck of cards")
    void generateDeckTest() {
        Deck.generateDeck();
        testDeck = Deck.deck;
        assertEquals(52, testDeck.size());
    }

    @Test
    @DisplayName("Generate a shuffled deck of cards")
    void shuffleDeckTest() {
        Deck.generateDeck();
        ArrayList<Card> unshuffledDeck = new ArrayList<>(Deck.deck);
        testDeck = Deck.deck;
        Collections.shuffle(testDeck, new Random());

        /*
        // Print the unshuffled deck
        for (Card card : unshuffledDeck) {
            System.out.println(card.getSuitAsString(card.getSuit()) + " " + card.getValueAsString(card.getValue()));
        }
        // Print the shuffled deck
        for (Card card : testDeck) {
            System.out.println(card.getSuitAsString(card.getSuit()) + " " + card.getValueAsString(card.getValue()));
        }
        */

        assertNotEquals(unshuffledDeck, testDeck);
    }

    @Test
    @DisplayName("Print the entire deck of cards")
    void printDeckTest() {
        Deck.generateDeck();
        testDeck = Deck.deck;
        for (Card card : testDeck) {
            System.out.println(card.getValueAsString(card.getValue()) + " of " + card.getSuitAsString(card.getSuit()));
        }

        assertEquals(52, testDeck.size());
    }
}
