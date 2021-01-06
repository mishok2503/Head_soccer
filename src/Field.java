import java.awt.*;

public class Field {

    private final Point ballStartPos = new Point(600, 500);
    private final Rectangle grassRect = new Rectangle(0, 920, 1200, 50);
    private final Rectangle leftBorderRect = new Rectangle(0, 0, 50, 1000);
    private final Rectangle rightBorderRect = new Rectangle(1135, 0, 50, 1000);
    private final Rectangle tmp = new Rectangle(630, 800, 100, 100);
    private final Rectangle tmp1 = new Rectangle(330, 800, 100, 100);

    public Rectangle[] getAllColliders() {
        return new Rectangle[]{leftBorderRect, rightBorderRect, grassRect, tmp1, tmp};
    }

    public Point getBallStartPos() {
        return ballStartPos;
    }
}
