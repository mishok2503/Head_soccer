import java.awt.*;
import java.util.Arrays;
import java.util.stream.Stream;

public class GameLogic {

    private final Ball ball;
    private final Player[] players;
    private final Field field;
    private final int countsPerFrame;

    public GameLogic(Ball ball, Player[] players, Field field, int countsPerFrame) {
        this.ball = ball;
        this.players = players;
        this.field = field;
        this.countsPerFrame = countsPerFrame;
    }

    public void ballReset()
    {
        ball.setPos(field.getBallStartPos());
        ball.setSpeed(new Vector(0, 0));
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

    public Rectangle[] getPlayerCircles() {
        return new Rectangle[] { players[0].getCircle(), players[1].getCircle() };
    }


    public void update(double dt) {
        boolean ballBetween = ball.betweenPlayers(players[0].getRect(), players[1].getRect());
        for (Rectangle rect : getBorderRects())
            ball.CollisionProcessing(rect, new Vector(0, 0), false);
        for (Player player : players) {
            player.CollisionProcessing(new Rectangle(50, 50, 1100, 925)); //TODO: magic numbers
            if (ballBetween || (players[0].getRect().x + players[0].getRect().width >= players[1].getRect().x))
                player.setMoveBlock(player == players[0] ? 1 : -1);
            else
                player.setMoveBlock(0);
            boolean isOnBall = player.onBall(ball.getRect());
            player.move(dt);
            ball.CollisionProcessing(player.getRect(), player.getSpeed(), false);
            ball.CollisionProcessing(player.getCircle(), player.getSpeed(), true);
            if (isOnBall)
                ball.setSpeed(new Vector(0, 0));
        }

        ball.move(dt);
    }

    public void movePlayer(int player, double a, boolean jump) {
        if (!jump)
            players[player].setXSpeed(a);
        else
            players[player].jump();
    }

    public int getCountsPerFrame() {
        return countsPerFrame;
    }
}
