import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Panel extends JPanel implements ActionListener {

    private static final int timerDelay = 16;

    public Panel() {
        Timer timer = new Timer(timerDelay, this);
        timer.start();
    }

    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);

        this.setBackground(Color.BLACK);

        Graphics2D g = (Graphics2D) graphics;
        Rectangle panelSize = g.getClip().getBounds();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}