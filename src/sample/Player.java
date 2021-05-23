package sample;

public class Player {
    //Fields
    private int points;
    private Card currentCard;
    private int choice;

    public Player() {

    }

    public Player(int points) {
        this.points = points;
    }


    // use this method instead of setter for when player wins
    // adds 100 points to the player when he scores 31 in a house
    public void addPointsToPlayer() {
        this.points += 100;
    }

    // Setters
    // we will need this setter when player loses
    public void setPoints(int points) {
        this.points = points;
    }

    public void setCurrentCard(Card currentCard) {
        this.currentCard = currentCard;
    }

    public void setChoice(int choice) {
        this.choice = choice;
    }

    // Getters
    public int getPoints() {
        return points;
    }

    public Card getCurrentCard() {
        return currentCard;
    }

    public int getChoice() {
        return choice;
    }

}
