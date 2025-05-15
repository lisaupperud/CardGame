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

    Player player1;
    Player player2;
    Deck cardDeck;
    Hand handObject;
    ArrayList<Card> testPointPile;
    ArrayList<Card> testPointPile2;

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
        player1 = new Player("A");
        player2 = new Player("B");
        assertNotSame(player1.hand.handArray, player2.hand.handArray);
    }

    @Test
    @DisplayName("GameOver should be true after comparePoints()")
    void comparePointsTest() {
        player1 = new Player("A");
        player2 = new Player("B");

        testPointPile = player1.getHand().pointPile;
        testPointPile2 = player2.getHand().pointPile;
        testPointPile.addAll(cardDeck.deck);

        GamePlay gamePlay = new GamePlay();
        gamePlay.comparePoints(player1, player2);
        boolean gameOver = gamePlay.gameOver;

        assertTrue(gameOver);
    }
}
