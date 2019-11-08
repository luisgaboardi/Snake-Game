package visual;

import java.awt.Color;
import java.awt.Point;

public class Fruit {

    int scoreValue;
    private Point pos;
    private Color color = new Color(0, 45, 255);

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