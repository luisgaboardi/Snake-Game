package visual;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.List;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Grid extends JPanel {

    private List<Point> fillCells;
    private Snake snake;
    private Fruit fruit;
    private int scale;
    
	public Snake getSnake() {
		return snake;
	}
	public Fruit getFruit() {
		return fruit;
	}
	public int getScale() {
		return scale;
	}

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        Snake snake = new Snake();
    	Fruit fruit = new Fruit();
    	scale = 15;
    	
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, 375, 285);

//        g.setColor(Color.WHITE);
//        for (int i = 0; i <= 360; i += getScale()) {
//            g.drawLine(i, 0, i, 285);
//        }
//        for (int i = 0; i <= 270; i += getScale()) {
//            g.drawLine(0, i, 375, i);
//        }

//	      // Iniciando cobra 
	      g.setColor(Color.WHITE);
	      for (int i = 0; i < snake.getBodySize(); ++i) {
	    	  int posX = (int)snake.getBodyPos().get(i).getX();
	    	  int posY = (int)snake.getBodyPos().get(i).getY();
	          g.fillRect(posX, posY, getScale(), getScale());
	      }
//	        
//	      // Iniciando Fruta
	      g.setColor(Color.RED);
	      g.fillRect((int) fruit.getPos().getX(), (int)fruit.getPos().getY(), getScale(), getScale());
	        
    }
             

    public void fillCell(int x, int y) {
        fillCells.add(new Point(x, y));
        repaint();
    }
    
}