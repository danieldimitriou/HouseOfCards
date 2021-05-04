package sample;

public class Card {
    private char suit;
    private int value;
    private boolean isPlayed = false;


    public Card(char suit, int value) {
        this.suit = suit;
        this.value = value;
    }

    public boolean isPlayed() {
        return isPlayed;
    }

    public void setPlayed(boolean played) {
        isPlayed = played;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "" + suit + value;
    }
}
