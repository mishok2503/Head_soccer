import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Panel extends JPanel implements ActionListener {

    private final GameLogic gameLogic;

    public Panel(GameLogic gameLogic, int fps) {
        this.gameLogic = gameLogic;
        Timer timer = new Timer(1000 / fps, this);
        timer.start();
    }

    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);

        this.setBackground(Color.BLACK);

        Graphics2D g = (Graphics2D) graphics;

        drawBall(g);
    }

    private void drawBall(Graphics2D g) {
        g.setColor(Color.CYAN);
        Point ballPos = gameLogic.getBallPos();
        int r = gameLogic.getBallRadius();
        g.fillOval(ballPos.x, ballPos.y, r, r);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }
}