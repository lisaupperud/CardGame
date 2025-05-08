package com.annalisa.cardgame;

import com.annalisa.cardgame.model.Deck;
import com.annalisa.cardgame.model.Hand;

public class Main {
    public static void main(String[] args) {
        Deck deck = new Deck();
        System.out.println("GENERATE DECK:");
        deck.generateDeck();
        System.out.println("-----------------------------");
        //deck.shuffleDeck();
        System.out.println("PRINT DECK");
        deck.printDeck();
        System.out.println("-----------------------------");
        System.out.println("DEAL 7 CARDS");
        Deck.dealCard(7);
        System.out.println("------------------------------");
        System.out.println("PRINT DECK 2ND TIME");
        deck.printDeck();
        System.out.println("--------------------------------");
        System.out.println("CARDS LEFT IN DECK");
        Deck.cardsLeft();
        System.out.println("PRINT HAND");
        Hand.printHand();
    }
}
