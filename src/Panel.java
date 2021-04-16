import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Panel extends JPanel implements ActionListener {

    private final GameLogic gameLogic;
    private int counts = 0;
    private long lt;
    private boolean isMenu = true;

    private final Image rightGoal = new ImageIcon("res/right_goal.png").getImage();
    private final Image leftGoal = new ImageIcon("res/left_goal.png").getImage();
    private final Image ballImage = new ImageIcon("res/ball.png").getImage();
    private final Image grass = new ImageIcon("res/grass.png").getImage();
    private final Image leftHead = new ImageIcon("res/left_head.png").getImage();
    private final Image rightHead = new ImageIcon("res/right_head.png").getImage();
    private final Image leftBody = new ImageIcon("res/left_body.png").getImage();
    private final Image rightBody = new ImageIcon("res/right_body.png").getImage();
    private final Image border = new ImageIcon("res/border.jpeg").getImage();
    private final Image menuBg = new ImageIcon("res/menubg.jpg").getImage();
    private final Image bg = new ImageIcon("res/bg.png").getImage();

    private final JButton resB, exitB;

    public Panel(GameLogic gameLogic, int fps) {
        this.gameLogic = gameLogic;
        addKeyListener(new KeyListener(gameLogic));
        setFocusable(true);
        setLayout(null);
        resB = new JButton("Play");
        resB.setBounds(400, 300, 400, 150);
        resB.setFocusable(false);
        resB.setActionCommand("Restart");
        resB.setFont(new Font(null, Font.BOLD, 40));
        resB.addActionListener(this);
        add(resB);
        exitB = new JButton("Exit");
        exitB.setBounds(400, 500, 400, 150);
        exitB.setFocusable(false);
        exitB.setFont(new Font(null, Font.BOLD, 40));
        exitB.setActionCommand("Exit");
        exitB.addActionListener(this);
        add(exitB);
        Timer timer = new Timer(1000 / (fps * gameLogic.getCountsPerFrame()), this);
        timer.start();
        lt = System.nanoTime();
    }

    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);

        this.setBackground(Color.BLACK);

        Graphics2D g = (Graphics2D) graphics;

        if (isMenu)
        {
            g.drawImage(menuBg, 0, 0, null);
            return;
        }

        g.setFont(new Font(null, Font.BOLD, 100));

        drawField(g);
        drawPlayer(g);
        drawBall(g);

        g.drawImage(rightGoal, 1140, 500, null);
        g.drawImage(leftGoal, -185, 500, null);

        g.setColor(Color.black);
        Point score = gameLogic.getScore();
        g.drawString(score.x + ":" + score.y, 520 - (score.x > 9 ? 60 : 0), 200);
    }

    private void drawBall(Graphics2D g) {
        g.setColor(Color.CYAN);
        Point ballPos = gameLogic.getBallPos();
        int delta = (int) Physics.eps;
        g.drawImage(ballImage, ballPos.x - 2 * delta, ballPos.y - 2 * delta, null);
    }

    private void drawPlayer(Graphics2D g) {
        Rectangle lBody = gameLogic.getPlayerRects()[0], rBody = gameLogic.getPlayerRects()[1];
        Rectangle lHead = gameLogic.getPlayerCircles()[0], rHead = gameLogic.getPlayerCircles()[1];
        g.drawImage(leftBody, lBody.x, lBody.y, null);
        g.drawImage(rightBody, rBody.x, rBody.y, null);
        g.drawImage(leftHead, lHead.x, lHead.y, null);
        g.drawImage(rightHead, rHead.x, rHead.y, null);
    }

    private void drawField(Graphics2D g) {
        g.drawImage(bg, 0, 0, null);
        for (int i=0; i < 24; ++i)
            g.drawImage(border, i * 50, 0, null);
        for (int i=1; i < 10; ++i)
            g.drawImage(border, 0, i * 50, null);
        for (int i=1; i < 10; ++i)
            g.drawImage(border, 1150, i * 50, null);
        for (int i=0; i < 8; ++i)
            g.drawImage(grass, i * 150, 830, null);
        g.drawImage(border, 0, 0, null);
    }

    private boolean isMassege = true;

    @Override
    public void actionPerformed(ActionEvent e) {
        long ct = System.nanoTime();
        if (gameLogic.isRun())
            gameLogic.update((ct - lt) / 1e7);
        else {
            repaint();
            if (!isMassege) {
                JOptionPane.showMessageDialog(this.getComponent(0), (gameLogic.isWinR() ? "Right" : "Left") + " player win!");
                isMassege = true;
            }
            resB.setVisible(true);
            exitB.setVisible(true);
        }
        lt = ct;
        counts++;
        if ("Restart".equals(e.getActionCommand())) {
            gameLogic.restart();
            isMenu = false;
            resB.setText("Restart");
            resB.setVisible(false);
            exitB.setVisible(false);
            isMassege = false;
        }

        if ("Exit".equals(e.getActionCommand()))
            System.exit(0);
        if (counts == gameLogic.getCountsPerFrame()) {
            counts = 0;
            repaint();
        }
    }
}