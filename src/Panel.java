import javax.swing.*;
import java.awt.event.*;

public class Panel extends JPanel implements ActionListener {

    private static final int timerDelay = 16;

    public Panel() {
        Timer timer = new Timer(timerDelay, this);
        timer.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}