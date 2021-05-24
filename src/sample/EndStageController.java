package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * This is the end stage controller class
 * The end stage controller is characterised by the result label.
 */
public class EndStageController implements Initializable {

    /**
     * This is a private Label attribute for the result label.
     */
    @FXML private Label resultLabel;

    /**
     * This method is used to check whether the player won or lost and sets the label accordingly.
     * @param location URL for the initialize method
     * @param resources ResourceBundle for the initialize method
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        if (Controller.getGame().getRound() == 40) {
            resultLabel.setText("You win with " + Controller.getGame().getPlayer().getPoints() + " points");
        } else {
            resultLabel.setText("You lost");
        }
    }

    /**
     * This method is used to reset the game state when the play again button is clicked.
     * It loads the controller of the first stage and hides the end stage controller.
     * @param actionEvent ActionEvent for the playAgainButton method.
     * @throws IOException IOException for the playAgainButton method.
     */
    public void playAgainButton(ActionEvent actionEvent) throws IOException {

        Controller.getGame().reset();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("sample.fxml"));
        Parent root = loader.load();
        Controller controller = loader.getController();
        controller.resetGame();
        Stage stage = Main.getCurrentStage();
        stage.setScene(new Scene(root, 1000, 1000));
        stage.setResizable(false);
        System.gc();

        ((Node) actionEvent.getSource()).getScene().getWindow().hide();
    }

    /**
     * Thid method is used to quit the game.
     * @param actionEvent ActionEvent for the quit method.
     */
    public void quit(ActionEvent actionEvent) {
        System.exit(0);
    }
}
