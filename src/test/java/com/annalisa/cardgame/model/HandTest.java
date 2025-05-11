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

    @BeforeEach
    @DisplayName("Generate test deck before each test")
    void setUp() {
        Deck.generateDeck();
        //Deck.shuffleDeck();
        Deck.dealCard(10);
    }

    @Test
    @DisplayName("Print cards in Player's hand")
    void printHandTest() {
        testDeck = Deck.deck;
        testCardsDealt = Deck.cardsDealt;
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
        testDeck = Deck.deck;
        testHand = player.getHand().handArray;
        handObject.takeCardFromDeck(player);

        assertEquals(41, testDeck.size());
        assertEquals(1, testHand.size());
    }

    @Test
    @DisplayName("Take a card from opponent's ArrayList")
    void takeCardFromOpponentTest() {
        testDeck = Deck.deck;
        testCardsDealt = Deck.cardsDealt;
        testHand = player.getHand().handArray;
        testHandTwo = opponent.getHand().handArray;

        handObject.takeCardFromDeck(player);
        handObject.takeCardFromDeck(player);
        //System.out.println(testHand);
        handObject.takeCardFromOpponent(opponent, player, 0);
        //System.out.println(testHand);
        //System.out.println(testHandTwo);

        assertEquals(1, testHand.size());
        assertEquals(1, testHandTwo.size());
    }

}
