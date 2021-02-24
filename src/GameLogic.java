import java.awt.*;
import java.util.Arrays;
import java.util.stream.Stream;

import static java.lang.Math.max;

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

    public Rectangle[] getPlayerCircles() {
        return Stream.concat(Arrays.stream(players[0].getCircles()), Arrays.stream(players[1].getCircles())).toArray(Rectangle[]::new);
    }


    public void update() {
        for (Rectangle rect : getBorderRects())
            ball.CollisionProcessing(rect, false);
        for (Rectangle rect : getPlayerRects())
            ball.CollisionProcessing(rect, false);
        for (Player player : players) {
            for (Rectangle rect : getBorderRects())
                player.CollisionProcessing(rect);
            for (Player otherPlayer : players)
                if (otherPlayer != player)
                    player.CollisionProcessing(otherPlayer.getRect());
            if (players[0].getRect().x + players[0].getRect().width >= players[1].getRect().x)
                player.setMoveBlock(player == players[0] ? 1 : -1);
            else
                player.setMoveBlock(0);
            player.move(g);
        }
        ball.temp = players[0].getSpeed();
        for (Rectangle rect : getPlayerCircles())
            ball.CollisionProcessing(rect, true);
        ball.temp = new Vector(0, 0);
        ball.move(g);
    }

    public void movePlayer(int player, double a, boolean jump) {
        if (!jump)
            players[player].setXSpeed(a);
        else
            players[player].jump();
    }

}
