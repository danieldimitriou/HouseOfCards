package sample;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

public class EndStageController implements Initializable {


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void resetGame(ActionEvent actionEvent) {
    }

    public void quit(ActionEvent actionEvent) {
        System.exit(0);
    }
}
