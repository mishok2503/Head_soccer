import java.awt.*;

public class Player {

    private Vector pos, prevPos;
    private Vector speed = new Vector(0, 0);
    private final Point size;
    private final boolean isLeft;

    public Player(Field field, Point size, boolean isLeft) {
        this.isLeft = isLeft;
        this.size = size;
        prevPos = pos = new Vector(field.getPlayerStartPos(this.isLeft));
    }

    public Rectangle getRect() {
        return new Rectangle((int) pos.x, (int) pos.y, size.x, size.y);
    }

    public void CollisionProcessing(Rectangle rect) {
        Vector n = Physics.CheckCollision(getRect(), rect);
        if (!n.is_zeros()) {
            if (n.y != 0) {
                speed.y = 0;
                pos.y = prevPos.y;
            } else {
                speed.x = 0;
                pos.x = prevPos.x;
            }
        }
    }

    public void move(double g) {
        prevPos = new Vector(pos);
        speed.y += g;
        pos.add(speed);
        double airLoss = 0.004;
        speed.mul(1 - airLoss);
    }

}
