package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.stage.Stage;




/*
AUTHORS:
DIONYSHS PETROTOS, dpetrotos@athtech.gr
DANIEL DIMITRIOU, ndimitriou@athtech.gr
STEFAN BORDEA, stefan@stefanbordea.com
 */

public class Main extends Application {

    private static Stage currentStage;

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("gaem");
        primaryStage.setScene(new Scene(root, 500, 500));
        primaryStage.setResizable(false);
        primaryStage.show();
        currentStage = primaryStage;

    }

    public static Stage getCurrentStage() {
        return currentStage;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
