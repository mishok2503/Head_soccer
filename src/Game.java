import java.awt.*;

public class Game {

    private final Field field = new Field();
    private final Ball ball = new Ball(field, 40);
    private final Player[] players = {new Player(field, new Point(80, 120), true), new Player(field, new Point(80, 120), false)};

    private final GameLogic gameLogic = new GameLogic(ball, players, field, 0.2);

    public void run() {
        Frame frame = new Frame(gameLogic, 1200, 1000, 60);
    }
}
