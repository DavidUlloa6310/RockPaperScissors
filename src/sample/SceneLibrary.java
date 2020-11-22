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

    private static Scene firstPlayerSelectScene = new Scene(new FirstPlayerSelectScene(playerOne), 1200, 500);
    private static Scene secondPlayerSelectScene = new Scene(new SecondPlayerSelectScene(playerTwo),1200,500);

    private static Scene introScene = new Scene(new IntroScene(), 1200, 500);

    public static void setThePrimaryStage(Stage primaryStage) {
        SceneLibrary.thePrimaryStage = primaryStage;
    }

    public static void switchToIntro() {
        thePrimaryStage.setScene(introScene);
    }

    public static void switchToResponse() {
        thePrimaryStage.setScene(selectResponseScene);
    }

    public static void switchToFirstPlayerSelectScene() {
        thePrimaryStage.setScene(firstPlayerSelectScene);
    }

    public static void switchToSecondPlayerSelectScene() {
        thePrimaryStage.setScene(secondPlayerSelectScene);
    }

    public static void switchToPlayerPlay() {
        thePrimaryStage.setScene(new Scene(new PlayGameScene(playerOne, playerTwo, game, false), 1200, 500));
    }

    public static void switchToComputerPlay(ResponseType responseType) {
        playerOne.setResponseType(responseType);
        thePrimaryStage.setScene(new Scene(new PlayGameScene(playerOne, computer, game, true), 1200, 500));
    }

}
