package visual;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import javax.swing.JPanel;

public class Barriers extends JPanel {

    private final int width = 370;
    private final int height = 290;
    private final int scale = 10;
    
    protected Point[] pos;

    public Barriers() {
        this.pos = new Point[184];
        
        int i = 0;
        
        for (int y = 30; y < 200; y += scale) {
            for (int x = 50; x > 30; x -= scale) {
                pos[i] = new Point(x, y);
                i++;
            }
        }

        for (int y = height; y > 250; y -= scale) {
            for (int x = 80; x < 180; x += scale) {
                pos[i] = new Point(x, y);
                i++;
            }
        }

        for (int y = 250; y > 200; y -= scale) {
            for (int x = 140; x < 180; x += scale) {
                pos[i] = new Point(x, y);
                i++;
            }
        }
        
        for (int y = 260; y > 220; y -= scale) {
            for (int x = 290; x < 320; x += scale) {
                pos[i] = new Point(x, y);
                i++;
            }
        }
        
        for (int y = 10; y < 100; y += scale) {
            for (int x = 280; x < 340; x += scale) {
                pos[i] = new Point(x, y);
                i++;
            }
        }
        
        for (int y = 70; y < 90; y += scale) {
            for (int x = 200; x > 80; x -= scale) {
                pos[i] = new Point(x, y);
                i++;
            }
        }
        
    }
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(new Color(90, 40, 0));
        
        for(int i = 0; i < 184; ++i) {
            g.fillRect(pos[i].x, pos[i].y, scale, scale);
        }
        

    }

}
