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

        if (key == KeyEvent.VK_A)
            gameLogic.movePlayer(0, new Vector(-0.03, 0));//TODO: add acceleration varible
        if (key == KeyEvent.VK_D)
            gameLogic.movePlayer(0, new Vector(0.03, 0));
        if (key == KeyEvent.VK_LEFT)
            gameLogic.movePlayer(1, new Vector(-0.03, 0));
        if (key == KeyEvent.VK_RIGHT)
            gameLogic.movePlayer(1, new Vector(0.03, 0));
    }

    @Override
    public void keyReleased(KeyEvent e) {
        super.keyReleased(e);

        int key = e.getKeyCode();


    }
}