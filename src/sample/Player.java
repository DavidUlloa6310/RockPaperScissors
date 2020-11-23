package sample;

public class Player {
    private Response response;
    private int score = 0;
    private int streak = 0;
    private int highestStreak = 0;
    private int wonGames = 0;

    public Response getResponse() { return response; }
    public int getScore() { return score; }
    public int getStreak() { return streak; }
    public int getHighestStreak() { return highestStreak; }

    public Player() {

    }

    public void setResponseType(ResponseType responseType) {
        this.response = new Response(responseType);
    }

    public void incrementScore() {
        this.score++;
    }

    public void incrementStreak() {
        this.streak++;
        if (this.streak > highestStreak) {
            this.highestStreak = streak;
        }
    }

    public void incrementWonGames() {
        this.wonGames++;
    }

    public void resetStreak() {
        this.streak = 0;
    }

    public void resetScore() {
        this.score = 0;
    }

}
