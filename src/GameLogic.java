import java.awt.*;

public class GameLogic {

    private final Ball ball;
    private final Player[] players;
    private final Field field;
    private final int countsPerFrame;
    private boolean wait = true, isRun = false, winR;
    private double waitTime = 150, curWaitTime = 0;
    private int lScore = 0, rScore = 0;

    public GameLogic(Ball ball, Player[] players, Field field, int countsPerFrame) {
        this.ball = ball;
        this.players = players;
        this.field = field;
        this.countsPerFrame = countsPerFrame;
    }

    public void restart()
    {
        ballReset();
        playersReset();
        lScore = rScore = 0;
        wait = isRun = true;
    }

    public void ballReset()
    {
        ball.setPos(field.getBallStartPos());
        ball.setSpeed(new Vector(0, -3));
        wait = true;
        curWaitTime = 0;
    }

    public void playersReset()
    {
        for (Player player : players)
        {
            player.setSpeed(new Vector(0, 0));
            player.setOnFloor(false);
            player.setPos(field.getPlayerStartPos(player == players[0]));
        }
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
            player.CollisionProcessing(new Rectangle(20, 50, 1160, 925)); //TODO: magic numbers
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

        if (wait)
            curWaitTime += dt;
        if (curWaitTime > waitTime)
        {
            wait = false;
            curWaitTime = 0;
        }

        if (!wait)
            ball.move(dt);

        if (ball.getPos().x + ball.getRadius() < 10 || ball.getPos().x > 1190) {
            if (ball.getPos().x > 1190)
                lScore++;
            else
                rScore++;
            if (lScore > 2 || rScore > 2) {
                isRun = false;
                winR = rScore == 3;
            }
            else {
                ballReset();
                playersReset();
            }
        }
    }

    public boolean isRun() {
        return isRun;
    }

    public boolean isWinR() {
        return winR;
    }

    Point getScore() {
        return new Point(lScore, rScore);
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
