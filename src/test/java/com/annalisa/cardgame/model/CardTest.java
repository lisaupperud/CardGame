package com.annalisa.cardgame.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CardTest {

    public final static int SPADES = 0;
    private int suit;
    private int value;

    public void Card(int theSuit, int theValue) {
        suit = theSuit;
        value = theValue;
    }

    @Test
    @DisplayName("Show suit of single card")
    void getSuit() {
        Card(SPADES, suit);
        assertEquals(suit, SPADES);
    }

    @Test
    @DisplayName("Show value of single card")
    void getValue() {
        Card(SPADES, value);
        assertEquals(value, SPADES);
    }

    @Test
    void getSuitAsString() {
        switch (suit) {
            case SPADES:
                String spades = "Spades";
        }
        assertEquals("Spades", suit);
    }
}
