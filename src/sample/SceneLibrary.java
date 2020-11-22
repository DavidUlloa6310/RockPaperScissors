package sample;

import javafx.scene.Scene;
import javafx.stage.Stage;

public abstract class SceneLibrary {
    private static Player playerOne = new Player();
    private static Player playerTwo = new Player();
    private static Player computer = new Player();

    private static Game game = new Game();
    private static int rounds = 0;

    private static Stage thePrimaryStage;
    private static Scene selectResponseScene = new Scene(new SelectResponseScene(), 1200, 500);
    //private static Scene

    public static void setThePrimaryStage(Stage primaryStage) {
        SceneLibrary.thePrimaryStage = primaryStage;
    }

    public static void switchToResponse() {
        thePrimaryStage.setScene(selectResponseScene);
    }

    public static void switchToComputerPlay(ResponseType responseType) {
        playerOne.setResponseType(responseType);
        thePrimaryStage.setScene(new Scene(new PlayGameScene(playerOne, computer, game, true), 1200, 500));
    }

}
