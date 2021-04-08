import java.awt.*;
import static java.lang.Math.min;

public class Player {

    private Vector pos, prevPos;
    private Vector headPos = new Vector(0, -80);;
    private int headR = 80, moveBlock = 0;
    private Vector speed = new Vector(0, 0);
    private final Point size;
    private boolean isOnFloor = false, isOnBall = false;
    private final double g;

    public Player(Field field, Point size, boolean isLeft, double g) {
        this.size = size;
        this.g = g;
        prevPos = pos = new Vector(field.getPlayerStartPos(isLeft));
    }

    public Rectangle getRect() {
        return new Rectangle((int) pos.x, (int) pos.y, size.x, size.y);
    }
    public Rectangle getCircle() {
        return new Rectangle((int) (pos.x + headPos.x), (int) (pos.y + headPos.y), headR, headR);
    }

//    public boolean isIn(Rectangle ball)
//    {
//        Vector ballCenter = new Vector(ball.x + ball.width / 2.0, ball.y + ball.height / 2.0);
//        Point headCenter = new Point((int) (pos.x + headPos.x) + headR / 2, (int) (pos.y + headPos.y) + headR / 2);
//        if (Physics.distance(ballCenter.getPoint(), headCenter) < headR / 2.0)
//            return true;
//        return ballCenter.isIn(getRect());
//    }

    public void CollisionProcessing(Rectangle rect) {
        if (pos.x < rect.x || pos.x + size.x > rect.x + rect.width) {
            pos.x = prevPos.x;
            speed.x = 0;
        }
        if (pos.y < rect.y || pos.y + size.y + headR > rect.y + rect.height) {
            pos.y = prevPos.y;
            speed.y = 0;
            isOnFloor = true;
        }
    }

    public boolean onBall(Rectangle ball)
    {
        isOnBall = false;
        if (ball.y < 830) //TODO: magic numbers
            return false;
        if (ball.x + 6 > pos.x && ball.x + ball.width < pos.x + size.x + 8 && ball.x < pos.y + size.y) { //TODO: magic numbers
            if (ball.y  - 12 < pos.y + size.y) {//TODO: magic numbers
                isOnBall = true;
                return true;
            }
        }
        return false;
    }

    public void move(double dt) {
        prevPos = new Vector(pos);
        if (!isOnFloor && !isOnBall)
            speed.y += g * dt;
        if (moveBlock * speed.x > 0)
            speed.x = 0;
        if (isOnBall)
            speed.y = min(0, speed.y);
        pos.add(new Vector(speed.x * dt, speed.y * dt));
    }

    public Vector getSpeed() {
        return speed;
    }

    public void setMoveBlock(int block) {
        moveBlock = block;
    }

    public void setXSpeed(double speedX) {
        speed.x = speedX;
    }

    public void setSpeed(Vector speed) {
        this.speed = speed;
    }

    public void setOnFloor(boolean onFloor) {
        isOnFloor = onFloor;
    }

    public void setPos(Point pos) {
        this.pos = new Vector(pos);
    }

    public void jump() {
        if (isOnFloor || isOnBall) {
            isOnFloor = false;
            speed.y -= 9;//TODO: remove constant
        }
    }
}
