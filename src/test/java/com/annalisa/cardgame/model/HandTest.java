package com.annalisa.cardgame.model;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class HandTest {

    ArrayList<Card> testHand;
    ArrayList<Card> testDeck;
    ArrayList<Card> testCardsDealt;

    @BeforeEach
    @DisplayName("Generate test deck before each test")
    void setUp() {
        Deck.generateDeck();
        Deck.shuffleDeck();
        Deck.dealCard(10);
        System.out.println("cardsDealt size: " + Deck.cardsDealt.size());

    }

    @Test
    @DisplayName("Try to print hand array")
    void printHandTest() {
        testDeck = Deck.deck;
        testCardsDealt = Deck.cardsDealt;
        System.out.println("testCardsDealt size: " + testCardsDealt.size());

        testHand = Hand.hand;
        System.out.println("testHand size: " + testHand);
        testHand.addAll(testCardsDealt);
        System.out.println("testCardsDealt size: " + testCardsDealt);

        Hand.printHand();

        assertEquals(10, testHand.size());
    }


    /*@Test
    @DisplayName(" ")
    void takeCardTest() {
        // take card from opponentArray or lakeArray and add to handArray

    }*/


}
