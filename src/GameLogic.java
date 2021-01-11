import java.awt.*;
import java.util.Arrays;
import java.util.stream.Stream;

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

    public Rectangle[] getBorderRects() {
        return field.getAllRectColliders();
    }

    public Rectangle[] getPlayerRects() {
        return new Rectangle[]{players[0].getRect(), players[1].getRect()};
    }

    public void update() {
        for (Rectangle rect : getBorderRects())
            ball.CollisionProcessing(rect);
        for (Rectangle rect : getPlayerRects())
            ball.CollisionProcessing(rect);
        for (Player player : players) {
            for (Rectangle rect : getBorderRects())
                player.CollisionProcessing(rect);
            for (Player otherPlayer : players)
                if (otherPlayer != player)
                    player.CollisionProcessing(otherPlayer.getRect());
            player.move(g);
        }
        ball.move(g);
    }

}
