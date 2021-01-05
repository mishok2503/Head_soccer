import java.awt.*;

public class Field {

    private final Point ballStartPos = new Point(400, 400);
    private final Rectangle grassRect = new Rectangle(0, 920, 1200, 50);
    private final Rectangle leftBorderRect = new Rectangle(0, 0, 50, 1000);
    private final Rectangle rightBorderRect = new Rectangle(1135, 0, 50, 1000);

    public Rectangle[] getAllColliders() {
        return new Rectangle[]{leftBorderRect, rightBorderRect, grassRect};
    }

    public Point getBallStartPos() {
        return ballStartPos;
    }
}
