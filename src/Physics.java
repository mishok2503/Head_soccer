import java.awt.*;

public class Physics {

    public static class Vector {
        double x, y;

        public Vector(double x, double y) {
            this.x = x;
            this.y = y;
        }
    }

    public static Vector CheckCollision(Point circle, int r, Rectangle rect) {
        return new Vector(0, 0);
    }

}
