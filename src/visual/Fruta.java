package visual;

import java.awt.*;

public class Fruta {
    protected int posX;
    protected int posY;
    protected int escala = 10;

    public static Color getCor() {
        return cor;
    }

    protected static Color cor;
    protected Graphics g;

    public Fruta(){
        cor = new Color(51,255,51);
        gerarFruta();
    }

    public void gerarFruta(){
        int r = (int) (Math.random() * 38);
        posX = r*escala;

        r = (int) (Math.random() * 28);
        posY = r*escala;
    }

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }
}
