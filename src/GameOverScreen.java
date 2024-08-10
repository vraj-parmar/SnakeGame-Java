import java.awt.*;

public class GameOverScreen {
    private static final int SCREEN_WIDTH = 800;
    private static final int SCREEN_HEIGHT = 800;

    public void draw(Graphics g, int score) {
        g.setColor(Color.red);
        g.setFont(new Font("Ink Free", Font.BOLD, 75));
        FontMetrics metrics1 = g.getFontMetrics(g.getFont());
        g.drawString("Game Over", (SCREEN_WIDTH - metrics1.stringWidth("Game Over")) / 2, SCREEN_HEIGHT / 2);

        g.setFont(new Font("Ink Free", Font.BOLD, 40));
        FontMetrics metrics2 = g.getFontMetrics(g.getFont());
        g.drawString("Press 'R' to restart", (SCREEN_WIDTH - metrics2.stringWidth("Press 'R' to restart")) / 2, SCREEN_HEIGHT / 2 + metrics1.getHeight());
        g.drawString("Press 'Q' to quit", (SCREEN_WIDTH - metrics2.stringWidth("Press 'Q' to quit")) / 2, SCREEN_HEIGHT / 2 + metrics1.getHeight() + metrics2.getHeight());

        g.drawString("Score: " + score, (SCREEN_WIDTH - metrics2.stringWidth("Score: " + score)) / 2, g.getFont().getSize());
    }
}
