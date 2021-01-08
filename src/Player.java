import java.awt.*;

public class Player {

    private Point pos;
    private final Point size;
    private final boolean isLeft;

    public Player(Field field, Point size, boolean isLeft) {
        this.isLeft = isLeft;
        this.size = size;
        pos = field.getPlayerStartPos(isLeft);
    }

    public Rectangle getRect() {
        return new Rectangle(pos.x, pos.y, size.x, size.y);
    }

}
