import java.awt.*;

public class GameLogic {

    private final Ball ball;
    private final Player[] players;
    private final Field field;

    private final double g;

    public GameLogic(Ball ball, Player[] players, Field field, double g) {
        this.ball = ball;
        this.players = players;
        this.field = field;
        this.g = g;
    }

    public Point getBallPos() {
        return ball.getPos();
    }

    public int getBallRadius() {
        return ball.getRadius();
    }

    public Rectangle[] getAllRectColliders() {
        return field.getAllRectColliders();
    }

    public void update() {
        for (Rectangle rect : getAllRectColliders())
            ball.CollisionProcessing(rect);
        ball.move(g);
    }

}
