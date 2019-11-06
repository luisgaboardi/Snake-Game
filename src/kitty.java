import visual.snake;

import java.awt.*;

public class kitty extends snake{
    public kitty(int Pontos) {
        super(Pontos);
        cor = new Color(255,153,205);
        score = 0;
    }

    public int getScore(int i) {
        return score;
    }
}
