package sample;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Response {
    private ResponseType responseType;

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

        stillImage = new Image("images/rock.png");
        tiltedImage = new Image("images/tilted.png");

    }

    public Image getResponseImage() {
        return responseImage;
    }
}
