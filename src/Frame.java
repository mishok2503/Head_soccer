import javax.swing.*;

public class Frame extends JFrame {

    public Frame(GameLogic gameLogic, int width, int height, int fps) {
        this.setSize(width, height);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(new Panel(gameLogic, fps));
        this.setVisible(true);
    }
}