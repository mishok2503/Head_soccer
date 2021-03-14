import java.awt.*;

public class Player {

    private Vector pos, prevPos;
    private Vector headPos = new Vector(0, -80);;
    private int headR = 80, moveBlock = 0;
    private Vector speed = new Vector(0, 0);
    private final Point size;
    private boolean isOnFloor = false;
    private final double g;

    public Player(Field field, Point size, boolean isLeft, double g) {
        this.size = size;
        this.g = g;
        prevPos = pos = new Vector(field.getPlayerStartPos(isLeft));
    }

    public Rectangle getRect() {
        return new Rectangle((int) pos.x, (int) pos.y, size.x, size.y);
    }
    public Rectangle[] getCircles() {
        return  new Rectangle[]{new Rectangle((int) (pos.x + headPos.x), (int) (pos.y + headPos.y), headR, headR)};
    }

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

    public void move(double dt) {
        prevPos = new Vector(pos);
        if (!isOnFloor)
            speed.y += g * dt;
        if (moveBlock * speed.x > 0)
            speed.x = 0;
        pos.add(new Vector(speed.x * dt, speed.y * dt));
        //double airLoss = 0.004 * dt;
        //speed.mul(1 - airLoss);
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

    public void jump() {
        if (isOnFloor) {
            isOnFloor = false;
            speed.y -= 9;//TODO: remove constant
        }
    }
}
