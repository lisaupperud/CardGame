package com.annalisa.cardgame.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class HandTest {

    ArrayList<Card> testDeck;
    ArrayList<Card> testHand;
    ArrayList<Card> testHandTwo;
    Hand handObject = new Hand();
    Player player = new Player("A");
    Player opponent = new Player("B");
    Deck cardDeck;
    ArrayList<Card> pointPile;

    @BeforeEach
    @DisplayName("Generate test deck before each test")
    void setUp() {
        cardDeck = new Deck();
        cardDeck.generateDeck();
        //Deck.shuffleDeck();
        cardDeck.dealCard(10, player);
    }

    @Test
    @DisplayName("Print cards in Player's hand")
    void printHandTest() {
        testDeck = cardDeck.deck;
        testHand = player.hand.handArray;
        handObject.printHand(player);
        /*
         * FRÅGA KRISTOFFER OM ASSERT PÅ DEN HÄR
         * */
        assertEquals(10, testHand.size());
    }

    @Test
    @DisplayName("Take a card from the Deck Arraylist")
    void takeOneCardFromDeckTest() {
        testDeck = cardDeck.deck;
        testHand = player.getHand().handArray;
        handObject.takeOneCardFromDeck(player, cardDeck);

        assertEquals(41, testDeck.size());
        assertEquals(11, testHand.size());
    }

    @Test
    @DisplayName("Take a card from opponent's ArrayList")
    void takeOneCardFromOpponentTest() {
        testDeck = cardDeck.deck;
        testHand = player.getHand().handArray;
        testHandTwo = opponent.getHand().handArray;

        handObject.takeOneCardFromDeck(player, cardDeck);
        handObject.takeOneCardFromDeck(player, cardDeck);
        //System.out.println(testHand);
        handObject.takeOneCardFromOpponent(opponent, player, 0);
        //System.out.println(testHand);
        //System.out.println(testHandTwo);

        assertEquals(11, testHand.size());
        assertEquals(1, testHandTwo.size());
    }

    @Test
    @DisplayName("Remove matching cards from Hand, put into points pile")
    void removeFourMatchingCardsTest() {
        pointPile = new ArrayList<>();
        testHand = player.getHand().handArray;

        for (int value = 1; value <= 13; value++) {
            int count = 0;
            for (Card card : testHand) {
                if (card.getValue() == value) {
                    count++;
                }
            }

            if (count == 4) {
                for (Card card : testHand) {
                    if (card.getValue() == value) {
                        pointPile.add(card);
                    }
                }
                testHand.removeAll(pointPile);
                break;

            }
        }
        assertEquals(4, pointPile.size());
        assertEquals(6, testHand.size());
    }
}
