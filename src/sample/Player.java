package sample;

public class Player {
    private Response response;
    private int score = 0;
    private int streak = 0;
    private int wonGames = 0;

    public Player() {

    }
    public void setResponseType(ResponseType responseType) {
        this.response = new Response(responseType);
    }

    public Response getResponse() {
        return response;
    }

    public int getScore() {
        return score;
    }

    public int getStreak() {
        return streak;
    }

    public void incrementScore() {
        this.score++;
    }

    public void incrementStreak() {
        this.streak++;
    }

    public void resetStreak() {
        this.streak = 0;
    }

    public void incrementWonGames() {
        this.wonGames++;
    }

    public void resetScore() {
        this.score = 0;
    }

}
