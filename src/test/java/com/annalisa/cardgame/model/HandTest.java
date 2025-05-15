package com.annalisa.cardgame.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

public class HandTest {

    ArrayList<Card> testDeck;
    ArrayList<Card> testHand;
    ArrayList<Card> testHandTwo;
    ArrayList<Card> testPointPile;
    ArrayList<Card> testHandUnsorted;
    ArrayList<Integer> testValuesOnHand;
    HashSet<Integer> testUniqueValuesOnHand;
    Hand handObject = new Hand();
    Player player = new Player("A");
    Player opponent = new Player("B");
    Deck cardDeck;

    @BeforeEach
    @DisplayName("Generate test deck before each test")
    void setUp() {
        cardDeck = new Deck();
        cardDeck.generateDeck();
        cardDeck.dealCard(10, player);
    }

    @Test
    @DisplayName("Print cards in Player's hand")
    void printHandTest() {
        testDeck = cardDeck.deck;
        testHand = player.hand.handArray;
        handObject.printHand(player);

        assertEquals(10, testHand.size());
    }

    @Test
    @DisplayName("Print a players hand in sorted order")
    void printSortedHandTest() {
        cardDeck.dealCard(10, opponent);
        testHand = player.getHand().handArray;
        testHandUnsorted = opponent.getHand().handArray;
        Collections.shuffle(testHand, new Random());
        Collections.shuffle(testHandUnsorted, new Random());

        testHand.sort((card1, card2) -> {
            // compare values
            if (card1.getValue() != card2.getValue()) {
                return Integer.compare(card1.getValue(), card2.getValue());
            } else {
                // if values are same - compare by suit
                return Integer.compare(card1.getSuit(), card2.getSuit());
            }
        });

        for (Card card : player.hand.handArray) {
            System.out.println(
                    card.getValueAsString(card.getValue()) + " of " +
                            card.getSuitAsString(card.getSuit())
            );
        }

        assertNotEquals(testHand, testHandUnsorted);
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
        handObject.takeOneCardFromOpponent(opponent, player);
        //System.out.println(testHand);
        //System.out.println(testHandTwo);

        assertEquals(11, testHand.size());
        assertEquals(1, testHandTwo.size());
    }

    @Test
    @DisplayName("Remove four matching cards from Hand, put into points pile")
    void removeFourMatchingCardsTest() {
        testPointPile = player.getHand().pointPile;
        testHand = player.getHand().handArray;

        handObject.removeFourMatchingCards(player);

        assertEquals(4, testPointPile.size());
        assertEquals(6, testHand.size());
    }

    @Test
    @DisplayName("Check which individual values are in players hand Array")
    void printIndividualValuesTest() {
        testHand = player.getHand().handArray;
        testValuesOnHand = handObject.valuesOnHand;

        handObject.printIndividualValues(player);

        testUniqueValuesOnHand = handObject.uniqueValuesOnHand;

        assertEquals(3, testUniqueValuesOnHand.size());
    }

}
