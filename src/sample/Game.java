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
    public int cardsLeft(){
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

    //toString method
    @Override
    public String toString() {
        return "Game{" + "board=" + Arrays.toString(board) + '}';
    }
}
