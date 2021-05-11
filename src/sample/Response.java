package sample;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Response {
    /*
    Represents a response from the player: rock paper or scissor.
     */
    private ResponseType responseType;

    private int score = 0;
    private int round = 1;
    private int streak = 0;
    private int wonGames = 0;

    private ImageView imageView;
    private Image responseImage;
    private Image tiltedImage;
    private Image stillImage;

    public Response(ResponseType responseType) {
        this.responseType = responseType;

        switch (responseType) {
            case PAPER:
                responseImage = new Image("images/paper.png");
                break;
            case ROCK:
                responseImage = new Image("images/rock.png");
                break;
            case SCISSOR:
                responseImage = new Image("images/scissors.png");
                break;
        }

        stillImage = new Image("images/fist.png");
        tiltedImage = new Image("images/tiltedFist.png");

    }

    public Image getResponseImage() {
        return responseImage;
    }

    public ResponseType getResponseType() {
        return responseType;
    }

    public ImageView getImageView() {
        return imageView;
    }

    public Image getTiltedImage() {
        return tiltedImage;
    }

    public Image getStillImage() {
        return stillImage;
    }
}
