package sample;

/**
 * This is the card class.
 * The card is characterised by its value and whether is has been played or not.
 */

public class Card {
    /**
     * This is a private int attribute for the card's value.
     */
    private int value;

    /**
     * This is a private boolean attribute for whether or not a card has been played.
     */
    private boolean isPlayed = false;

    /**
     * The non-default constructor accepts one parameter:
     * @param value the card's value.
     */
    public Card(int value) {
        this.value = value;
    }

    /**
     * This method is used to determine whether a card has been played or not.
     * @return true of false depending on whether the card has been played.
     */
    public boolean isPlayed() {
        return isPlayed;
    }

    /**
     * This method is used to set a card to played or not played.
     * @param played true or false depending on whether the card needs to be played.
     */
    public void setPlayed(boolean played) {
        isPlayed = played;
    }

    /**
     * This method returns the value of the card.
     * @return the value of the card.
     */
    public int getValue() {
        return value;
    }
}
