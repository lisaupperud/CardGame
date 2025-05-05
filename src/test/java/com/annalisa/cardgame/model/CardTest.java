package com.annalisa.cardgame.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CardTest {

    private final int SPADES = 0;
    private final int HEARTS = 1;
    private final int DIAMONDS = 2;
    private final int CLUBS = 3;

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

    @Test
    void generateDeckTest() {
        // List<Card> deck = new ArrayList<>();

        Card[] deck;
        deck = new Card[53];

        for (int i = 1; i <= 13; i++) {
            deck[i] = new Card(0, i); // First suit, ex: 3 of clubs
            deck[i+13] = new Card(1, i); // Second suit, diamonds
            deck[i+26] = new Card(2, i); // Third suit, hearts
            deck[i+39] = new Card(3, i); // Fourth suit, spades
        }

        assertEquals(53, deck.length);
    }


}
