package visual;

import java.awt.Color;
import java.awt.Point;
import java.util.Random;
import javax.swing.JPanel;
import visual.Window.Grid;

public class Fruit extends JPanel {

    protected int scoreValue;
    private Point pos;
    private Color color = new Color(0, 45, 255);
    protected boolean onScreen = false;

    protected boolean newPos(Grid grid, Snake snake, Barriers barrier) {
        int posX = getRandomNumberInRange(0, 36);
        int posY = getRandomNumberInRange(0, 28);
        Point newPos = new Point(posX, posY);

        for (int z = snake.getBodySize() - 1; z >= 0; z--) {
            if (newPos.equals(snake.getBodyPos()[z])) {
                return false;
            }
        }
        
        for(Point p : barrier.pos) {
            if(newPos.equals(p)) {
                return false; 
            }
        }
        
        onScreen = true;
        setPos(newPos);
        return onScreen;
    }

    protected boolean checkAppleEaten(Snake snake) {
        
        if (snake.getBodyPos()[0].equals(getPos())) {

            if (this instanceof Bomb) {
                snake.dead = true;
                return false;
            } else if (this instanceof Decrease) {
                snake.setBodySize(5);
            } else {
                onScreen = snake.addPart();
                if (snake instanceof Star) {
                    setScoreValue(2 * getScoreValue());
                }
                snake.setScore(snake.getScore() + this.getScoreValue());

            }

            onScreen = false;
            return true;
        }
        
        return false;
    }

    public int getRandomNumberInRange(int min, int max) {
        Random r = new Random();
        return (r.nextInt((max - min) + 1) + min) * 10;
    }
    
    public int getScoreValue() {
        return scoreValue;
    }

    public void setScoreValue(int scoreValue) {
        this.scoreValue = scoreValue;
    }

    public Point getPos() {
        return pos;
    }

    public void setPos(Point pos) {
        this.pos = pos;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

}
