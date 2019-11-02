package visual;

import java.awt.Color;
import java.awt.Point;

public class Snake {
	private int bodySize;
	private Point[] bodyPos;
	private final int scale = 10;
	private int speed;
	private Color color;
	int score;
        protected boolean snakeType[] = new boolean[3];
        
        protected boolean upDirection = false;
        protected boolean downDirection = false;
        protected boolean rightDirection = true;
        protected boolean leftDirection = false;
	
	public Snake(int pontos) {
            bodySize = 5;
            bodyPos = new Point[pontos];
            bodyPos[0] = (new Point(100, 100));
            bodyPos[1] = (new Point(90, 100));
            bodyPos[2] = (new Point(80, 100));
            bodyPos[3] = (new Point(70, 100));
            bodyPos[4] = (new Point(60, 100));
            speed = 5;
            color = new Color(255, 255, 255);
            score = 0;
            
            snakeType[0] = true;
            snakeType[1] = false;
            snakeType[2] = false;
	}
        
        public void move() {

            for (int z = this.bodySize-1; z > 0; z--) {
                this.bodyPos[z].x = this.bodyPos[z-1].x;
                this.bodyPos[z].y = this.bodyPos[z-1].y;
            }

            if (leftDirection) {
               bodyPos[0].x -= scale;
            }

            if (rightDirection) {
                bodyPos[0].x += scale;
            }

            if (upDirection) {
                bodyPos[0].y -= scale;
            }

            if (downDirection) {
                bodyPos[0].y += scale;
            }
    }

	public int getBodySize() {
		return bodySize;
	}

	public void setBodySize(int bodySize) {
		this.bodySize = bodySize;
	}

	public Point[] getBodyPos() {
		return bodyPos;
	}

	public int getScale() {
		return scale;
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