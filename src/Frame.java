import javax.swing.*;

public class Frame extends JFrame {

    public Frame(int width, int height, int fps) {
        this.setSize(width, height);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(new Panel(fps));
        this.setVisible(true);
    }
}