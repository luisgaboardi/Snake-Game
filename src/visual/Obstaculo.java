package visual;

import java.awt.*;

public class Obstaculo {
    private int escala = 10;

    private int posX;
    private int posY;
    private static Color cor;

    public Obstaculo(){
        cor = new Color(255,255,255);
        gerarObstaculo();
    }

    public void gerarObstaculo(){
        int r = (int) (Math.random() * 37);
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

    public static Color getCor() {
        return cor;
    }
}
