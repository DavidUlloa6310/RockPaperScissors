package sample;

public class Game {
    private int round = 1;

    public Game() {}

    public int getRound() {
        return round;
    }

    public void incrementRound() {
        this.round++;
    }

    public void resetRound() {
        this.round = 1;
    }

}
