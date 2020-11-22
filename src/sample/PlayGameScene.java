package sample;

import javafx.animation.AnimationTimer;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.util.Random;

public class PlayGameScene extends GridPane {

    private int counter = 0;

    private ImageView playerHand = new ImageView();
    private ImageView computerHand = new ImageView();

    private VBox middleText = new VBox();
    private ImageView winConditionText = new ImageView();

    public PlayGameScene(Player firstPlayer, Player secondPlayer, Game game, boolean isComputer) {

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

        playerHand.setImage(firstPlayer.getResponse().getStillImage());
        computerHand.setImage(secondPlayer.getResponse().getStillImage());
        add(playerHand,0,0);

        winConditionText.setImage(new Image("images/ready.png"));
        middleText.getChildren().add(winConditionText);

        Text roundText = new Text("Round: " + game.getRound());
        roundText.setFont(Font.font("Bauhaus",100));
        middleText.getChildren().add(roundText);

        Text scoreText = new Text(firstPlayer.getScore() + " - " + secondPlayer.getScore());
        scoreText.setFont(Font.font("Bauhaus", 100));
        middleText.getChildren().add(scoreText);

        Button playAgain = new Button("Play Again?");
        playAgain.setOnAction(e -> {
            if (isComputer) {
                SceneLibrary.switchToResponse();
            } else {
                SceneLibrary.switchToFirstPlayerSelectScene();
            }
        });

        middleText.getChildren().add(playAgain);

        add(middleText, 1, 0);
        add(computerHand,2,0);

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

                        if (game.getRound() > 3 && firstPlayer.getScore() == 2) {
                            game.resetRound();

                            firstPlayer.incrementStreak();
                            firstPlayer.incrementWonGames();
                            firstPlayer.resetScore();

                            secondPlayer.resetScore();
                            secondPlayer.resetStreak();
                        } else if (game.getRound() > 3 && firstPlayer.getScore() != 2) {
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
