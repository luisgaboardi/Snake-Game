package visual;

import java.awt.Color;

public class Snake {
	private int bodySize;
	private int posX;
	private int posY;
	private int bodyPos[][];
	private int scale;
	private int speed;
	private Color color;
	private int score;
	
	public Snake() {
		bodySize = 4;
		bodyPos = new int[bodySize][bodySize];
		posX = 140;
		posY = 140;
		scale = 20;
		speed = 5;
		color = new Color(255, 255, 255);
		score = 0;
	}

	public int getBodySize() {
		return bodySize;
	}

	public void setBodySize(int bodySize) {
		this.bodySize = bodySize;
	}

	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}

	public int[][] getBodyPos() {
		return bodyPos;
	}

	public void setBodyPos(int[][] bodyPos) {
		this.bodyPos = bodyPos;
	}

	public int getScale() {
		return scale;
	}

	public void setScale(int scale) {
		this.scale = scale;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
	
}