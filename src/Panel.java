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

        gameLogic.update();

        drawField(g);
        drawBall(g);
    }

    private void drawBall(Graphics2D g) {
        g.setColor(Color.CYAN);
        Point ballPos = gameLogic.getBallPos();
        int delta = (int) Physics.eps;
        int r = gameLogic.getBallRadius() + 2 * delta;
        g.fillOval(ballPos.x - delta, ballPos.y - delta, r, r);
    }

    private void drawField(Graphics2D g) {
        g.setColor(Color.GREEN);
        for (Rectangle rect : gameLogic.getAllRectColliders())
            g.fillRect(rect.x, rect.y, rect.width, rect.height);
        g.setColor(Color.RED);
        g.fillOval(500, 800, 100, 100);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }
}