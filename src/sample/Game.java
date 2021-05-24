package sample;

import java.util.Objects;

/**
 * This is the game class.
 * The game is characterised by the board, the player, the deck and the round.
 */

public class Game {
    /**
     * This is a private array attribute of type House for the board.
     */
    private House[] board = new House[4];

    /**
     * This is a private attribute of type Player for the player.
     */
    private Player player;

    /**
     * This is a private attribute of type Deck for the deck.
     */
    private Deck deck;

    /**
     * This is a private int attribute for the round.
     */
    private int round;

    /**
     * The non-default constructor accepts no parameters.
     * It sets the game round to 0, creates a new deck object, a new player object and the four houses.
     */
    public Game() {
        this.round = 0;
        this.deck = new Deck();
        this.player = new Player();
        for (int i = 0; i < 4; i++) {
            board[i] = new House();
        }
    }

    /**
     * This method is used to reset the game state by setting the player's points to 0, by calling the
     * resetDeck() method, setting the round count to 0 and clearing each house inside the board array.
     */
    public void reset() {
        player.setPoints(0);
        deck.resetDeck();
        round = 0;
        for(House house : board) {
            house.getPointsHistory().clear();
        }
    }

    /**
     * This method returns the player object.
     * @return the player.
     */
    public Player getPlayer() {
        return player;
    }

    /**
     * This method returns the deck object.
     * @return the deck.
     */
    public Deck getDeck() {
        return deck;
    }

    /**
     * This method returns the game's round.
     * @return the round.
     */
    public int getRound() {
        return round;
    }

    /**
     * This method returns the board array.
     * @return the board.
     */
    public House[] getBoard() {
        return board;
    }

    /**
     * This method is used to increase the round by 1 and returns the cards left in the game.
     * @return cards left in the game.
     */
    public int cardsLeft(){
        round++;
        return 40 - round;
    }

    /**
     * This method is used to get the index of the current card by comparing the current card object of the player
     * with the card object of the deck array.
     * @return index of current card from the deck.
     */
    public int getCardIndex() {
        int i;
        for (i = 0; i <= 39; i++) {
            if (Objects.equals(player.getCurrentCard(), deck.getDeckArray()[i])) {
                break;
            }
        }
        return i;
    }

    /**
     * This method is used to set the game's round.
     * @param round the new round of the game
     */
    public void setRound(int round) {
        this.round = round;
    }
}
