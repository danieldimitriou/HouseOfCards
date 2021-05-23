package sample;

/**
 * This is the player class.
 * The player is characterised by their points, their current card and their choice of where the card is placed.
 */

public class Player {
    /**
     * This is a private int attribute for the player's points.
     */
    private int points;

    /**
     * This is a private Card attribute for the player's current card.
     */
    private Card currentCard;

    /**
     * This is a private int attribute for the player's choice of card placement.
     */
    private int choice;

    /**
     * The empty non-default constructor accepts no parameters.
     */
    public Player() {
    }

    /**
     * The non-default constructor accepts one parameter:
     * @param points the player's points.
     */
    public Player(int points) {
        this.points = points;
    }

    /**
     * This method is used to add 100 points to the player when they score 31 points in a house
     */
    public void addPointsToPlayer() {
        this.points += 100;
    }

    /**
     * This method is used to set the player's points.
     * @param points the player's points.
     */
    public void setPoints(int points) {
        this.points = points;
    }

    /**
     * This method is used to set the player's current card.
     * @param currentCard the player's current card.
     */
    public void setCurrentCard(Card currentCard) {
        this.currentCard = currentCard;
    }

    /**
     * This method is used to set the player's house selection.
     * @param choice the player's choice.
     */
    public void setChoice(int choice) {
        this.choice = choice;
    }

    // Getters

    /**
     * This method returns the player's points.
     * @return the player's points
     */
    public int getPoints() {
        return points;
    }

    /**
     * This method returns the player's current card.
     * @return the player's current card.
     */
    public Card getCurrentCard() {
        return currentCard;
    }

    /**
     * This method returns the player's house selection.
     * @return the player's choice.
     */
    public int getChoice() {
        return choice;
    }

}
