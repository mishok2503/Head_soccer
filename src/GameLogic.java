import java.awt.*;

public class GameLogic {

    private final Ball ball;
    private final Player[] players;

    public GameLogic(Ball ball, Player[] players) {
        this.ball = ball;
        this.players = players;
    }

    public Point getBallPos() {
        return ball.getPos();
    }

    public int getBallRadius() {
        return ball.getRadius();
    }

    public void update() {
        ball.move();
    }

}
