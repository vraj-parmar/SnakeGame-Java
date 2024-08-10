import java.awt.*;
import java.util.Random;

public class Snake {
    private static final int UNIT_SIZE = 20;
    private static final int SCREEN_WIDTH = 800;
    private static final int SCREEN_HEIGHT = 800;

    private final int x[];
    private final int y[];
    private int bodyParts;
    private char direction;

    public Snake(int gameUnits) {
        x = new int[gameUnits];
        y = new int[gameUnits];
        bodyParts = 6;
        direction = 'R';
    }

    public int[] getX() { return x; }
    public int[] getY() { return y; }
    public int getBodyParts() { return bodyParts; }
    public char getDirection() { return direction; }
    public void setDirection(char direction) { this.direction = direction; }
    public void increaseBodyParts() { bodyParts++; }

    public void move() {
        for (int i = bodyParts; i > 0; i--) {
            x[i] = x[i - 1];
            y[i] = y[i - 1];
        }

        switch (direction) {
            case 'U':
                y[0] = y[0] - UNIT_SIZE;
                break;
            case 'D':
                y[0] = y[0] + UNIT_SIZE;
                break;
            case 'L':
                x[0] = x[0] - UNIT_SIZE;
                break;
            case 'R':
                x[0] = x[0] + UNIT_SIZE;
                break;
        }
    }

    public void reset() {
        bodyParts = 6;
        direction = 'R';
        for (int i = 0; i < bodyParts; i++) {
            x[i] = 0;
            y[i] = 0;
        }
    }

    public boolean checkCollisions() {
        for (int i = bodyParts; i > 0; i--) {
            if ((x[0] == x[i]) && (y[0] == y[i])) {
                return true;
            }
        }
        if (x[0] < 0 || x[0] >= SCREEN_WIDTH || y[0] < 0 || y[0] >= SCREEN_HEIGHT) {
            return true;
        }
        return false;
    }

    public void draw(Graphics g) {
        for (int i = 0; i < bodyParts; i++) {
            if (i == 0) {
                g.setColor(Color.green);
                g.fillRect(x[i], y[i], UNIT_SIZE, UNIT_SIZE);
            } else {
                g.setColor(new Color(45, 180, 0));
                g.fillRect(x[i], y[i], UNIT_SIZE, UNIT_SIZE);
            }
        }
    }
}
