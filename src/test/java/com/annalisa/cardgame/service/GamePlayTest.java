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


    ArrayList<Card> testDeck;
    Hand playerOneHand;
    Hand playerTwoHand;
    Player player1;
    Player player2;
    Deck cardDeck;

    @BeforeEach
    @DisplayName("Generate test deck before each test")
    void setUp() {
        cardDeck = new Deck();
        cardDeck.generateDeck();
        //Deck.shuffleDeck();
    }

    @Test
    @DisplayName("Players hands should be separate ArrayList")
    void playerHandInstantiateTest() {
        playerOneHand = new Hand();
        playerTwoHand = new Hand();
        player1 = new Player("A");
        player2 = new Player("B");
        assertNotSame(playerOneHand, playerTwoHand);
    }


}
