import java.awt.*;

public class Field {

    private final Point ballStartPos = new Point(400, 400);
    private final Rectangle grassRect = new Rectangle(0, 0, 0, 20);

    public Rectangle getGrassRect() {
        return grassRect;
    }

    public Point getBallStartPos() {
        return ballStartPos;
    }
}
