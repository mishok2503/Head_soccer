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
        int r = gameLogic.getBallRadius();
        g.fillOval(ballPos.x, ballPos.y, r, r);
    }

    private void drawField(Graphics2D g) {
        g.setColor(Color.GREEN);
        Rectangle panelSize = g.getClip().getBounds();
        Rectangle grass = gameLogic.getGrassRect();
        System.out.println(grass.height);
        g.fillRect(0, panelSize.height - grass.height, panelSize.width, grass.height);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }
}