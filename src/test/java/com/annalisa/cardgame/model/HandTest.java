package com.annalisa.cardgame.model;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class HandTest {

    ArrayList<Card> testHand;
    Card card = new Card(0,1);
    Card card2 = new Card(0,2);
    ArrayList<Card> testDeck;
    ArrayList<Card> testCardsDealt;

    @BeforeEach
    @DisplayName("Generate test deck before each test")
    void setUp() {
        Deck.generateDeck();
        Deck.shuffleDeck();
        Deck.dealCard(10);
    }

    @Test
    @DisplayName("Try to print hand array")
    void printHandTest() {
        testHand = new ArrayList<>();
        testDeck = Deck.deck;
        testCardsDealt = Deck.cardsDealt;

        testHand.addAll(testCardsDealt);

        for (Card card : testHand) {
            System.out.println(card.getValueAsString(card.getValue()) + " of " + card.getSuitAsString(card.getSuit()));
        }

        assertEquals(10, testHand.size());
    }


    @Test
    @DisplayName(" ")
    void takeCardTest() {
        // take card from opponentArray or lakeArray and add to handArray

    }


}
