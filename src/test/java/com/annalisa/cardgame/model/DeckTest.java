package com.annalisa.cardgame.model;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

public class DeckTest {

    ArrayList<Card> testDeck;
    ArrayList<Card> testCardsDealt;
    Deck cardDeck = new Deck();

    @Test
    @DisplayName("Generate an unshuffled deck of cards")
    void generateDeckTest() {
        cardDeck.generateDeck();
        testDeck = cardDeck.deck;
        assertEquals(52, testDeck.size());
    }

    @Test
    @DisplayName("Generate a shuffled deck of cards")
    void shuffleDeckTest() {
        cardDeck.generateDeck();
        ArrayList<Card> unshuffledDeck = new ArrayList<>(cardDeck.deck);
        testDeck = cardDeck.deck;
        cardDeck.shuffleDeck();

        /* debug:
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
        cardDeck.generateDeck();
        testDeck = cardDeck.deck;
        cardDeck.printDeck();

        assertEquals(52, testDeck.size());
    }

    @Test
    @DisplayName("Deals a number of cards (currently 7)")
    void dealCardTest() {
        cardDeck.generateDeck();
        cardDeck.dealCard(7);
        testDeck = cardDeck.deck;
        testCardsDealt = cardDeck.cardsDealt;
        assertEquals(7, testCardsDealt.size());
    }

    @Test
    @DisplayName("See how many cards are left in the deck")
    void cardsLeftTest() {
        cardDeck.generateDeck();
        cardDeck.dealCard(10);
        testDeck = cardDeck.deck;

        int cardsLeft = testDeck.size();
        assertEquals(42, cardsLeft);

    }
}
