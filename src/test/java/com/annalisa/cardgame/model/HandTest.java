package com.annalisa.cardgame.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class HandTest {

    ArrayList<Card> testDeck;
    ArrayList<Card> testCardsDealt;
    ArrayList<Card> testHand;
    ArrayList<Card> testPlayerHand;

    @BeforeEach
    @DisplayName("Generate test deck before each test")
    void setUp() {
        Deck.generateDeck();
        Deck.shuffleDeck();
        Deck.dealCard(10);
    }

    @Test
    @DisplayName("Print hand array")
    void printHandTest() {
        testDeck = Deck.deck;
        testCardsDealt = Deck.cardsDealt;
        testHand = Hand.hand;
        testHand.addAll(testCardsDealt);
        Hand.printHand();
        assertEquals(10, testHand.size());
    }

    @Test
    @DisplayName("Take a card from the Deck Arraylist")
    void takeCardFromDeckTest() {
        int n = 1;
        testDeck = Deck.deck;
        testHand = Hand.hand;

        if (testDeck.isEmpty()) {
            throw new IllegalStateException("No more cards left");
        }

        for(int i = 0; i < n; i++) {
            testHand.add(testDeck.remove(0));
        }
        assertEquals(41, testDeck.size());
        //assertEquals(1, testHand.size());
    }

    @Test
    @DisplayName("Take a card from opponent's ArrayList")
    void takeCardFromOpponentTest() {
        testCardsDealt = Deck.cardsDealt;
        testHand = Hand.hand;
        testPlayerHand = Player.playerHand;

        System.out.println(testCardsDealt);

        testPlayerHand.add(testCardsDealt.remove(0));

        System.out.println(testCardsDealt);
        System.out.println(testPlayerHand);

        //assertEquals(9, testCardsDealt.size());
        assertEquals(1, testPlayerHand.size());
    }


}
