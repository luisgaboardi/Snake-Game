package visual;

import java.awt.Color;

public class Kitty extends Snake {

    public Kitty(int pontos) {
        super(pontos);
        setColor(new Color(255, 150, 255));
            snakeType[0] = false;
            snakeType[1] = false;
            snakeType[2] = true;
    }

}