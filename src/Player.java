import java.awt.*;

public class Player {

    private Vector pos, prevPos;
    private Vector headPos = new Vector(0, -80);;
    private int headR = 80, moveBlock = 0;
    private Vector speed = new Vector(0, 0);
    private final Point size;
    private final boolean isLeft;
    private boolean isOnFloor = false ;

    public Player(Field field, Point size, boolean isLeft) {
        this.isLeft = isLeft;
        this.size = size;
        prevPos = pos = new Vector(field.getPlayerStartPos(this.isLeft));
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
        if (pos.y < rect.y || pos.y + size.y > rect.y + rect.height) {
            pos.y = prevPos.y;
            speed.y = 0;
        }
    }

    public void move(double g) {
        prevPos = new Vector(pos);
        if (!isOnFloor)
            speed.y += g;
        if (moveBlock * speed.x > 0)
            speed.x = 0;
        pos.add(speed);
        double airLoss = 0.004;
        speed.mul(1 - airLoss);
    }

    public Vector getSpeed() {
        return speed;
    }

    public void setMoveBlock(int block) {
        moveBlock = block;
    }

    public void setXSpeed(double a) {
        speed = new Vector(a, speed.y);
    }

    public void jump() {
        if (isOnFloor) {
            isOnFloor = false;
            pos.y += -10;
            speed.y += -9;//TODO: remove constant
        }
    }
}
