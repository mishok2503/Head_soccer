import java.awt.*;

public class Ball {

    private Point pos;
    private final int radius;

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

    public void move() {

    }

}
