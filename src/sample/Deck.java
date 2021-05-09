package sample;

import java.util.Arrays;
import java.util.Random;

public class Deck {
    //Fields
    private Card[] deckArray = new Card[40];

    // Constructor
    public Deck(){ //cards 0-9 are Hearts, 10-19 Clubs, 20-29 Diamonds, 30-39 spades
        for(int i = 0; i < deckArray.length; i++){
            if(i <= 9){
                deckArray[i] = new Card('H', i + 2);
            }
            else if(i <= 19){
                deckArray[i] = new Card('C', i - 8);
            }
            else if(i <= 29){
                deckArray[i] = new Card('D', i - 18);
            }
            else if(i <= 39){
                deckArray[i] = new Card('S', i - 28);
            }
        }
    }

    //Getters
    public Card[] getDeckArray() {
        return deckArray;
    }

    public Card drawCard(){ // draws a random card based on the deck array 0-39
        Random randomNumber = new Random();
        int n;
        do{
            n = randomNumber.nextInt(40); // checks and does not draw cards that are already drawn
        }while(deckArray[n].isPlayed());
        deckArray[n].setPlayed(true); // sets picked card to played
        return deckArray[n];
    }

    public void resetDeck() {
        for (Card card : deckArray) {
            card.setPlayed(false);
        }
    }

    @Override
    public String toString() {
        return Arrays.toString(deckArray);
    }
}
