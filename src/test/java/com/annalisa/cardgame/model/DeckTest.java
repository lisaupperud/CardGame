package com.annalisa.cardgame.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DeckTest {

    private final int SPADES = 0;
    private final int HEARTS = 1;
    private final int DIAMONDS = 2;
    private final int CLUBS = 3;


    @Test
    @DisplayName("Generate a deck of cards")
    void generateDeckTest() {
        Deck.generateDeck();
        Card[] testDeck = Deck.deck;
        assertEquals(53, testDeck.length);
    }
}
