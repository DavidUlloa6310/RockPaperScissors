package sample;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

public class IntroScene extends VBox {
    private HBox hBox = new HBox();
    private ImageView titleImage = new ImageView();

    public IntroScene() {

        setAlignment(Pos.CENTER);
        hBox.setAlignment(Pos.CENTER);

        titleImage.setImage(new Image("images/covid.png"));
        getChildren().add(titleImage);

        Button playAI = new Button("Play Computer");
        playAI.setStyle("-fx-background-color: #44e9ff;");

        Button playPerson = new Button("Play IRL");
        playPerson.setStyle("-fx-background-color: #44e9ff;");

        Button scoreboard = new Button("Scoreboard");
        scoreboard.setStyle("-fx-background-color: #44e9ff;");

        playAI.setOnAction(e -> {
            SceneLibrary.switchToResponse();
        });

        playPerson.setOnAction(e -> {
            SceneLibrary.switchToFirstPlayerSelectScene();
        });

        scoreboard.setOnAction(e -> {
            SceneLibrary.switchToHighScore();
        });

        hBox.setSpacing(25);
        hBox.getChildren().addAll(playAI, playPerson, scoreboard);
        getChildren().add(hBox);

        setBackground(new Background(new BackgroundFill(Color.BLACK,CornerRadii.EMPTY, Insets.EMPTY)));

    }

}
