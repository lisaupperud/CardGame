package com.annalisa.cardgame.model;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

public class DeckTest {

    ArrayList<Card> testDeck;
    Deck cardDeck;
    Player player = new Player("A");

    @BeforeEach
    void setUp() {
        cardDeck = new Deck();
        cardDeck.generateDeck();
    }

    @Test
    @DisplayName("Generate an unshuffled deck of cards")
    void generateDeckTest() {
        testDeck = cardDeck.deck;
        assertEquals(52, testDeck.size());
    }

    @Test
    @DisplayName("Generate a shuffled deck of cards")
    void shuffleDeckTest() {
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
        testDeck = cardDeck.deck;
        cardDeck.printDeck();

        assertEquals(52, testDeck.size());
    }

    @Test
    @DisplayName("Deals a number of cards (currently 7)")
    void dealCardTest() {
        cardDeck.dealCard(7, player);
        testDeck = cardDeck.deck;
        assertEquals(7, player.hand.handArray.size());
    }

    @Test
    @DisplayName("See how many cards are left in the deck")
    void cardsLeftTest() {
        cardDeck.dealCard(10, player);
        testDeck = cardDeck.deck;

        int cardsLeft = testDeck.size();
        assertEquals(42, cardsLeft);

    }

    @Test
    @DisplayName("Checks index of specific card")
    void findSpecificCardTest() {
        testDeck = cardDeck.deck;
        int suit = 2;
        int value = 7;
        cardDeck.findSpecificCard(suit, value);

        assertTrue(cardDeck.matchingCardFound);
    }
}
