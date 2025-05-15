package com.annalisa.cardgame.service;

import com.annalisa.cardgame.model.Deck;
import com.annalisa.cardgame.model.Player;
import com.annalisa.cardgame.util.ScannerUtility;

public class GamePlay {
    private Player player1;
    private Player player2;
    private Deck deck;
    boolean gameOver;

    public void runGame() {
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
                comparePoints(player1, player2);
                running = false;
            } else if (gameOver) {
                running = false;
            }
            turn(player1, player2);
            comparePoints(player1, player2);
            if (gameOver) {
                running = false;
            }
            turn(player2, player1);
            comparePoints(player2, player1);
            if (gameOver) {
                running = false;
            }
        }
        System.out.println("Game over! Thank you for playing!");
        ScannerUtility.closeScanner();
    }

    private void initiatePlayers() {
        System.out.println("Welcome to Go Fish!, a two-player card game!\n\u001B[33mPlayer 1\u001B[0m, enter your name:");
        String player1Name = ScannerUtility.scanString();
        this.player1 = new Player(player1Name);
        System.out.println("\n\u001B[33mPlayer 2\u001B[0m, enter your name:");
        String player2Name = ScannerUtility.scanString();
        this.player2 = new Player(player2Name);
        System.out.println("\nWelcome, \u001B[33m" + player1Name + "\u001B[0m and \u001B[33m" + player2Name + "\u001B[0m!");
    }

    // TODO - test that if (player.hand.handArray = null) functions as intended

    private void turn(Player player, Player opponent) {
        System.out.println("\n\u001B[33m" + player.getName() + "\u001B[0m, here is your hand:");
        player.hand.printSortedHand(player);
        if (player.getHand().handArray != null || opponent.getHand().handArray != null) {
            System.out.println("\nChoose which of these values to ask your opponent for:");
            player.hand.printIndividualValues(player);
            player.hand.takeOneCardFromOpponent(player, opponent);
            if (!player.hand.cardTaken) {
                player.hand.takeOneCardFromDeck(player, deck);
            }
            player.hand.removeFourMatchingCards(player);
        } else {
            player.hand.takeOneCardFromDeck(player, deck);
        }
    }

    public void comparePoints(Player player1, Player player2) {
        if (player1.getHand().getPointPile().size() >= 28) {
            System.out.println("\n\u001B[33m" + player1.getName() + "\u001B[0m won!");
            gameOver = true;
        }
        if (player2.getHand().getPointPile().size() >= 28) {
            System.out.println("\n\u001B[33m" + player2.getName() + "\u001B[0m won!");
            gameOver = true;
        }
    }
}
