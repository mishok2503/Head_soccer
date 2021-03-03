import java.awt.*;

public class Game {

    private final Field field = new Field();
    private final int countsPerFrame = 30;
    private final Ball ball = new Ball(field, 60, countsPerFrame);
    private final Player[] players = {new Player(field, new Point(80, 120), true, countsPerFrame), new Player(field, new Point(80, 120), false, countsPerFrame)};

    private final GameLogic gameLogic = new GameLogic(ball, players, field, 0.2, countsPerFrame);

    public void run() {
        Frame frame = new Frame(gameLogic, 1200, 1000, 60);
    }
}
