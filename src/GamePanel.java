import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GamePanel extends JPanel implements ActionListener {
    static final int SCREEN_WIDTH = 800;
    static final int SCREEN_HEIGHT = 800;
    static final int UNIT_SIZE = 20;
    static final int GAME_UNITS = (SCREEN_WIDTH * SCREEN_HEIGHT) / (UNIT_SIZE * UNIT_SIZE);
    static final int DELAY = 75;

    private final Snake snake;
    private final Apple apple;
    private final GameOverScreen gameOverScreen;

    private boolean running = false;
    private int applesEaten = 0;
    private Timer timer;

    public GamePanel() {
        snake = new Snake(GAME_UNITS);
        apple = new Apple();
        gameOverScreen = new GameOverScreen();

        this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
        this.setBackground(Color.black);
        this.setFocusable(true);
        this.addKeyListener(new MyKeyAdapter());
        startGame();
    }

    public void startGame() {
        apple.newApple();
        running = true;
        timer = new Timer(DELAY, this);
        timer.start();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (running) {
            drawGrid(g);
            apple.draw(g);
            snake.draw(g);
            drawScore(g);
        } else {
            gameOverScreen.draw(g, applesEaten);
        }
    }

    public void drawGrid(Graphics g) {
        g.setColor(Color.gray);
        for (int i = 0; i < SCREEN_HEIGHT / UNIT_SIZE; i++) {
            g.drawLine(i * UNIT_SIZE, 0, i * UNIT_SIZE, SCREEN_HEIGHT);
            g.drawLine(0, i * UNIT_SIZE, SCREEN_WIDTH, i * UNIT_SIZE);
        }
    }

    public void drawScore(Graphics g) {
        g.setColor(Color.red);
        g.setFont(new Font("Ink Free", Font.BOLD, 40));
        FontMetrics metrics = getFontMetrics(g.getFont());
        g.drawString("Score: " + applesEaten, (SCREEN_WIDTH - metrics.stringWidth("Score: " + applesEaten)) / 2,
                        g.getFont().getSize());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (running) {
            snake.move();
            checkApple();
            if (snake.checkCollisions()) {
                running = false;
                timer.stop();
            }
        }
        repaint();
    }

    public void checkApple() {
        if ((snake.getX()[0] == apple.getAppleX()) && (snake.getY()[0] == apple.getAppleY())) {
            snake.increaseBodyParts();
            applesEaten += 10;
            apple.newApple();
        }
    }

    public void restartGame() {
        applesEaten = 0;
        snake.reset();
        apple.newApple();
        running = true;
        timer.start();
    }

    public class MyKeyAdapter extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            switch (e.getKeyCode()) {
                case KeyEvent.VK_LEFT:
                    if (snake.getDirection() != 'R') {
                        snake.setDirection('L');
                    }
                    break;
                case KeyEvent.VK_RIGHT:
                    if (snake.getDirection() != 'L') {
                        snake.setDirection('R');
                    }
                    break;
                case KeyEvent.VK_UP:
                    if (snake.getDirection() != 'D') {
                        snake.setDirection('U');
                    }
                    break;
                case KeyEvent.VK_DOWN:
                    if (snake.getDirection() != 'U') {
                        snake.setDirection('D');
                    }
                    break;
                case KeyEvent.VK_R:
                    if (!running) {
                        restartGame();
                    }
                    break;
                case KeyEvent.VK_Q:
                    if (!running) {
                        System.exit(0);
                    }
                    break;
            }
        }
    }
}
