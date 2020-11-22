package sample;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class IntroScene extends VBox {
    private HBox hBox = new HBox();
    private ImageView titleImage = new ImageView();

    public IntroScene() {

        setAlignment(Pos.CENTER);
        hBox.setAlignment(Pos.CENTER);

        titleImage.setImage(new Image("images/covid.png"));
        getChildren().add(titleImage);

        Button playAI = new Button("Play Computer");
        Button playPerson = new Button("Play IRL");
        //Button scoreboard = new Button("Scoreboard");

        playAI.setOnAction(e -> {
            SceneLibrary.switchToResponse();
        });

        playPerson.setOnAction(e -> {
            SceneLibrary.switchToFirstPlayerSelectScene();
        });

        hBox.getChildren().addAll(playAI, playPerson);
        getChildren().add(hBox);

    }

}
