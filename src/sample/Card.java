package sample;

public class Card {

    private int value;
    private boolean isPlayed = false;


    public Card(int value) {

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

}
