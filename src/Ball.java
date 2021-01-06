import java.awt.*;

public class Ball {

    private Vector pos, prevPos;
    private final int radius;
    private final double collisionLoss = 0.05;
    private final double airLoss = 0.005;
    private Vector speed = new Vector(20, -1);

    public Ball(Field field, int radius) {
        prevPos = pos = new Vector(field.getBallStartPos());
        this.radius = radius;
    }

    public int getRadius() {
        return radius;
    }

    public Point getPos() {
        return pos.getPoint();
    }

    public void move(double g) {
        prevPos = new Vector(pos);
        speed.y += g;
        pos.add(speed);
        speed.mul(1 - airLoss);
    }

    public void CollisionProcessing(Rectangle rect) {
        Vector n = Physics.CheckCollision(pos.getPoint(), radius, rect);
        if (!n.is_zeros()) {
            pos = new Vector(prevPos);
            speed.setAngle(Math.PI + 2 * n.getAngle() - speed.getAngle());
            speed.mul(1 - collisionLoss);
        }
    }
}
