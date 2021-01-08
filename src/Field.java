import java.awt.*;

public class Field {

    private final Point ballStartPos = new Point(600, 500);
    private final Rectangle bottomBorderRect = new Rectangle(0, 920, 1200, 50);
    private final Rectangle leftBorderRect = new Rectangle(0, 0, 50, 1000);
    private final Rectangle rightBorderRect = new Rectangle(1135, 0, 50, 1000);
    private final Rectangle topBorderRect = new Rectangle(0, 0, 1200, 50);

    public Rectangle[] getAllRectColliders() {
        return new Rectangle[]{leftBorderRect, rightBorderRect, bottomBorderRect, topBorderRect};
    }

    public Point getBallStartPos() {
        return ballStartPos;
    }
}
