package com.pubuduranasinghe;

/**
 * Created by Pubudu on 2017-06-17.
 */
public class Player {
    public String name;

    public Hand hand;

    public int score;
    private int alpha;
    private int beta;
    private int risk;

    public Player(String name, Hand hand) {
        this.name = name;
        this.hand = hand;
    }

    public void giveCard(Card card) {
        hand.addCard(card);
    }

    public Hand getHand() {
        return hand;
    }
}