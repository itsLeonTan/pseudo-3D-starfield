import java.awt.*;
import java.awt.event.*;
import javax.swing.JPanel;
import javax.swing.Timer;

public class StarPanel extends JPanel {
    Star[] constellation = new Star[1000];
    final private Timer timer;

    public StarPanel() {
        timer = new Timer(10, this::update);
        timer.start();

        for (int i = 0; i < constellation.length; i++) { constellation[i] = new Star(true); }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        setBackground(Color.BLACK);
        g.setColor(Color.WHITE);

        for (Star star:constellation) {
            int size = (int) map(1 / star.posZ, 2 / Starfield.WIDTH, 1, 1, 800);
            g.fillOval(star.displayX, star.displayY, size, size);
        }
    }

    private void update(ActionEvent e) {
        for (int i = 0; i < constellation.length; i++) {
            constellation[i].posZ -= 2;
            constellation[i].displayX = (int) map(Math.ceil(constellation[i].posX - Starfield.WIDTH / 2) / constellation[i].posZ, -1, 1, 0, Starfield.WIDTH);
            constellation[i].displayY = (int) map(Math.ceil(constellation[i].posY - Starfield.HEIGHT / 2) / constellation[i].posZ, -1, 1, 0, Starfield.HEIGHT);

            if (constellation[i].displayX > Starfield.WIDTH || constellation[i].displayX < 0 ||
                constellation[i].displayY > Starfield.HEIGHT || constellation[i].displayY < 0) {
                    constellation[i] = new Star();
                }
        }
        repaint();
    }

    public static double map(double value, float start1, float stop1, float start2, float stop2) {
        return start2 + (stop2 - start2) * ((value - start1) / (stop1 - start1));
    }
}