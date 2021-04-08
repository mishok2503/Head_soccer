import java.awt.*;

import static java.lang.Math.max;

public class Ball {

    private Vector pos;
    private final int radius;
    private Vector speed = new Vector(0, -3);
    private final double g;

    public Ball(Field field, int radius, double g) {
        this.g = g;
        pos = new Vector(field.getBallStartPos());
        this.radius = radius;
    }

    public int getRadius() {
        return radius;
    }

    public Point getPos() {
        return pos.getPoint();
    }

    public void setPos(Point pos) {
        this.pos = new Vector(pos);
    }

    public void setSpeed(Vector speed) {
        this.speed = speed;
    }

    public Rectangle getRect() {
        return new Rectangle((int)pos.x, (int)pos.y, radius, radius);
    }

    public boolean betweenPlayers(Rectangle player1, Rectangle player2)
    {
        double dist = (player2.x - (player1.x + player1.width) - radius - 6) / 20.0;
        if (dist < 1 && pos.y + radius > player1.y && player1.x + player1.width < pos.x && player2.x > pos.x + radius)
        {
            if (speed.abs() > 0.8)
                speed.mul(max(dist / speed.abs(), 1e-4));
            return dist < 0.1;
        }
        return false;
    }

    public void move(double dt) {
        speed.y += g * dt;
        pos.add(new Vector(speed.x * dt, speed.y * dt));
        if (pos.y > 835) //TODO: magic numbers
        {
            pos.y = 835;
            speed.y *= -0.97;
        }
        if (pos.y < 53) //TODO: magic numbers
        {
            pos.y = 53;
            speed.y *= -0.97;
        }
        if (pos.x < 62 && pos.y + radius + 5 < 500)
        {
            pos.x = 62;
            speed.x *= -0.97;
        }
        if (pos.x > 1200 - 112 && pos.y + radius + 5 < 500)
        {
            pos.x = 1200 - 112;
            speed.x *= -0.97;
        }
        double airLoss = 1e-3 * dt;
        speed.mul(1 - airLoss);
        double maxSpeed = 20;
        if (speed.abs() > maxSpeed)
            speed.mul(maxSpeed / speed.abs());
    }

    public void CollisionProcessing(Rectangle rect, Vector rectSpeed, boolean isCircle) {
        Vector n;
        if (isCircle)
            n = Physics.CheckCollision(pos.getPoint(), radius, new Point(rect.x, rect.y), rect.width);
        else
            n = Physics.CheckCollision(pos.getPoint(), radius, rect);
        if (!n.is_zeros()) {
            speed.setAngle(Math.PI + 2 * n.getAngle() - speed.getAngle());
            n.mul(2 * (n.x * rectSpeed.x + n.y * rectSpeed.y));
            speed.add(n);
//            double collisionLoss = 0.05;
//            speed.mul(1 - collisionLoss);
        }
    }
}
