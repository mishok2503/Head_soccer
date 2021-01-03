public class Game {

    private final Field field = new Field();
    private final Ball ball = new Ball(field, 80);
    private final Player[] players = {new Player(field), new Player(field)};

    private final GameLogic gameLogic = new GameLogic(ball, players, field, 0.1);

    public void run() {
        Frame frame = new Frame(gameLogic, 1200, 1000, 60);
    }
}
