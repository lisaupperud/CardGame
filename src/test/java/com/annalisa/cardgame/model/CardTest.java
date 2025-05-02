package com.annalisa.cardgame.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CardTest {

    public final static int SPADES = 0;
    public final static int JACK = 11;
    private int suit;
    private int value;

    public void Card(int theSuit, int theValue) {
        suit = theSuit;
        value = theValue;
    }

    @Test
    @DisplayName("Show suit of single card")
    void getSuitTest() {
        Card(SPADES, JACK);
        assertEquals(suit, SPADES);
    }

    @Test
    @DisplayName("Show value of single card")
    void getValueTest() {
        Card(SPADES, JACK);
        assertEquals(value, JACK);
    }

    @Test
    @DisplayName("Show suit of a single card as a String")
    void getSuitAsStringTest() {
        Card(SPADES, JACK);
        // both tests passed
        assertEquals("Spades", Card.getSuitAsString(SPADES));
        // assertEquals("Spades", Card.getSuitAsString(0));
    }

    @Test
    @DisplayName("Show value of a single card as a String")
    void getValueAsStringTest() {
        Card(SPADES, JACK);
        assertEquals("Jack", Card.getValueAsString(JACK));
    }
}
