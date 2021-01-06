import java.awt.*;

public class Vector {

    double x, y;

    public Vector(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Vector(Vector v) {
        x = v.x;
        y = v.y;
    }

    public Vector(Point p) {
        x = p.x;
        y = p.y;
    }

    public double abs() {
        return Math.sqrt(x * x + y * y);
    }

    public double getAngle() {
        return Math.atan(y / x) + (x < 0 ? Math.PI : 0);
    }

    public Point getPoint() {
        return new Point((int) Math.round(x), (int) Math.round(y));
    }

    public boolean is_zeros() {
        return x == 0 && y == 0;
    }
}