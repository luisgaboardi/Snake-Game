package visual;

import java.awt.Color;
import java.awt.Point;
import java.util.Random;

public class Fruit {
	private int scoreValue;
	private int growValue;
	private Point pos;
	private boolean isSimple;
	private boolean isBomb;
	private boolean isBig;
	private boolean isDecrease;
	private Color color = new Color(255, 20, 20);
	
	public int getScoreValue() {
		return scoreValue;
	}

	public void setScoreValue(int scoreValue) {
		this.scoreValue = scoreValue;
	}
	
	public int getGrowValue() {
		return growValue;
	}

	public void setGrowValue(int growValue) {
		this.growValue = growValue;
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

	public Fruit(String type) {
		if (type == "Simple") {
			setGrowValue(1);
			setScoreValue(1);
		} else if (type == "Bomb") {
			// Mata cobra
		} else if (type == "Big") {
			setGrowValue(1);
			setScoreValue(2);
		} else if (type == "Decrease") {
			// Reduz cobra pra tamanho inicial
		}
	}
	
	private static int getRandomNumberInRange(int min, int max) {

		if (min >= max) {
			throw new IllegalArgumentException("max must be greater than min");
		}

		Random r = new Random();
		return (r.nextInt((max - min) + 1) + min) * 15;
	}
	
	public Fruit() {
		int posX = getRandomNumberInRange(0, 24);
		int posY = getRandomNumberInRange(0, 18);
		pos = new Point(posX, posY);	
	}

}
