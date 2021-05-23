package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 This is the main class.
 @author Dionysis Petrotos
 @author Daniel Dimitriou
 @author Stefan Bordea
 */

public class Main extends Application {
    /**
        This is a private static Stage attribute for the current stage.
     */
    private static Stage currentStage;

    /**
     * Here the primary stage is loaded.
     * The scene along with its parameters are set e.g. width, height, resizability.
     * @param primaryStage the primary stage of the program.
     * @throws Exception exception for the start method.
     */
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("House of Cards");
        primaryStage.setScene(new Scene(root, 1000, 1000));
        primaryStage.setResizable(false);
        primaryStage.show();
        currentStage = primaryStage;
    }

    /**
     * A getter for the current stage.
     * This method returns the current stage.
     * @return the current stage.
     */
    public static Stage getCurrentStage() {
        return currentStage;
    }

    /**
     * The program is launched in the main method.
     * @param args main method argument.
     */
    public static void main(String[] args) {
        launch(args);
    }
}
