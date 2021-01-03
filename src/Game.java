public class Game {

    private final Field field = new Field();
    private final Ball ball = new Ball(field, 80);
    private final Player[] players = {new Player(field), new Player(field)};

    private final GameLogic gameLogic = new GameLogic(ball, players);

    public void run() {
        Frame frame = new Frame(gameLogic, 1200, 1000, 60);
    }
}
