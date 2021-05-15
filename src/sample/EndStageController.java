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

public class EndStageController extends Controller implements Initializable {

    @FXML private Label result;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
//        if(game.getRound() < 40)

    }

    public void playAgainButton(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        Stage stage = Main.getCurrentStage();
        stage.setScene(new Scene(root, 500, 500));
        stage.setResizable(false);
        stage.show();


        ((Node) actionEvent.getSource()).getScene().getWindow().hide();

    }





    public void quit(ActionEvent actionEvent) {
        System.exit(0);
    }
}
