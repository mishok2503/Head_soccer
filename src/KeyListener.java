import java.awt.event.*;

public class KeyListener extends KeyAdapter {

    private final GameLogic gameLogic;

    public KeyListener(GameLogic gameLogic) {
        this.gameLogic = gameLogic;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        super.keyPressed(e);

        int key = e.getKeyCode();

        int speedX = 3;
        if (key == KeyEvent.VK_A)
            gameLogic.movePlayer(0, -speedX, false);//TODO: remove constants
        if (key == KeyEvent.VK_D)
            gameLogic.movePlayer(0, speedX, false);
        if (key == KeyEvent.VK_W)
            gameLogic.movePlayer(0, 0, true);
        if (key == KeyEvent.VK_LEFT)
            gameLogic.movePlayer(1, -speedX, false);
        if (key == KeyEvent.VK_RIGHT)
            gameLogic.movePlayer(1, speedX, false);
        if (key == KeyEvent.VK_UP)
            gameLogic.movePlayer(1, 0, true);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        super.keyReleased(e);

        int key = e.getKeyCode();

        if (key == KeyEvent.VK_A || key == KeyEvent.VK_D)//TODO: two buttons press
            gameLogic.movePlayer(0, 0, false);
        if (key == KeyEvent.VK_RIGHT || key == KeyEvent.VK_LEFT)
            gameLogic.movePlayer(1, 0, false);
    }
}