package sample;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class SecondPlayerSelectScene extends VBox {
    public SecondPlayerSelectScene(Player secondPlayer) {

        setAlignment(Pos.CENTER);

        Image rockPaperScissors = new Image("images/CureAntiVaxCovid.png");

        ImageView playerTwoImage = new ImageView();
        playerTwoImage.setImage(new Image("images/playerTwo.png"));
        getChildren().add(playerTwoImage);

        ImageView titleImageView = new ImageView();
        titleImageView.setImage(rockPaperScissors);
        getChildren().add(titleImageView);

        Text instructions = new Text("Select an option below. ");
        instructions.setFont(Font.font("Bauhaus 93",50));
        instructions.setFill(Color.WHITE);

        getChildren().add(instructions);

        HBox hBox = new HBox();

        hBox.setAlignment(Pos.CENTER);

        ImageView paperImageView = new ImageView();
        paperImageView.setImage(new Response(ResponseType.PAPER).getResponseImage());
        hBox.getChildren().add(paperImageView);

        ImageView scissorImageView = new ImageView();
        scissorImageView.setImage(new Response(ResponseType.SCISSOR).getResponseImage());
        hBox.getChildren().add(scissorImageView);

        ImageView rockImageView = new ImageView();
        rockImageView.setImage(new Response(ResponseType.ROCK).getResponseImage());
        hBox.getChildren().add(rockImageView);

        getChildren().add(hBox);

        EventHandler<MouseEvent> chooseRock = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                secondPlayer.setResponseType(ResponseType.ROCK);
                SceneLibrary.switchToPlayerPlay();
            }
        };

        EventHandler<MouseEvent> choosePaper = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                secondPlayer.setResponseType(ResponseType.PAPER);
                SceneLibrary.switchToPlayerPlay();
            }
        };

        EventHandler<MouseEvent> chooseScissors = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                secondPlayer.setResponseType(ResponseType.SCISSOR);
                SceneLibrary.switchToPlayerPlay();
            }
        };

        rockImageView.addEventFilter(MouseEvent.MOUSE_CLICKED, chooseRock);
        paperImageView.addEventFilter(MouseEvent.MOUSE_CLICKED, choosePaper);
        scissorImageView.addEventFilter(MouseEvent.MOUSE_CLICKED, chooseScissors);

        setBackground(new Background(new BackgroundFill(Color.BLACK,CornerRadii.EMPTY, Insets.EMPTY)));


    }
}
