package sample;

import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class SelectResponseScene extends GridPane {

    public SelectResponseScene() {
        Rectangle rock = new Rectangle(200, 200, Color.RED);
        add(rock, 0, 0);

        Rectangle paper = new Rectangle(200,200, Color.BLUE);
        add(paper, 1, 0);

        Rectangle scissor = new Rectangle(200,200, Color.GOLD);
        add(scissor, 2,0);


    }
}
