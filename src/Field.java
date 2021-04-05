import java.awt.*;

public class Field {

    private final Point ballStartPos = new Point(600, 600);
    private final Point leftPlayerStartPos = new Point(150, 700);
    private final Point rightPlayerStartPos = new Point(1000, 700);

    private final Rectangle bottomBorderRect = new Rectangle(0, 900, 1200, 100);
    private final Rectangle leftBorderRect = new Rectangle(0, 0, 50, 1000);
    private final Rectangle rightBorderRect = new Rectangle(1150, 0, 100, 1000);
    private final Rectangle topBorderRect = new Rectangle(0, 0, 1200, 50);

    public Rectangle[] getAllRectColliders() {
        return new Rectangle[]{leftBorderRect, rightBorderRect, bottomBorderRect, topBorderRect};
    }

    public Point getBallStartPos() {
        return ballStartPos;
    }

    public Point getPlayerStartPos(boolean isLeft) {
        if (isLeft)
            return leftPlayerStartPos;
        return rightPlayerStartPos;
    }
}
