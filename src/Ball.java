import java.awt.*;

public class Ball {

    private Point pos;
    private final int radius;
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

}
