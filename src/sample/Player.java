package sample;

public class Player {
    /*
    Holds stats of player
     */
    private Response response;
    private int score = 0;
    private int streak = 0;
    private int highestStreak = 0;
    private int wonGames = 0;

    private int playedRock = 0;
    private int playedPaper = 0;
    private int playedScissors = 0;

    public Response getResponse() { return response; }
    public int getScore() { return score; }
    public int getStreak() { return streak; }
    public int getHighestStreak() { return highestStreak; }
    public int getWonGames() { return wonGames; }
    public int getPlayedRock() { return playedRock; }
    public int getPlayedPaper() { return playedPaper; }
    public int getPlayedScissors() { return playedScissors; }

    public Player() {

    }

    public void setResponseType(ResponseType responseType) {
        this.response = new Response(responseType);
        incrementResponseType(responseType);
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

    private void incrementResponseType(ResponseType responseType) {
        if (responseType == ResponseType.ROCK) {
            this.playedRock++;
        } else if (responseType == ResponseType.PAPER) {
            this.playedPaper++;
        } else {
            this.playedScissors++;
        }
    }

}
