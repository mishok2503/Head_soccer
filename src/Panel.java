import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Panel extends JPanel implements ActionListener {

    private final GameLogic gameLogic;
    private int counts = 0;
    private long lt;

    private final Image rightGoal = new ImageIcon("res/right_goal.png").getImage();
    private final Image leftGoal = new ImageIcon("res/left_goal.png").getImage();
    private final Image ballImage = new ImageIcon("res/ball.png").getImage();

    public Panel(GameLogic gameLogic, int fps) {
        this.gameLogic = gameLogic;
        addKeyListener(new KeyListener(gameLogic));
        setFocusable(true);
        Timer timer = new Timer(1000 / (fps * gameLogic.getCountsPerFrame()), this);
        timer.start();
        lt = System.nanoTime();
    }

    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);

        this.setBackground(Color.BLACK);

        Graphics2D g = (Graphics2D) graphics;

        g.setFont(new Font(null, Font.BOLD, 100));

        drawField(g);
        drawPlayer(g);
        drawBall(g);

        g.drawImage(rightGoal, 1140, 500, null);
        g.drawImage(leftGoal, -185, 500, null);

        g.setColor(Color.white);
        Point score = gameLogic.getScore();
        g.drawString(String.valueOf(score.x) + ":" + String.valueOf(score.y), 520 - (score.x > 9 ? 60 : 0), 200);
    }

    private void drawBall(Graphics2D g) {
        g.setColor(Color.CYAN);
        Point ballPos = gameLogic.getBallPos();
        int delta = (int) Physics.eps;
        g.drawImage(ballImage, ballPos.x - 2 * delta, ballPos.y - 2 * delta, null);
    }

    private void drawPlayer(Graphics2D g) {
        g.setColor(Color.RED);
        for (Rectangle rect : gameLogic.getPlayerRects())
            g.fillRect(rect.x, rect.y, rect.width, rect.height + 4);//TODO: remove constants
        for (Rectangle rect : gameLogic.getPlayerCircles())
            g.fillOval(rect.x, rect.y, rect.width , rect.height);
    }

    private void drawField(Graphics2D g) {
        g.setColor(Color.GREEN);
        for (Rectangle rect : gameLogic.getBorderRects())
            g.fillRect(rect.x, rect.y, rect.width, rect.height);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        long ct = System.nanoTime();
        gameLogic.update((ct - lt) / 1e7);
        lt = ct;
        counts++;
        if (counts == gameLogic.getCountsPerFrame()) {
            counts = 0;
            repaint();
        }
    }
}