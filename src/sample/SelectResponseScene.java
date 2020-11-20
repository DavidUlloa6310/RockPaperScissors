package sample;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class SelectResponseScene extends GridPane {

    public SelectResponseScene() {
        Image rockPaperScissors = new Image("images/RockPaperScissors.png");

        ImageView titleImageView = new ImageView();
        titleImageView.setImage(rockPaperScissors);
        add(titleImageView,0,0);

        HBox hBox = new HBox();

        ImageView rockImageView = new ImageView();
        rockImageView.setImage(new Response(ResponseType.ROCK).getResponseImage());
        hBox.getChildren().add(rockImageView);

        ImageView paperImageView = new ImageView();
        paperImageView.setImage(new Response(ResponseType.PAPER).getResponseImage());
        hBox.getChildren().add(paperImageView);

        ImageView scissorImageView = new ImageView();
        scissorImageView.setImage(new Response(ResponseType.SCISSOR).getResponseImage());
        hBox.getChildren().add(scissorImageView);

        add(hBox, 0,1);

        EventHandler<MouseEvent> chooseRock = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                System.out.println("SWITCHED");
                SceneLibrary.switchToPlay(new Response(ResponseType.ROCK));
            }
        };

        EventHandler<MouseEvent> choosePaper = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                SceneLibrary.switchToPlay(new Response(ResponseType.PAPER));
            }
        };

        EventHandler<MouseEvent> chooseScissors = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                SceneLibrary.switchToPlay(new Response(ResponseType.SCISSOR));
            }
        };

        rockImageView.addEventFilter(MouseEvent.MOUSE_CLICKED, chooseRock);
        paperImageView.addEventFilter(MouseEvent.MOUSE_CLICKED, choosePaper);
        scissorImageView.addEventFilter(MouseEvent.MOUSE_CLICKED, chooseScissors);


    }
}
