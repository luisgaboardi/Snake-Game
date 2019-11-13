package visual;

import java.awt.Color;
import java.awt.Point;

public class Kitty extends Snake {

    public Kitty(int pontos) {
        super(pontos);
        setColor(new Color(255, 150, 255));
        snakeType[0] = false;
        snakeType[1] = false;
        snakeType[2] = true;
    }

    @Override
    public boolean checkCollision(Barriers barrier) {

        boolean morto = false;

        for (int z = getBodySize() - 1; z > 0; --z) {
            if ((getBodyPos()[0].x == getBodyPos()[z].x) && (getBodyPos()[0].y == getBodyPos()[z].y)) {
                morto = true;
            }
        }

        if (getBodyPos()[0].y >= 290) {
            morto = true;
        }

        if (getBodyPos()[0].y < 0) {
            morto = true;
        }

        if (getBodyPos()[0].x >= 370) {
            morto = true;
        }

        if (getBodyPos()[0].x < 0) {
            morto = true;
        }

        return morto;
    }

}
