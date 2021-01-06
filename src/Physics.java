import java.awt.*;

public class Physics {

    public static class Vector {
        double x, y;

        public Vector(double x, double y) {
            this.x = x;
            this.y = y;
        }

        public boolean is_zeros() {
            return x == 0 && y == 0;
        }
    }

    public static Vector CheckCollision(Point circle, int r, Rectangle rect) {
        Rectangle tmp = new Rectangle(circle.x, circle.y, r, r);
        if (tmp.intersects(rect))
            return new Vector(0, 1);
        return new Vector(0, 0);
    }

}
