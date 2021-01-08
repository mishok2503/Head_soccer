import java.awt.*;

public class Field {

    private final Point ballStartPos = new Point(600, 500);
    private final Point leftPlayertartPos = new Point(150, 750);
    private final Point rightPlayertartPos = new Point(1000, 750);

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

    public Point getPlayerStartPos(boolean isLeft) {
        if (isLeft)
            return leftPlayertartPos;
        return rightPlayertartPos;
    }
}
