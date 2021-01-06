import java.awt.*;

public class Physics {

    public static Vector CheckCollision(Point circle, int r, Rectangle rect) {
        Rectangle tmp = new Rectangle(circle.x, circle.y, r, r);
        if (tmp.intersects(rect))
            return new Vector(0, 1);
        return new Vector(0, 0);
    }
}
