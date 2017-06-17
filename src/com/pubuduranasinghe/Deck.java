package com.pubuduranasinghe;

/**
 * Created by Pubudu on 2017-06-15.
 */
public class Deck {
    private Card[] deck;
    //number of cards dealt
    private int cardsUsed;

    public Deck() {
        deck = new Card[52];
        int cardCount = 0;
        for(int s = 0; s <= 3; s++) {
            for(int v = 1; v <= 13; v++) {
                deck[cardCount] = new Card(s, v);
                cardCount++;
            }
        }
        cardsUsed = 0;
    }

    public void shuffle() {
        for(int i = deck.length-1; i > 0; i--) {
            int rand = (int) (Math.random()*(i+1));
            Card tmp = deck[i];
            deck[i] = deck[rand];
            deck[rand] = tmp;
        }
        cardsUsed = 0;
    }

    public void shuffleExisting() {
        for(int i = deck.length-1; i > 0; i--) {
            int rand = (int) (Math.random()*(i+1));
            Card tmp = deck[i];
            deck[i] = deck[rand];
            deck[rand] = tmp;
        }
    }

    public int cardsLeft() {
        return deck.length - cardsUsed;
    }

    public Card dealCard() {
        if(cardsUsed == deck.length)
            throw new IllegalStateException("Deck is empty");
        cardsUsed++;
        return deck[cardsUsed -1];
    }

    public void returnCard(Card card) {
        if(cardsLeft() == 52)
            throw new IllegalStateException("Deck is already full");
        deck[cardsLeft()] = card;
        cardsUsed--;
    }
}
