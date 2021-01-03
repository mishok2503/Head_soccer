import javax.swing.*;

public class Frame extends JFrame {

    public Frame() {
        this.setSize(1200, 1000);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(new Panel());
        this.setVisible(true);
    }
}