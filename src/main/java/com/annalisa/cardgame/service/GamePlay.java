package com.annalisa.cardgame.service;

import com.annalisa.cardgame.model.Deck;
import com.annalisa.cardgame.model.Player;
import com.annalisa.cardgame.util.ScannerUtility;

public class GamePlay {
    private Player player1;
    private Player player2;
    private Deck deck;

    public void startGame() {
        initiatePlayers();
        this.deck = new Deck();
        deck.generateDeck();
        deck.shuffleDeck();
        for (int i = 0; i < 7; i++) {
            deck.dealCard(1, player1);
            deck.dealCard(1, player2);
        }
        boolean running = true;
        while (running) {
            if (deck == null && player1.hand.handArray == null && player2.hand.handArray == null) {
                running = false;
            }
            turn(player1, player2);
            turn(player2, player1);
        }
    }

    private void initiatePlayers() {
        System.out.println("Welcome to Go Fish!, a two-player card game!\nPlayer 1, enter your name:");
        String player1Name = ScannerUtility.scanString();
        this.player1 = new Player(player1Name);
        System.out.println("\nPlayer 2, enter your name:");
        String player2Name = ScannerUtility.scanString();
        this.player2 = new Player(player2Name);
        System.out.println("\nWelcome, " + player1Name + " and " + player2Name + "!");
    }

    private void turn(Player player, Player opponent) {
        System.out.println("\n" + player.getName() + ", here is your hand:");
        player.hand.printHand(player);
        System.out.println("\nChoose which of these values to ask your opponent for:");

        player.hand.printIndividualValues(player);
        player.hand.takeOneCardFromOpponent(player, opponent);
        if (!player.hand.cardTaken) {
            player.hand.takeOneCardFromDeck(player, deck);
        }
        player.hand.removeFourMatchingCards(player);
    }


}
