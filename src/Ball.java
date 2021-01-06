import java.awt.*;

public class Ball {

    private Vector pos, prevPos;
    private final int radius;
    private final double loss = 0.2;
    private double speedX = 1;
    private double speedY = 0;

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
        speedY += g;
        pos.y += speedY;
        pos.x += speedX;
    }

    public void CollisionProcessing(Rectangle rect) {
        Vector n = Physics.CheckCollision(pos.getPoint(), radius, rect);
        if (!n.is_zeros()) {
            double beta = n.getAngle();
            pos = new Vector(prevPos);

            speedX *= (1 - loss);//TODO
            speedY *= -(1 - loss);
        }
    }
}
