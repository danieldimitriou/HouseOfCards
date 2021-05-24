package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * This is the controller class.
 * The controller is characterised by the Vbox, the current house total, the player points, the cards left,
 * the house 1 image, house 2 image, house 3 image, house 4 image, the house 1 total, house 2 total, house 3 total,
 * house 4 total, the current card, the current card value, the game, the default house image, the stop image,
 * the background size and the image.
 */

public class Controller implements Initializable {
    /**
     * This is a private VBox attribute for the vbox.
     */
    @FXML
    private VBox vbox;

    /**
     * This is a private Label attribute for the current house total score.
     */
    @FXML
    private Label currentHouseTotal;

    /**
     * This is a private Label attribute for the player's points.
     */
    @FXML
    private Label playerPoints;

    /**
     * This is a private Label attribute for the cards left.
     */
    @FXML
    private Label cardsLeft;

    /**
     * This is a private ImageView attribute for the house 1 image.
     */
    @FXML
    private ImageView house1Image;

    /**
     * This is a private ImageView attribute for the house 2 image.
     */
    @FXML
    private ImageView house2Image;

    /**
     * This is a private ImageView attribute for the house 3 image.
     */
    @FXML
    private ImageView house3Image;

    /**
     * This is a private ImageView attribute for the house 4 image.
     */
    @FXML
    private ImageView house4Image;

    /**
     * This is a private ImageView attribute for the house 1 total.
     */
    @FXML
    private Label house1Total;

    /**
     * This is a private ImageView attribute for the house 2 total.
     */
    @FXML
    private Label house2Total;

    /**
     * This is a private ImageView attribute for the house 3 total.
     */
    @FXML
    private Label house3Total;

    /**
     * This is a private ImageView attribute for the house 4 total.
     */
    @FXML
    private Label house4Total;

    /**
     * This is a private ImageView attribute for the current card.
     */
    @FXML
    private ImageView currentCard;

    /**
     * This is a private ImageView attribute for the current card's value.
     */
    @FXML
    private int currentCardValue;

    /**
     * This is a private Game attribute where the game object is initialised.
     */
    private static Game game = new Game();

    /**
     * This is a private Image attribute where the default house image object is initialised.
     */
    private static Image defaultHouseImage = new Image("/resources/images/houseDefault.png");

    /**
     * This is a private Image attribute where the stop image object is initialised.
     */
    private static Image stopImage = new Image("/resources/images/stop.png");

    /**
     * This is a private BackgroundSize attribute where the background size and its parameters are initialised.
     */
    private static BackgroundSize backgroundSize = new BackgroundSize(500,
            500,
            false,
            false,
            false,
            true);

    /**
     * This is a private BackgroundImage attribute where the background image and its parameters are initialised.
     */
    private static BackgroundImage image = new BackgroundImage(new Image("/resources/images/background.jpeg"),
            BackgroundRepeat.NO_REPEAT,
            BackgroundRepeat.NO_REPEAT,
            BackgroundPosition.CENTER,
            backgroundSize);


    /**
     * This method is used to place the current card on the selected house with a click of the mouse.
     * It clears the house and awards the player 100 points when they score 31 in a house.
     * It closes the house if the player scores more than 31 in a house.
     * It draws a new window by calling the gameEnd method when a player wins or loses and makes the images un-clickable
     * It draws a card and shows it only if the round < 40
     *
     * @param mouseEvent the mouse click event.
     * @throws IOException IOException for the placeCard method.
     */
    public void placeCard(MouseEvent mouseEvent) throws IOException {

        ImageView imageView = (ImageView) mouseEvent.getSource();

        if (imageView == house1Image) {
            playRound(0, house1Total, house1Image);
            currentHouseTotal = house1Total;
        } else if (imageView == house2Image) {
            playRound(1, house2Total, house2Image);
            currentHouseTotal = house2Total;
        } else if (imageView == house3Image) {
            playRound(2, house3Total, house3Image);
            currentHouseTotal = house3Total;
        } else if (imageView == house4Image) {
            playRound(3, house4Total, house4Image);
            currentHouseTotal = house4Total;
        }

        clearHouseIfPlayerScoresAndAddPoints(currentHouseTotal, imageView);
        closeHouse(game.getPlayer().getChoice(), imageView);

        if (game.getRound() == 40) {
            disableImages(true);
            gameEnd(true);
            currentCard.setImage(defaultHouseImage);
            cardsLeft.setText("Cards left: " + "0");
        } else if (house1Image.isDisable() && house2Image.isDisable() && house3Image.isDisable() && house4Image.isDisable()) {
            disableImages(true);
            gameEnd(false);

        }
        if (game.getRound() < 40) {
            showCurrentCard();
        }
    }

    /**
     * This method is used to show the current card.
     * It draws a card from the deck ArrayList and sets it as the current card and changes the text.
     * When a card is drawn, it decreases the card counter by 1
     * It shows the card that is drawn from the deck ArrayList
     */
    public void showCurrentCard() {
        game.getPlayer().setCurrentCard(game.getDeck().drawCard());
        cardsLeft.setText("Cards left: " + (game.cardsLeft() + 1));
        currentCard.setImage(game.getDeck().getDeckImages()[game.getCardIndex()]);
    }

    /**
     * This method is used to place card in a chosen house.
     *
     * @param imageView the house's ImageView.
     */
    public void replaceCard(ImageView imageView) {
        imageView.setImage(game.getDeck().getDeckImages()[game.getCardIndex()]);
    }

    /**
     * This method is used to set the total amount on each house and changes the text.
     *
     * @param choice     the player's house choice.
     * @param houseTotal the house total Label.
     * @param houseImage the house image ImageView
     */
    public void playRound(int choice, Label houseTotal, ImageView houseImage) {
        game.getPlayer().setChoice(choice);
        replaceCard(houseImage);
        currentCardValue = game.getBoard()[game.getPlayer().getChoice()].addPoints(game.getPlayer().getCurrentCard().getValue());
        houseTotal.setText("House " + (choice + 1) + " \ntotal: " + game.getBoard()[choice].calculateSumOfHouse());
    }

    /**
     * This method is used to close a house.
     * It changes the image to the stop image and makes it un-clickable.
     *
     * @param choice     the player's house of choice.
     * @param houseImage the house's image ImageView.
     */
    public void closeHouse(int choice, ImageView houseImage) {
        if (game.getBoard()[choice].isClosed()) {
            houseImage.setImage(stopImage);
            houseImage.setDisable(true);
        }
    }

    /**
     * This method is used to clear a house when the player scores 31 in it.
     * It awards the player 100 points.
     * It changes the label of the player's score.
     * It changes the label of the house's total.
     * It sets the house image to the default one.
     *
     * @param label     the house's Label.
     * @param imageView the house's ImageView.
     */
    public void clearHouseIfPlayerScoresAndAddPoints(Label label, ImageView imageView) {
        if (game.getBoard()[game.getPlayer().getChoice()].calculateSumOfHouse() == 31) {

            game.getBoard()[game.getPlayer().getChoice()].clearHouse();
            game.getPlayer().addPointsToPlayer();
            playerPoints.setText("Player points: " + game.getPlayer().getPoints());
            label.setText("House " + (game.getPlayer().getChoice() + 1) + " \ntotal: 0");
            imageView.setImage(defaultHouseImage);
        }
    }

    /**
     * This method is used to create a new stage when the game ends.
     * If the player won, it creates a window with title "YOU WIN!"
     * If the player lost, it creates a window with title "YOU LOSE!" and sets the player's points to 0.
     *
     * @param won true or false depending on whether the player won or lost.
     * @throws IOException IOException for the gameEnd method.
     */
    public void gameEnd(boolean won) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("endStage.fxml"));
        Stage endStage = new Stage();
        if (won) {
            endStage.setTitle("YOU WIN!");
        } else {
            endStage.setTitle("YOU LOSE!");
            game.getPlayer().setPoints(0);
            playerPoints.setText("Player points: 0");
        }
        endStage.setScene(new Scene(root, 450, 350));
        endStage.show();
        endStage.setAlwaysOnTop(true);
    }

    /**
     * This method is used to reset the game state.
     * It sets all the house images to the default one.
     * It makes the images clickable again.
     * It sets the cardsLeft and house totals text to 40 and 0 respectively.
     */
    public void resetGame() {

        game.reset();

        house1Image.setImage(defaultHouseImage);
        house2Image.setImage(defaultHouseImage);
        house3Image.setImage(defaultHouseImage);
        house4Image.setImage(defaultHouseImage);

        disableImages(false);

        cardsLeft.setText("Cards left: 40");
        house1Total.setText("House \ntotal: 0");
        house2Total.setText("House \ntotal: 0");
        house3Total.setText("House \ntotal: 0");
        house4Total.setText("House \ntotal: 0");
        playerPoints.setText("Player points: 0");
    }

    /**
     * This method is used to quit the game.
     *
     * @param actionEvent ActionEvent for the quitGame method.
     */
    public void quitGame(ActionEvent actionEvent) {
        System.exit(0);
    }

    /**
     * This method is used to make all the house images un-clickable or not.
     *
     * @param value true or false depending on whether the house images need to be disabled.
     */
    public void disableImages(boolean value) {
        house1Image.setDisable(value);
        house2Image.setDisable(value);
        house3Image.setDisable(value);
        house4Image.setDisable(value);
    }

    /**
     * This method retuns the game.
     *
     * @return the game.
     */
    public static Game getGame() {
        return game;
    }

    /**
     * This method is used to set the parameters for the game window.
     * It calls the showCurrentCard method when the game starts and sets the background image.
     *
     * @param location  URL for the initialize method
     * @param resources ResourceBundle for the initialize method
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        showCurrentCard();
        vbox.setBackground(new Background(image));
    }
}
