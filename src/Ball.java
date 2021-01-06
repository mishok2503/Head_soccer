import java.awt.*;

public class Ball {

    private Physics.Vector pos, prevPos;
    private final int radius;
    private final double loss = 0.2;
    private double speedX = 1;
    private double speedY = 0;

    public Ball(Field field, int radius) {
        Point p = field.getBallStartPos();//TODO
        prevPos = pos = new Physics.Vector(p.x, p.y);
        this.radius = radius;
    }

    public int getRadius() {
        return radius;
    }

    public Point getPos() {
        return new Point((int) Math.round(pos.x), (int) Math.round(pos.y));
    }//TODO

    public void move(double g) {
        prevPos = new Physics.Vector(pos.x, pos.y);//TODO
        speedY += g;
        pos.y += speedY;
        pos.x += speedX;
    }

    public void CollisionProcessing(Rectangle rect) {
        Physics.Vector n = Physics.CheckCollision(new Point((int) Math.round(pos.x), (int) Math.round(pos.y)), radius, rect);//TODO
        if (!n.is_zeros()) {
            double beta = Math.atan(n.y / n.x);
            if (n.x < 0)
                beta += Math.PI;
            pos = new Physics.Vector(prevPos.x, prevPos.y);
            speedX *= (1 - loss);//TODO
            speedY *= -(1 - loss);
        }
    }
}
