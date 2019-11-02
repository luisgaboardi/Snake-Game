package visual;

import java.awt.Color;
import java.awt.Point;
import java.util.Random;

public class Fruit {
	private int scoreValue;
	private Point pos;
	private boolean isSimple;
	private boolean isBomb;
	private boolean isBig;
	private boolean isDecrease;
	private Color color = new Color(255, 20, 20);
	
	public Fruit() {
            locateFruit();
	}
	
	public Point locateFruit() {
            int posX = getRandomNumberInRange(0, 36);
            int posY = getRandomNumberInRange(0, 28);
            pos = new Point(posX, posY);
            
            return pos;
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

	public boolean isSimple() {
		return isSimple;
	}

	public void setSimple(boolean isSimple) {
		this.isSimple = isSimple;
	}

	public boolean isBomb() {
		return isBomb;
	}

	public void setBomb(boolean isBomb) {
		this.isBomb = isBomb;
	}

	public boolean isBig() {
		return isBig;
	}

	public void setBig(boolean isBig) {
		this.isBig = isBig;
	}

	public boolean isDecrease() {
		return isDecrease;
	}

	public void setDecrease(boolean isDecrease) {
		this.isDecrease = isDecrease;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}
	
	private static int getRandomNumberInRange(int min, int max) {

		if (min >= max) {
			throw new IllegalArgumentException("max must be greater than min");
		}

		Random r = new Random();
		return (r.nextInt((max - min) + 1) + min) * 10;
	}

}
