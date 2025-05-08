package com.annalisa.cardgame.model;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

public class DeckTest {

    ArrayList<Card> testDeck;
    ArrayList<Card> testCardsDealt;

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
        Deck.shuffleDeck();

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
        Deck.generateDeck();
        testDeck = Deck.deck;
        Deck.printDeck();

        assertEquals(52, testDeck.size());
    }

    @Test
    @DisplayName("Deals a number of cards (currently 7)")
    void dealCardTest() {
        Deck.generateDeck();
        Deck.dealCard(7);
        testDeck = Deck.deck;
        testCardsDealt = Deck.cardsDealt;
        assertEquals(7, testCardsDealt.size());
    }

    @Test
    @DisplayName("See how many cards are left in the deck")
    void cardsLeftTest() {
        Deck.generateDeck();
        Deck.dealCard(10);
        testDeck = Deck.deck;

        int cardsLeft = testDeck.size();
        assertEquals(42, cardsLeft);

    }
}
