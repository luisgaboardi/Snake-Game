package visual;

import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;

public class Snake {
	private int bodySize;
	private ArrayList<Point> bodyPos;
	private int scale;
	private int speed;
	private Color color;
	private int score;
	
	public Snake() {
		bodySize = 4;
		bodyPos = new ArrayList<Point>(4);
		bodyPos.add(new Point(135, 150));
		bodyPos.add(new Point(120, 150));
		bodyPos.add(new Point(105, 150));
		bodyPos.add(new Point(90, 150));
		scale = 15;
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

	public ArrayList<Point> getBodyPos() {
		return bodyPos;
	}

	public void setBodyPos(ArrayList<Point> bodyPos) {
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