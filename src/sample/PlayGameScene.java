package sample;

import javafx.animation.AnimationTimer;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.util.Random;

public class PlayGameScene extends GridPane {

    private int counter = 0;

    private VBox firstPlayerVBox = new VBox();
    private ImageView playerHand = new ImageView();

    private VBox secondPlayerVBox = new VBox();
    private ImageView computerHand = new ImageView();

    private VBox middleText = new VBox();
    private ImageView winConditionText = new ImageView();

    public PlayGameScene(Player firstPlayer, Player secondPlayer, Game game, boolean isComputer) {

        setAlignment(Pos.CENTER);
        middleText.setAlignment(Pos.CENTER);

        if (isComputer) {
            Random random = new Random();
            int randomInt = random.nextInt(3);

            if (randomInt == 0) {
                secondPlayer.setResponseType(ResponseType.ROCK);
            } else if (randomInt == 1) {
                secondPlayer.setResponseType(ResponseType.PAPER);
            } else {
                secondPlayer.setResponseType(ResponseType.SCISSOR);
            }
        }

        firstPlayerVBox.setAlignment(Pos.CENTER);
        secondPlayerVBox.setAlignment(Pos.CENTER);

        setUpPlayerVbox(firstPlayer, secondPlayer, isComputer);

        winConditionText.setImage(new Image("images/ready.png"));
        middleText.getChildren().add(winConditionText);

        Text roundText = new Text("Round: " + game.getRound());
        roundText.setFont(Font.font("Bauhaus 93",100));
        roundText.setFill(Color.WHITE);
        middleText.getChildren().add(roundText);

        Text scoreText = new Text(firstPlayer.getScore() + " - " + secondPlayer.getScore());
        scoreText.setFont(Font.font("Bauhaus 93", 50));
        scoreText.setFill(Color.WHITE);
        middleText.getChildren().add(scoreText);

        HBox buttons = new HBox();
        buttons.setAlignment(Pos.CENTER);
        buttons.setSpacing(25);

        middleText.getChildren().add(buttons);

        Button playAgain = new Button("Play Again?");
        playAgain.setStyle("-fx-background-color: #44e9ff;");

        playAgain.setOnAction(e -> {
            if (isComputer) {
                SceneLibrary.switchToResponse();
            } else {
                SceneLibrary.switchToFirstPlayerSelectScene();
            }
        });

        Button goMenu = new Button("Go To Menu");
        goMenu.setStyle("-fx-background-color: #44e9ff;");

        goMenu.setOnAction(e -> {
            SceneLibrary.switchToIntro();
            game.resetRound();
            firstPlayer.resetScore();
            secondPlayer.resetScore();
        });

        buttons.getChildren().addAll(playAgain, goMenu);

        add(firstPlayerVBox, 0, 0);
        add(middleText, 1, 0);
        add(secondPlayerVBox,2,0);

        AnimationTimer animationTimer = new AnimationTimer() {

            long lastUpdate = 0;

            @Override
            public void handle(long now) {
                if (now - lastUpdate >= 300000000) {
                    lastUpdate = now;

                    if (counter > 8) {
                        if (isWin(firstPlayer.getResponse().getResponseType(), secondPlayer.getResponse().getResponseType()) == EndCondition.DRAW) {
                            winConditionText.setImage(new Image("images/tie.png"));
                        } else if (isWin(firstPlayer.getResponse().getResponseType(), secondPlayer.getResponse().getResponseType()) == EndCondition.WIN) {
                            winConditionText.setImage(new Image("images/won.png"));
                            firstPlayer.incrementScore();
                            game.incrementRound();
                        } else {
                            winConditionText.setImage(new Image("images/lost.png"));
                            secondPlayer.incrementScore();
                            game.incrementRound();
                        }

                        scoreText.setText(firstPlayer.getScore() + " - " + secondPlayer.getScore());

                        if (firstPlayer.getScore() == 2) {
                            game.resetRound();

                            firstPlayer.incrementStreak();
                            firstPlayer.incrementWonGames();
                            firstPlayer.resetScore();

                            secondPlayer.resetScore();
                            secondPlayer.resetStreak();
                        } else if (secondPlayer.getScore() == 2) {
                            game.resetRound();

                            firstPlayer.resetStreak();
                            firstPlayer.resetScore();

                            secondPlayer.resetScore();
                            secondPlayer.incrementWonGames();
                            secondPlayer.incrementStreak();
                        }

                        this.stop();
                    }

                    switch (counter) {
                        case 1: case 3: case 5: case 7:
                            playerHand.setImage(firstPlayer.getResponse().getTiltedImage());
                            computerHand.setImage(secondPlayer.getResponse().getTiltedImage());
                            break;
                        case 0:
                            playerHand.setImage(firstPlayer.getResponse().getStillImage());
                            computerHand.setImage(secondPlayer.getResponse().getStillImage());
                            break;
                        case 2:
                            playerHand.setImage(firstPlayer.getResponse().getStillImage());
                            computerHand.setImage(secondPlayer.getResponse().getStillImage());
                            winConditionText.setImage(new Image("images/rockWord.png"));
                            break;
                        case 4:
                            playerHand.setImage(firstPlayer.getResponse().getStillImage());
                            computerHand.setImage(secondPlayer.getResponse().getStillImage());
                            winConditionText.setImage(new Image("images/paperWord.png"));
                            break;
                        case 6:
                            playerHand.setImage(firstPlayer.getResponse().getStillImage());
                            computerHand.setImage(secondPlayer.getResponse().getStillImage());
                            winConditionText.setImage(new Image("images/scissorWord.png"));
                            break;
                        case 8:
                            playerHand.setImage(firstPlayer.getResponse().getResponseImage());
                            computerHand.setImage(secondPlayer.getResponse().getResponseImage());
                            winConditionText.setImage(new Image("images/shootWord.png"));

                    }

                    counter++;
                }
            }
        };

        animationTimer.start();
        setBackground(new Background(new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY)));

    }

    public void setUpPlayerVbox(Player firstPlayer, Player secondPlayer, boolean isComputer) {

        Text firstPlayerName = new Text("Player One");
        firstPlayerName.setFont(Font.font("Bauhaus 93",50));
        firstPlayerName.setFill(Color.WHITE);
        playerHand.setImage(firstPlayer.getResponse().getStillImage());
        Text firstPlayerGamesWon = new Text("Games Won: " + firstPlayer.getWonGames());
        firstPlayerGamesWon.setFont(Font.font("Bauhaus 93",25));
        firstPlayerGamesWon.setFill(Color.WHITE);
        firstPlayerVBox.getChildren().addAll(firstPlayerName, playerHand, firstPlayerGamesWon);

        Text secondPlayerName;

        if (isComputer) {
            secondPlayerName = new Text("Computer");
        } else {
            secondPlayerName = new Text("Player Two");
        }

        secondPlayerName.setFont(Font.font("Bauhaus 93",50));
        secondPlayerName.setFill(Color.WHITE);
        computerHand.setImage(secondPlayer.getResponse().getStillImage());
        Text secondPlayerGamesWon = new Text("Games Won:  " + secondPlayer.getWonGames());
        secondPlayerGamesWon.setFont(Font.font("Bauhaus 93",25));
        secondPlayerGamesWon.setFill(Color.WHITE);
        secondPlayerVBox.getChildren().addAll(secondPlayerName, computerHand, secondPlayerGamesWon);

    }

    public EndCondition isWin(ResponseType playerOne, ResponseType playerTwo) {
        if (playerOne == playerTwo) {
            return EndCondition.DRAW;
        } else if ((playerOne == ResponseType.ROCK && playerTwo == ResponseType.SCISSOR) || (playerOne == ResponseType.PAPER && playerTwo == ResponseType.ROCK) || (playerOne == ResponseType.SCISSOR && playerTwo == ResponseType.PAPER)) {
            return EndCondition.WIN;
        } else {
            return EndCondition.LOOSE;
        }
    }
}
