package sample;

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

public class Controller implements Initializable {
    public VBox vbox;
    @FXML private Label currentHouseTotal;
    @FXML private Label playerPoints;
    @FXML private Label cardsLeft;
    @FXML
    private ImageView house1Image;
    @FXML
    private ImageView house2Image;
    @FXML
    private ImageView house3Image;
    @FXML
    private ImageView house4Image;
    @FXML
    private Label house1Total;
    @FXML
    private Label house2Total;
    @FXML
    private Label house3Total;
    @FXML
    private Label house4Total;
    @FXML
    private ImageView currentCard;
    private Game game = new Game();
    @FXML private int currentCardValue;


    public void placeCard(MouseEvent mouseEvent) throws IOException {

        ImageView imageView = (ImageView) mouseEvent.getSource();
            // if statements used when clicking a house image
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


        clearHouseIfPlayerScoresAndAddPoints(currentHouseTotal, imageView); // clear house and award player
        closeHouse(game.getPlayer().getChoice(), imageView); // close house when over 31
        showCurrentCard(); // show the current card at the bottom

        // WORK IN PROGRESS - draw a new window when player wins/loses and ask to play again or exit, also make images unclickable
        if (house1Image.isDisable() && house2Image.isDisable() && house3Image.isDisable() && house4Image.isDisable()) {
            System.out.println("You lose");
            for(int i = 0; i < game.getBoard().length; i++){ // we can put this in a method since it is repeated below
                closeHouse(i , imageView);
            }
            gameEnd(false);

        } else if (game.getRound() == 40) {
            System.out.println("You win");
            for(int i = 0; i < game.getBoard().length; i++){
                closeHouse(i , imageView);
            }
            gameEnd(true);
        }

    }

    public void showCurrentCard() {
        game.getPlayer().setCurrentCard(game.getDeck().drawCard()); // draws a card from the deck arraylist and sets it as the current card
        cardsLeft.setText("Cards left: " + (game.cardsLeft() + 1)); // when card is drawn, decrease card counter by 1
        currentCard.setImage(new Image(getClass().getResourceAsStream("/resources/images/" + game.getCardIndex() + ".png"))); // shows the card that is drawn from the deck arraylist
    }

    public void replaceCard(ImageView imageView) { //sets the card in the chosen house
        imageView.setImage(new Image(getClass().getResourceAsStream("/resources/images/" + game.getCardIndex() + ".png")));
    }

    public void playRound(int choice, Label houseTotal, ImageView houseImage){ // sets the total amount on each house
        game.getPlayer().setChoice(choice);
        replaceCard(houseImage);
        currentCardValue = game.getBoard()[game.getPlayer().getChoice()].addPoints(game.getPlayer().getCurrentCard().getValue());
        houseTotal.setText("House " + (choice + 1) + " total: "  + game.getBoard()[choice].calculateSumOfHouse());
    }

    public void closeHouse(int choice, ImageView houseImage){ // closes the house, changes the image and makes it disabled
        if(game.getBoard()[choice].isClosed()){
            houseImage.setImage(new Image(getClass().getResourceAsStream("/resources/images/stop.jpeg")));
            houseImage.setDisable(true);
        }
    }

    public void clearHouseIfPlayerScoresAndAddPoints(Label label, ImageView imageView){
        if(game.getBoard()[game.getPlayer().getChoice()].calculateSumOfHouse() == 31){  //when a house goes 31
            game.getBoard()[game.getPlayer().getChoice()].clearHouse();                // clear that house
            game.getPlayer().addPointsToPlayer();                                     // add 100 points to the player
            playerPoints.setText("Player points: " + game.getPlayer().getPoints());  // change the label of the player's score
            label.setText("House " + (game.getPlayer().getChoice() + 1) + " total: 0"); // change the label of the house's total
            imageView.setImage(new Image(getClass().getResourceAsStream("/resources/images/houseDefault.png"))); // set house image to the default one
        }
    }

    public void gameEnd(boolean won) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("endStage.fxml"));
        Stage endStage = new Stage();
        if(won){
            endStage.setTitle("win"); //create a window when you win
        } else{
            endStage.setTitle("lose"); //create an other window when you lose
        }
        endStage.setScene(new Scene(root, 450, 350)); // window is on top of the main game window
        endStage.show();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        showCurrentCard();
        BackgroundSize backgroundSize = new BackgroundSize(500,
                500,
                false,
                false,
                false,
                true);
        BackgroundImage image = new BackgroundImage(new Image("/resources/images/background.jpeg"),
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                backgroundSize);

        vbox.setBackground(new Background(image));
    }
}
