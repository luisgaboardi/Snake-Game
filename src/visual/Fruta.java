package visual;

import java.awt.*;

public class Fruta implements Runnable{
    protected int posX;
    protected int posY;
    protected int escala = 10;

    private static Color cor1;
    private static Color cor2;
    private static Color cor3;
    private static Color cor4;

    public Fruta(){
        cor1 = new Color(51,255,51);
        gerarFruta();
    }

    public void gerarFruta(){
        int r = (int) (Math.random() * 37);
        posX = r*escala;

        r = (int) (Math.random() * 28);
        posY = r*escala;
    }

    @Override
    public void run() {
      Fruta normal = new Fruta();
    }

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }

    public static void setCor1(Color cor) {
        Fruta.cor1 = cor;
    }

    public static Color getCor1() {
        return cor1;
    }

    public static Color getCor2() {
        return cor2;
    }

    public static void setCor2(Color cor2) {
        Fruta.cor2 = cor2;
    }

    public static Color getCor3() {
        return cor3;
    }

    public static void setCor3(Color cor3) {
        Fruta.cor3 = cor3;
    }

    public static Color getCor4() {
        return cor4;
    }

    public static void setCor4(Color cor4) {
        Fruta.cor4 = cor4;
    }
}
