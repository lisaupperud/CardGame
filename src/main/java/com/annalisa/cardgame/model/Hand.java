package com.annalisa.cardgame.model;

import java.util.ArrayList;

public class Hand {

    public static ArrayList<Card> deck;
    public static ArrayList<Card> cardsDealt;
    public static ArrayList<Card> hand;

    public static void printHand() {
        if (hand == null) {
            System.out.println("Your hand is empty");
        }
        else {
            for (Card card : hand) {
                System.out.println(card.getValueAsString(card.getValue()) + " of " + card.getSuitAsString(card.getSuit()));
            }
        }

    }

    /* use in takeCard()
        testHand.addAll(testCardsDealt);
    */

}
