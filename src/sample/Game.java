package sample;

import java.util.Arrays;
import java.util.Objects;

public class Game {
    //Fields
    private House[] board = new House[4];
    private Player player;
    private Deck deck;
    private int round;

    //Constructors
    public Game() {
        this.round = 0;
        this.deck = new Deck();
        this.player = new Player();
        for (int i = 0; i < 4; i++) {
            board[i] = new House();
        }
    }

    public void reset () {
        player.setPoints(0);
        deck.resetDeck();
        round = 0;
        for(House house : board) {
            house.getPointsHistory().clear();
        }
    }

    // Getter
    public Player getPlayer() {
        return player;
    }

    public Deck getDeck() {
        return deck;
    }

    public int getRound() {
        return round;
    }

    public House[] getBoard() {
        return board;
    }

    // Methods
    public int cardsLeft(){ // increases round by 1 and returns an int corresponding to how many cards are left
        round++;
        return 40 - round;
    }

    public int getCardIndex() {
        int i;
        for (i = 0; i <= 39; i++) {
            if (Objects.equals(player.getCurrentCard(), deck.getDeckArray()[i])) { // compares the object of the player's current card with the object of the deck array
                break;
            }
        }
        return i;
    }

    // Setter
    public void setRound(int round) {
        this.round = round;
    }

}
