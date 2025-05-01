package com.annalisa.cardgame.model;

public class Card {

    private final int SPADES = 0;
    private final int HEARTS = 1;
    private final int DIAMONDS = 2;
    private final int CLUBS = 3;

    private final int ACE = 1;
    private final int JACK = 11;
    private final int QUEEN = 12;
    private final int KING = 13;

    final int suit;
    final int value;

    // works as a constructor to create a card and failsafe
    public Card(int theSuit, int theValue) {
        if(theSuit != SPADES && theSuit != HEARTS && theSuit != DIAMONDS && theSuit != CLUBS) {
            throw new IllegalArgumentException("Invalid Suit");
        }
        if(theValue < 1 || theValue > 13) {
            throw new IllegalArgumentException("Invalid Value");
        }
        suit = theSuit;
        value = theValue;
    }

    // getters for suit and value
    public int getSuit() {
        return suit;
    }

    public int getValue() {
        return value;
    }




}
