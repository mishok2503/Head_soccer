import java.awt.*;

public class Physics {

    public static double Eps = 8;//TODO
    public static boolean is_equal(double a, double b) {
        return a <= b + Eps && a >= b - Eps;
    }

    public static Vector CheckCollision(Point pos, int r, Rectangle rect) {
        Point[] points = {new Point(rect.x, rect.y), new Point(rect.x + rect.width, rect.y), new Point(rect.x + rect.width, rect.y + rect.height), new Point(rect.x, rect.y + rect.height)};
        if (is_equal(pos.y + r, points[0].y))
            if (points[0].x <= pos.x && pos.x <= points[1].x)
                return new Vector(0, 1);
        if (is_equal(pos.y, points[2].y))
            if (points[3].x <= pos.x && pos.x <= points[2].x)
                return new Vector(0, -1);
        if (is_equal(pos.x, points[1].x))
            if (points[1].y <= pos.y && pos.y <= points[3].y)
                return new Vector(-1, 0);
        if (is_equal(pos.x + r, points[0].x))
            if (points[1].y <= pos.y && pos.y <= points[3].y)
                return new Vector(1, 0);
        return  new Vector(0, 0);
    }
}
