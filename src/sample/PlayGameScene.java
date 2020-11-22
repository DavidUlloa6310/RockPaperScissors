package sample;

import javafx.animation.AnimationTimer;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.Random;

public class PlayGameScene extends GridPane {

    private Response computerGuess;
    private ImageView playerHand = new ImageView();
    private ImageView computerHand = new ImageView();
    private int counter = 0;
    private VBox middleText = new VBox();
    private ImageView winConditionText = new ImageView();

    public PlayGameScene(Response playerResponse) {

        Random random = new Random();
        int randomInt = random.nextInt(3);

        if (randomInt == 0) {
            computerGuess = new Response(ResponseType.ROCK);
        } else if (randomInt == 1) {
            computerGuess = new Response(ResponseType.PAPER);
        } else {
            computerGuess = new Response(ResponseType.SCISSOR);
        }

        playerHand.setImage(playerResponse.getStillImage());
        computerHand.setImage(computerGuess.getStillImage());

        add(playerHand,0,0);
        winConditionText.setImage(new Image("images/ready.png"));
        middleText.getChildren().add(winConditionText);
        add(middleText, 1, 0);
        add(computerHand,2,0);

        AnimationTimer animationTimer = new AnimationTimer() {

            long lastUpdate = 0;

            @Override
            public void handle(long now) {
                if (now - lastUpdate >= 300000000) {
                    lastUpdate = now;

                    if (counter > 8) {
                        if (isWin(playerResponse.getResponseType(), computerGuess.getResponseType()) == EndCondition.DRAW) {
                            winConditionText.setImage(new Image("images/tie.png"));
                        } else if (isWin(playerResponse.getResponseType(), computerGuess.getResponseType()) == EndCondition.WIN) {
                            winConditionText.setImage(new Image("images/won.png"));
                        } else {
                            winConditionText.setImage(new Image("images/lost.png"));
                        }
                        this.stop();
                    }

                    switch (counter) {
                        case 1: case 3: case 5: case 7:
                            playerHand.setImage(playerResponse.getTiltedImage());
                            computerHand.setImage(computerGuess.getTiltedImage());
                            break;
                        case 0:
                            playerHand.setImage(playerResponse.getStillImage());
                            computerHand.setImage(computerGuess.getStillImage());
                            break;
                        case 2:
                            playerHand.setImage(playerResponse.getStillImage());
                            computerHand.setImage(computerGuess.getStillImage());
                            winConditionText.setImage(new Image("images/rockWord.png"));
                            break;
                        case 4:
                            playerHand.setImage(playerResponse.getStillImage());
                            computerHand.setImage(computerGuess.getStillImage());
                            winConditionText.setImage(new Image("images/paperWord.png"));
                            break;
                        case 6:
                            playerHand.setImage(playerResponse.getStillImage());
                            computerHand.setImage(computerGuess.getStillImage());
                            winConditionText.setImage(new Image("images/scissorWord.png"));
                            break;
                        case 8:
                            playerHand.setImage(playerResponse.getResponseImage());
                            computerHand.setImage(computerGuess.getResponseImage());
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
