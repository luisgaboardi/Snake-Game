package visual;

import java.awt.Color;
import java.awt.Point;
import java.util.Random;

public class Fruit {

    int scoreValue;
    private Point pos;
    private Color color = new Color(0, 45, 255);

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
