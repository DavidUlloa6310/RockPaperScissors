package sample;

import javafx.animation.AnimationTimer;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

public class PlayGameScene extends GridPane {

    private Response computerGuess;
    private ImageView playerHand;
    private ImageView computerHand;

    public PlayGameScene(Response playerResponse) {
        double guess = Math.random();
        if (guess < .33) {
            Response computerGuess = new Response(ResponseType.ROCK);
        } else if (guess < .66) {
            Response computerGuess = new Response(ResponseType.PAPER);
        } else {
            Response computerGuess = new Response(ResponseType.SCISSOR);
        }

        new AnimationTimer() {

            long lastUpdate = 0;

            @Override
            public void handle(long now) {
                if (now - lastUpdate >= 1000000000) {
                    System.out.println("This is a test");
                    lastUpdate = now;
                }
            }
        }.start();

    }
}
