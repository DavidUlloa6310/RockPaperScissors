package sample;

import javafx.scene.Scene;
import javafx.stage.Stage;

public abstract class SceneLibrary {
    private static Stage thePrimaryStage;
    private static Scene selectResponseScene = new Scene(new SelectResponseScene(), 500, 500);

    public void setThePrimaryStage(Stage primaryStage) {
        thePrimaryStage = primaryStage;
    }

    public void setFirstScene() {
        thePrimaryStage.setScene(selectResponseScene);
    }

}
