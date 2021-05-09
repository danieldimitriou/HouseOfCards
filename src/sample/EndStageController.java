package sample;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

public class EndStageController implements Initializable {

    public EndStageController() {
    }

    private boolean flag = true;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void playAgainButton(ActionEvent actionEvent) {
        flag = false;
        System.out.println(flag);
    }

    public boolean isFlag() {
        return flag;
    }

    public void quit(ActionEvent actionEvent) {
        System.exit(0);
    }
}
