package sample;

import javafx.scene.Scene;
import javafx.stage.Stage;

public abstract class SceneLibrary {
    private static Stage thePrimaryStage;
    private static Scene selectResponseScene = new Scene(new SelectResponseScene(), 1200, 500);
    //private static Scene

    public static void setThePrimaryStage(Stage primaryStage) {
        SceneLibrary.thePrimaryStage = primaryStage;
    }

    public static void switchToResponse() {
        thePrimaryStage.setScene(selectResponseScene);
    }

    public static void switchToPlay(Response response) {
        thePrimaryStage.setScene(new Scene(new PlayGameScene(response), 1200, 500));
    }

}
