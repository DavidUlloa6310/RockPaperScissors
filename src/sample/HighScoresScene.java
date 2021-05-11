package sample;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class HighScoresScene extends VBox {
    /*
    Scene which shows the high scores and stats of the players.
     */


    private HBox columns = new HBox();

    private VBox firstPlayerColumn = new VBox();
    private VBox secondPlayerColumn = new VBox();
    private VBox computerPlayerColumn = new VBox();

    public HighScoresScene(Player firstPlayer, Player secondPlayer, Player computer) {

        setAlignment(Pos.CENTER);
        setSpacing(25);

        firstPlayerColumn.setAlignment(Pos.CENTER);
        secondPlayerColumn.setAlignment(Pos.CENTER);
        computerPlayerColumn.setAlignment(Pos.CENTER);

        firstPlayerColumn.getChildren().add(new ImageView("images/playerOne.png"));

        secondPlayerColumn.getChildren().add(new ImageView("images/playerTwo.png"));

        computerPlayerColumn.getChildren().add(new ImageView("images/computer.png"));

        generateText(firstPlayerColumn, firstPlayer);
        generateText(secondPlayerColumn, secondPlayer);
        generateText(computerPlayerColumn, computer);

        columns.getChildren().addAll(firstPlayerColumn, secondPlayerColumn, computerPlayerColumn);

        Button goMenu = new Button("Go To Menu");
        goMenu.setStyle("-fx-background-color: #44e9ff;");

        goMenu.setOnAction(e -> {
            SceneLibrary.switchToIntro();
        });

        getChildren().addAll(columns, goMenu);

        setBackground(new Background(new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY)));
    }

    private int generatePercent(Player player, ResponseType responseType) {
        if (player.getPlayedPaper() + player.getPlayedRock() + player.getPlayedScissors() == 0) {
            return 0;
        }

        if (responseType == ResponseType.PAPER) {
           double doubleValue = (double) player.getPlayedPaper() / (player.getPlayedPaper() + player.getPlayedRock() + player.getPlayedScissors());
           return (int) (doubleValue * 100);
        } else if (responseType == ResponseType.ROCK) {
            double doubleValue = (double) player.getPlayedRock() / (player.getPlayedPaper() + player.getPlayedScissors() + player.getPlayedRock());
            return (int) (doubleValue * 100);
        } else {
            double doubleValue = (double) player.getPlayedScissors() / (player.getPlayedPaper() + player.getPlayedScissors() + player.getPlayedRock());
            return (int) (doubleValue * 100);
        }

    }

    public void generateText(VBox vBox, Player player) {
        Text firstPlayerGame = new Text("Player One Games Won: " + player.getWonGames());
        firstPlayerGame.setFont(Font.font("Bauhaus 93", 25));
        firstPlayerGame.setFill(Color.WHITE);

        Text firstPlayerStreak = new Text("Player One Highest Streak: " + player.getHighestStreak());
        firstPlayerStreak.setFont(Font.font("Bauhaus 93", 25));
        firstPlayerStreak.setFill(Color.WHITE);

        Text firstPlayerRock = new Text("Chance to play COVID (rock): " + generatePercent(player, ResponseType.ROCK) + "%");
        Text firstPlayerScissor = new Text("Chance to play ANTI-VAX (scissor) " + generatePercent(player, ResponseType.SCISSOR) + "%");
        Text firstPlayerPaper = new Text("Chance to play Cure (paper) " + generatePercent(player, ResponseType.PAPER) + "%");

        firstPlayerRock.setFont(Font.font("Bauhaus 93", 25));
        firstPlayerRock.setFill(Color.WHITE);

        firstPlayerScissor.setFont(Font.font("Bauhaus 93", 25));
        firstPlayerScissor.setFill(Color.WHITE);

        firstPlayerPaper.setFont(Font.font("Bauhaus 93", 25));
        firstPlayerPaper.setFill(Color.WHITE);

        vBox.getChildren().addAll(firstPlayerGame, firstPlayerStreak, firstPlayerRock, firstPlayerScissor, firstPlayerPaper);
    }

}
