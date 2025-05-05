package com.annalisa.cardgame.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class DeckTest {

    private final int SPADES = 0;
    private final int HEARTS = 1;
    private final int DIAMONDS = 2;
    private final int CLUBS = 3;

    Card[] testDeck;

    @Test
    @DisplayName("Generate a deck of cards")
    void generateDeckTest() {
        Deck.generateDeck();
        testDeck = Deck.deck;
        assertEquals(53, testDeck.length);
    }

    @Test
    @DisplayName("Generate a shuffled deck")
    void shuffleTest() {
        Deck.generateDeck();
        testDeck = Deck.deck;
        Random randomNumber = new Random();

        Card temp = null;
        for (int card = 1; card <= 52; card++) {
            // Find a random place in the deck
            int rand = randomNumber.nextInt(52) + 1;

            // Swap cards in deck
            temp = testDeck[card];
            testDeck[card] = testDeck[rand];
            testDeck[rand] = temp;
        }

        assertNotEquals(testDeck[5], temp);
    }
}
