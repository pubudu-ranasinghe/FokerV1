package com.pubuduranasinghe.server;

import java.util.ArrayList;

/**
 * Created by Pubudu on 2017-06-15.
 */
public class Hand {
    private ArrayList<Card> hand;

    public Hand() {
        this.hand = new ArrayList<Card>();
    }

    public void clear() {
        hand.clear();
    }

    public void addCard(Card c) {
        if(c == null)
            throw new NullPointerException("Cant add null card");
        hand.add(c);
    }

    public void removeCard(int position) {
        if(position < 0 || position >= hand.size())
            throw new IllegalArgumentException(position + "card does not exist in hand");
        hand.remove(position);
    }

    public int getCardCount() { return hand.size(); }

    public Card getCard(int position) {
        if(position < 0 || position >= hand.size())
            throw new IllegalArgumentException(position + "card does not exist in hand");
        return hand.get(position);
    }

    public void sortBySuit() {
        ArrayList<Card> newHand = new ArrayList<Card>();
        while(hand.size() > 0) {
            int pos = 0;
            Card c = hand.get(0);
            for(int i = 1; i < hand.size(); i++) {
                Card c1 = hand.get(i);
                if(c1.getSuit() < c.getSuit() ||
                        (c1.getSuit() == c.getSuit() && c1.getValue() < c.getValue())) {
                    pos = i;
                    c = c1;
                }
            }
            hand.remove(pos);
            newHand.add(c);
        }
        hand = newHand;
    }

    public void sortByValue() {
        ArrayList<Card> newHand = new ArrayList<Card>();
        while (hand.size() > 0) {
            int pos = 0;
            Card c = hand.get(0);
            for (int i = 1; i < hand.size(); i++) {
                Card c1 = hand.get(i);
                if ( c1.getValue() < c.getValue() ||
                        (c1.getValue() == c.getValue() && c1.getSuit() < c.getSuit()) ) {
                    pos = i;
                    c = c1;
                }
            }
            hand.remove(pos);
            newHand.add(c);
        }
        hand = newHand;
    }

    public void replaceCard(int position, Card card) {
        if(position < 0 || position >= hand.size())
            throw new IllegalArgumentException(position + "card does not exist in hand");
        hand.set(position, card);
    }

    public int calculateHandScore() {
        int score = 0;
        for(int i = 0; i < hand.size(); i++)
            score += hand.get(i).getValue();
        return score;
    }
}
