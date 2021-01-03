public class Game {

    private final GameLogic gameLogic = new GameLogic();

    public void run() {
        Frame frame = new Frame(gameLogic, 1200, 1000, 60);
    }
}
