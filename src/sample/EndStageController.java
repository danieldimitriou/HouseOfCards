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

public class EndStageController implements Initializable {

    @FXML private Label resultLabel;
    @FXML private Label result;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        if (Controller.getGame().getRound() == 40) {//need to fix for when player loses at last round!! maybe check if all houses are over 31
            resultLabel.setText("You win with " + Controller.getGame().getPlayer().getPoints() + " points");
        } else {
            resultLabel.setText("You lost");
        }

    }

    public void playAgainButton(ActionEvent actionEvent) throws IOException {

        Controller.getGame().reset();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("sample.fxml"));
        Parent root = loader.load();
        Controller controller = loader.getController();
        controller.resetGame();
        Stage stage = Main.getCurrentStage();
        stage.setScene(new Scene(root, 1000, 1000));
        stage.setResizable(false);
        stage.show();

        ((Node) actionEvent.getSource()).getScene().getWindow().hide();
    }


    public void quit(ActionEvent actionEvent) {
        System.exit(0);
    }
}
