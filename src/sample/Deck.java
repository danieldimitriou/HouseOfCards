package sample;

import javafx.scene.image.Image;

import java.util.Random;

/**
 * This is the deck class.
 * The deck is characterised by the deck array and the deck images.
 */

public class Deck {
    /**
     * This is a private deckArray attribute of type Card array for the deck of cards.
     */
    private Card[] deckArray = new Card[40];

    /**
     * This is a private deckImages attribute of type Image array for the images of the cards.
     */
    private Image[] deckImages = new Image[40];

    /**
     * The non-default constructor accepts no parameters.
     * It matches the cards with their images.
     * Cards 0-9 are Hearts, 10-19 Clubs, 20-29 Diamonds, 30-39 Spades
     */
    public Deck() {
        for (int i = 0; i < deckArray.length; i++) {
            if (i <= 9) {
                deckArray[i] = new Card(i + 2);
            } else if (i <= 19) {
                deckArray[i] = new Card(i - 8);
            } else if (i <= 29) {
                deckArray[i] = new Card(i - 18);
            } else if (i <= 39) {
                deckArray[i] = new Card(i - 28);
            }
            deckImages[i] = new Image(getClass().getResourceAsStream("/resources/images/" + i + ".png"));
        }
    }

    /**
     * This method returns the deck array
     *
     * @return the deck array.
     */
    public Card[] getDeckArray() {
        return deckArray;
    }

    /**
     * This method returns the deck's card images.
     *
     * @return deck's card images.
     */
    public Image[] getDeckImages() {
        return deckImages;
    }

    /**
     * This method is used to draw a random card from the deck array.
     * It checks to only draw cards that are not already drawn and sets the drawn card to be the one being played.
     *
     * @return the random card drawn
     */
    public Card drawCard() {
        Random randomNumber = new Random();
        int n;
        do {
            n = randomNumber.nextInt(40);
        } while (deckArray[n].isPlayed());
        deckArray[n].setPlayed(true);
        return deckArray[n];
    }

    /**
     * This method is used to reset the deck.
     */
    public void resetDeck() {
        for (Card card : deckArray) {
            card.setPlayed(false);
        }
    }
}
