package com.annalisa.cardgame.service;

import com.annalisa.cardgame.model.Card;
import com.annalisa.cardgame.model.Deck;
import com.annalisa.cardgame.model.Hand;
import com.annalisa.cardgame.model.Player;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class GamePlayTest {

    // TODO - findSpecificCard we must have index of specific card --> return index in method ?
    // TODO - remove all static stuff

    ArrayList<Card> testDeck;
    Hand playerOneHand;
    Hand playerTwoHand;
    Player player1;
    Player player2;

    @BeforeEach
    @DisplayName("Generate test deck before each test")
    void setUp() {
        Deck.generateDeck();
        //Deck.shuffleDeck();
    }

    @Test
    @DisplayName("Players hands should be separate ArrayList")
    void playerHandInstantiateTest() {
        player1 = new Player("A");
        player2 = new Player("B");
        assertNotSame(playerOneHand, playerTwoHand);
    }

    @Test
    @DisplayName("Checks index of specific card")
    void findSpecificCardTest() {
        testDeck = Deck.deck;
        boolean matchingCardFound = false;
        int suit = 2;
        int value = 7;

        for (Card card : testDeck) {
            if (card.getSuit() == suit && card.getValue() == value) {
                matchingCardFound = true;
                System.out.println("Card found: " + card);
                break;
            }
        }
        if (!matchingCardFound) {
            System.out.println("Card not found");
        }

        assertTrue(matchingCardFound);

    }

}
