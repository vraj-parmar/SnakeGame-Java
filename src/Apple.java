import java.awt.*;
import java.util.Random;

public class Apple {
    private static final int UNIT_SIZE = 20;
    private int appleX;
    private int appleY;
    private Random random;

    public Apple() {
        random = new Random();
        newApple();
    }

    public int getAppleX() { return appleX; }
    public int getAppleY() { return appleY; }

    public void newApple() {
        appleX = random.nextInt((int) (800 / UNIT_SIZE)) * UNIT_SIZE;
        appleY = random.nextInt((int) (800 / UNIT_SIZE)) * UNIT_SIZE;
    }

    public void draw(Graphics g) {
        g.setColor(Color.red);
        g.fillOval(appleX, appleY, UNIT_SIZE, UNIT_SIZE);
    }
}
