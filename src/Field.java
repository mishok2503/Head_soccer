import java.awt.*;

public class Field {

    private final Point ballStartPos = new Point(400, 400);
    private final Rectangle grassRect = new Rectangle(0, 900, 1200, 100);
    private final Rectangle leftBorderRect = new Rectangle(10, 10, 100, 100);

    public Rectangle[] getAllColliders() {
        return new Rectangle[]{grassRect, leftBorderRect};
    }

    public Point getBallStartPos() {
        return ballStartPos;
    }
}
