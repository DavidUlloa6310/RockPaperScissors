package sample;

import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public abstract class SceneLibrary {
    private static Player playerOne = new Player();
    private static Player playerTwo = new Player();
    private static Player computer = new Player();

    private static Game game = new Game();
    private static int rounds = 0;

    private static Stage thePrimaryStage;

    private static Scene selectResponseScene = new Scene(new SelectResponseScene(), 1300, 700, Color.BLACK);

    private static Scene firstPlayerSelectScene = new Scene(new FirstPlayerSelectScene(playerOne), 1300, 700, Color.BLACK);
    private static Scene secondPlayerSelectScene = new Scene(new SecondPlayerSelectScene(playerTwo),1300,700, Color.BLACK);

    private static Scene introScene = new Scene(new IntroScene(), 1300, 700);

    public static void setThePrimaryStage(Stage primaryStage) {
        SceneLibrary.thePrimaryStage = primaryStage;
    }

    public static void switchToIntro() {
        thePrimaryStage.setScene(introScene);
    }

    public static void switchToHighScore() {
        thePrimaryStage.setScene(new Scene(new HighScoresScene(playerOne, playerTwo, computer), 1300, 700));
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
        thePrimaryStage.setScene(new Scene(new PlayGameScene(playerOne, playerTwo, game, false), 1300, 700, Color.BLACK));
    }

    public static void switchToComputerPlay(ResponseType responseType) {
        playerOne.setResponseType(responseType);
        thePrimaryStage.setScene(new Scene(new PlayGameScene(playerOne, computer, game, true), 1300, 700, Color.BLACK));
    }

}
