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
        if (theSuit != SPADES && theSuit != HEARTS && theSuit != DIAMONDS && theSuit != CLUBS) {
            throw new IllegalArgumentException("Invalid Suit");
        }
        if (theValue < 1 || theValue > 13) {
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

    public static String getSuitAsString(int suit) {
        return switch (suit) {
            case 0 -> "Spades";
            case 1 -> "Hearts";
            case 2 -> "Diamonds";
            case 3 -> "Clubs";
            default -> throw new IllegalArgumentException("Invalid Suit");
        };

    }

    public static String getValueAsString(int value) {
        return switch (value) {
            case 1 -> "Ace";
            case 2 -> "2";
            case 3 -> "3";
            case 4 -> "4";
            case 5 -> "5";
            case 6 -> "6";
            case 7 -> "7";
            case 8 -> "8";
            case 9 -> "9";
            case 10 -> "10";
            case 11 -> "Jack";
            case 12 -> "Queen";
            case 13 -> "King";
            default -> throw new IllegalArgumentException("Invalid Value");
        };
    }


}
