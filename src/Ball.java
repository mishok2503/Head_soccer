import java.awt.*;

public class Ball {

    private Point pos;
    private final int radius;
    private final double loss = 0.3;
    private double speedX = 0;
    private double speedY = 0;

    public Ball(Field field, int radius) {
        pos = field.getBallStartPos();
        this.radius = radius;
    }

    public int getRadius() {
        return radius;
    }

    public Point getPos() {
        return pos;
    }

    public void move(double g) {
        speedY += g;
        pos.y += speedY;
        pos.x += speedX;
    }

    public void CollisionProcessing(Rectangle rect) {
        //TODO
        Rectangle tmp = new Rectangle(pos.x, pos.y, radius, radius);
        if (tmp.intersects(rect)) {
            speedY *= -(1 - loss);
        }
    }

}
