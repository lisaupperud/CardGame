package com.annalisa.cardgame.model;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Random;

public class DeckTest {

    private final int SPADES = 0;
    private final int HEARTS = 1;
    private final int DIAMONDS = 2;
    private final int CLUBS = 3;

    ArrayList<Card> testDeck;

    @Test
    @DisplayName("Generate a deck of cards")
    void generateDeckTest() {
        Deck.generateDeck();
        testDeck = Deck.deck;
        assertEquals(52, testDeck.size());
    }

    // be kristoffer om hjälp att förstå
    @Test
    @DisplayName("Generate a shuffled deck")
    void shuffleTest() {
        Deck.generateDeck();
        testDeck = Deck.deck;
        Random randomNumber = new Random();

        Card temp = null;
        for (int card = 1; card <= 51; card++) {
            // Find a random place in the deck
            int rand = randomNumber.nextInt(51) + 1;

            // Swap cards in deck
            temp = testDeck.get(card);
            testDeck.set(card, testDeck.get(rand));
            testDeck.set(rand, temp);
            /*System.out.println(testDeck.get(5).toString());
            System.out.println("-----------------");
            System.out.println(temp.toString());*/
        }
        assertNotEquals(testDeck.get(5), temp);
    }

    @Test
    void printDeckTest(){
        Deck.generateDeck();
        testDeck = Deck.deck;
        for (Card card : testDeck) {
            System.out.println(card);
        }

        assertEquals(52, testDeck.size());
        // failsafe for if card = null

    }
}
