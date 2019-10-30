package visual;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Grid extends JPanel {

    private Snake snake;
    private Fruit fruit;
    private int scale;
    
	public void setSnake(Snake snake) {
		this.snake = snake;
	}
	public void setFruit(Fruit fruit) {
		this.fruit = fruit;
	}
	public void setScale(int scale) {
		this.scale = scale;
	}
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
        
        snake = new Snake();
    	fruit = new Fruit();
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

	      g.setColor(snake.getColor());
	      for (int i = 0; i < snake.getBodySize(); ++i) {
	    	  int posX = (int)snake.getBodyPos().get(i).getX();
	    	  int posY = (int)snake.getBodyPos().get(i).getY();
	          g.fillRect(posX, posY, getScale(), getScale());
	      }
	        
	      g.setColor(Color.RED);
	      g.fillRect((int) fruit.getPos().getX(), (int)fruit.getPos().getY(), getScale(), getScale());
	        
    }
    
}