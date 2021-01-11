import java.awt.*;

public class Physics {

    public static double eps = 10;//TODO
    public static boolean is_equal(double a, double b) {
        return a <= b + eps && a >= b - eps;
    }

    public static double distance(Point a, Point b) {
        return Math.sqrt((a.x - b.x) * (a.x - b.x) + (a.y - b.y) * (a.y - b.y));
    }

    public static Vector CheckCollision(Rectangle rect, Rectangle rect1) {
        if (rect.intersects(rect1)) {
            if (rect.y + rect.height > rect1.y) //TODO
                return new Vector(0, 1);
            if (rect.y < rect1.y + rect1.height)
                return new Vector(0, -1);
//            if (rect.x < rect1.x + rect1.width)
//                return new Vector(1, 0);
//            if (rect.x + rect.width > rect1.x)
//                return new Vector(-1, 0);
        }

        return new Vector(0, 0);
    }

    public static Vector CheckCollision(Point pos, int r, Point pos1, int r1) {
        r1 /= 2;
        pos1.x += r;
        pos1.y += r;

        r /= 2;
        pos.x += r;
        pos.y += r;
        if (is_equal(distance(pos, pos1), r + r1)) {
            return new Vector(pos.x - pos1.x, pos.y - pos1.y);
        }

        return new Vector(0, 0);
    }

    public static Vector CheckCollision(Point pos, int r, Rectangle rect) {
        Point[] points = {new Point(rect.x, rect.y), new Point(rect.x + rect.width, rect.y), new Point(rect.x + rect.width, rect.y + rect.height), new Point(rect.x, rect.y + rect.height)};
        if (is_equal(pos.y + r, points[0].y))
            if (points[0].x - eps <= pos.x && pos.x <= points[1].x + eps)
                return new Vector(0, 1);
        if (is_equal(pos.y, points[2].y))
            if (points[3].x - eps <= pos.x && pos.x <= points[2].x + eps)
                return new Vector(0, -1);
        if (is_equal(pos.x, points[1].x))
            if (points[1].y - eps <= pos.y && pos.y <= points[3].y + eps)
                return new Vector(-1, 0);
        if (is_equal(pos.x + r, points[0].x))
            if (points[1].y - eps <= pos.y && pos.y <= points[3].y + eps)
                return new Vector(1, 0);

        r /= 2;
        pos.x += r;
        pos.y += r;
        for (Point point : points) {
            if (is_equal(distance(pos, point), r)) {
                return new Vector(pos.x - point.x, pos.y - point.y);
            }
        }

        return  new Vector(0, 0);
    }
}
