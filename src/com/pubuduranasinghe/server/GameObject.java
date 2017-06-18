package com.pubuduranasinghe.server;

import java.util.Scanner;

/**
 * Created by Pubudu on 2017-06-17.
 */
public class GameObject {
    public static void play() {
        int user_score = 0, computer_score = 0;
        int user_score_alpha = 0;
        int user_score_beta = 0;
        int user_score_risk = 0;
        int computer_score_alpha = 0;
        int computer_score_beta = 0;
        int computer_score_risk = 0;

        System.out.println("This program lets you play a simple Foker card game");
        Deck deck = new Deck();

        System.out.println("Shuffling..");
        deck.shuffle();

        System.out.println("Dealing..");

        Player user = new Player("Player 1", new Hand());
        Player computer = new Player("Computer", new Hand());

        user.giveCards(deck.dealCards(5));
        computer.giveCards(deck.dealCards(5));

        printInitialHand(user.getHand(), computer.getHand());

        user_score_alpha = user.hand.calculateHandScore();
        computer_score_alpha = computer.hand.calculateHandScore();

        Scanner input = new Scanner(System.in);
        for(int i = 0; i < 3; i++) {
            System.out.println("You can swap "+(3-i)+" cards. Enter index of card to swap. (0 to skip)");
            int card_index = input.nextInt() - 1;
            if(card_index == -1) break;
            deck.returnCard(user.hand.getCard(card_index));
            deck.shuffleExisting();
            user.hand.replaceCard(card_index, deck.dealCard());
        }

        user_score_beta = user.hand.calculateHandScore();
        computer_score_beta = computer.hand.calculateHandScore();

        printSecondHand(user.getHand(), computer.getHand());

        System.out.println("Scoring..");
        user_score = calculateScore(user_score_alpha, user_score_beta, 1);
        computer_score = calculateScore(computer_score_alpha, computer_score_beta, 1);
        System.out.format("%-30s%-30s", user_score, computer_score);
        System.out.println();

        //announce winner
        if(user_score == computer_score)
            System.out.println("IT'S A TIE!!");
        else if(user_score > computer_score)
            System.out.println("YOU WIN!!");
        else
            System.out.println("COMPUTER WON!");

    }

    public static void printInitialHand(Hand user, Hand computer) {
        System.out.format("%-30s%-30s", "Your hand", "Computer Hand");
        System.out.println();
        System.out.format("%-30s%-30s", "----------", "----------");
        System.out.println();
        //print first two cards in hand
        for(int i = 0; i < 2; i++) {
            System.out.printf(i+1+") "+"%-30s"+(i+1)+") "+"%-30s", user.getCard(i), computer.getCard(i));
            System.out.println();
        }
        //print rest of hand
        for(int i = 2; i < 5; i++) {
            System.out.printf(i+1+") "+"%-30s"+(i+1)+") "+"%-30s", user.getCard(i), "XX");
            System.out.println();
        }

    }

    public static void printSecondHand(Hand user, Hand computer) {
        System.out.format("%-30s%-30s", "Your hand", "Computer Hand");
        System.out.println();
        System.out.format("%-30s%-30s", "----------", "----------");
        System.out.println();
        //print first two cards in hand
        for(int i = 0; i < 2; i++) {
            System.out.printf(i+1+") "+"%-30s"+(i+1)+") "+"%-30s", user.getCard(i), "XX");
            System.out.println();
        }
        //print rest of hand
        for(int i = 2; i < 5; i++) {
            System.out.printf(i+1+") "+"%-30s"+(i+1)+") "+"%-30s", user.getCard(i), "XX");
            System.out.println();
        }

    }

    private static int calculateScore(int alpha, int beta, int risk) {
        int delta;
        delta = ((alpha - beta) <= 0) ? 1 : -1;
//        return (alpha - beta) + delta * risk;
        return alpha;
    }
}
