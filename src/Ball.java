import java.awt.*;

public class Ball {

    private Point pos, prevPos;
    private final int radius;
    private final double loss = 0.3;
    private double speedX = 2;
    private double speedY = 0;

    public Ball(Field field, int radius) {
        prevPos = pos = field.getBallStartPos();
        this.radius = radius;
    }

    public int getRadius() {
        return radius;
    }

    public Point getPos() {
        return pos;
    }

    public void move(double g) {
        prevPos = new Point(pos);
        speedY += g;
        pos.y += speedY;
        pos.x += speedX;
    }

    public void CollisionProcessing(Rectangle rect) {
        //TODO
    }
}
