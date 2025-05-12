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
    ArrayList<Card> testHandTwo;
    Hand handObject = new Hand();
    Player player = new Player("A");
    Player opponent = new Player("B");
    Deck cardDeck;

    @BeforeEach
    @DisplayName("Generate test deck before each test")
    void setUp() {
        cardDeck = new Deck();
        cardDeck.generateDeck();
        //Deck.shuffleDeck();
        cardDeck.dealCard(10);
    }

    @Test
    @DisplayName("Print cards in Player's hand")
    void printHandTest() {
        testDeck = cardDeck.deck;
        testCardsDealt = cardDeck.cardsDealt;
        testHand = player.hand.handArray;
        testHand.addAll(testCardsDealt);
        handObject.printHand(player);
        /*
         * FRÅGA KRISTOFFER OM ASSERT PÅ DEN HÄR
         * */
        assertEquals(10, testHand.size());
    }

    @Test
    @DisplayName("Take a card from the Deck Arraylist")
    void takeCardFromDeckTest() {
        testDeck = cardDeck.deck;
        testHand = player.getHand().handArray;
        handObject.takeCardFromDeck(player, cardDeck);

        assertEquals(41, testDeck.size());
        assertEquals(1, testHand.size());
    }

    @Test
    @DisplayName("Take a card from opponent's ArrayList")
    void takeCardFromOpponentTest() {
        testDeck = cardDeck.deck;
        testCardsDealt = cardDeck.cardsDealt;
        testHand = player.getHand().handArray;
        testHandTwo = opponent.getHand().handArray;

        handObject.takeCardFromDeck(player, cardDeck);
        handObject.takeCardFromDeck(player, cardDeck);
        //System.out.println(testHand);
        handObject.takeCardFromOpponent(opponent, player, 0);
        //System.out.println(testHand);
        //System.out.println(testHandTwo);

        assertEquals(1, testHand.size());
        assertEquals(1, testHandTwo.size());
    }

}
