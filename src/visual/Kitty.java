package visual;

import visual.Snake;

import java.awt.*;

public class Kitty extends Snake{
    public Kitty(int Pontos) {
        super(Pontos);
        cor = new Color(255,153,205);
        score = 0;
    }
}
