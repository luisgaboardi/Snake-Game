package visual;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class Barriers extends JPanel {

    private final int width = 370;
    private final int height = 290;
    private final int scale = 10;

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(new Color(90, 40, 0));

        for (int y = 30; y < 200; y += scale) {
            for (int x = 50; x > 30; x -= scale) {
                g.fillRect(x, y, scale, scale);
            }
        }

        for (int y = height; y > 250; y -= 10) {
            for (int x = 80; x < 180; x += scale) {
                g.fillRect(x, y, scale, scale);
            }
        }

        for (int y = height; y > 250; y -= 10) {
            for (int x = 80; x < 180; x += scale) {
                g.fillRect(x, y, scale, scale);
            }
        }

    }

}
