package visual;

import java.awt.Color;


public class Star extends Snake {

	public Star(int pontos) {
            super(pontos);
            setColor(new Color(255, 255, 0));
            snakeType[0] = false;
            snakeType[1] = true;
            snakeType[2] = false;
	}

}