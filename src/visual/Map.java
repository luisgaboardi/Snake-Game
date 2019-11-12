package visual;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

@SuppressWarnings("serial")
public class Map extends JPanel implements ActionListener {

    private final int B_WIDTH = 370;
    private final int B_HEIGHT = 280;
    private final int escala = 10;
    private boolean trueNormal;
    private boolean trueKitty;
    private boolean trueStar;
    //private boolean trueBig;

    private final int PontosMatriz = 1036;
    private final int DELAY = 100;

    private boolean jogando = false;
    private boolean morto = false;
    Timer timer;

    private Obstaculo problema;
    private Obstaculo problema2;
    private Obstaculo problema3;
    private Obstaculo problema4;
    private Obstaculo problema5;
    private Fruta maca;
    private Big macaGrande;
    private Bomb macaBomba;
    private Decrease macaDiminui;
    private Snake normal;
    private Kitty scape;
    private Star dobro;
    private boolean trueBig = false;
    private boolean trueDecrease = false;

    private int posXMaca;
    private int posYMaca;
    private int posXMacaG;
    private int posYMacaG;
    private int posXMacaB;
    private int posYMacaB;
    private int posXMacaD;
    private int posYMacaD;
    private int contadorFrutas = 0;
    private final int x[] = new int[PontosMatriz];
    private final int y[] = new int[PontosMatriz];

    public Map(){
        setTrueNormal(true);
        setTrueKitty(false);
        setTrueStar(false);
        addKeyListener(new TAdapter());

        setBackground(Color.black);
        setFocusable(true);

        setPreferredSize(new Dimension(B_WIDTH,B_HEIGHT));
        iniciarJogo();
    }

    private void iniciarJogo(){
            if(trueNormal == true){
                this.normal = new Snake(PontosMatriz);
                for(int z = 0; z < normal.getTamanhoDaCobra();z++){
                    normal.getPosicaoCorpo()[z].x = 100-z*escala;
                    normal.getPosicaoCorpo()[z].y = 100;
                }
            }
            else if(trueKitty == true){
                this.scape = new Kitty(PontosMatriz);
                for(int z = 0; z < scape.getTamanhoDaCobra();z++){
                    scape.getPosicaoCorpo()[z].x = 100-z*escala;
                    scape.getPosicaoCorpo()[z].y = 100;
                }
            }
            else if(trueStar == true){
                this.dobro = new Star(PontosMatriz);
                for(int z = 0; z < dobro.getTamanhoDaCobra();z++){
                    dobro.getPosicaoCorpo()[z].x = 100-z*escala;
                    dobro.getPosicaoCorpo()[z].y = 100;
                }
            }
            problema = new Obstaculo();
            problema2 = new Obstaculo();
            problema3 = new Obstaculo();
            problema4 = new Obstaculo();
            problema5 = new Obstaculo();
            macaBomba = new Bomb();
            macaGrande = new Big();
            macaDiminui = new Decrease();
            maca = new Fruta();
            timer = new Timer(DELAY,this);
            timer.start();
            repaint();
    }

    protected void bindKeyStroke(int condition, String name, KeyStroke keyStroke, Action action) {
        InputMap im = getInputMap(condition);
        ActionMap am = getActionMap();

        im.put(keyStroke, name);
        am.put(name, action);
    }


    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if(jogando) {
            doDrawing(g);
        }

        if(jogando == false && morto == true){
            doGameOver(g);
        }
    }

    private void doDrawing(Graphics g){
        if(contadorFrutas%7 == 0 && contadorFrutas!=0) {
            g.setColor(Big.getCor2());
            posXMacaG = (int) macaGrande.getPosX();
            posYMacaG = (int) macaGrande.getPosY();
            g.fillRect(posXMacaG, posYMacaG, escala, escala);
            trueBig = true;
        }

        if(contadorFrutas%9 == 0 && contadorFrutas!=0 && trueBig == false) {
            g.setColor(Big.getCor4());
            posXMacaD = (int) macaDiminui.getPosX();
            posYMacaD = (int) macaDiminui.getPosY();
            g.fillRect(posXMacaD, posYMacaD, escala, escala);
            trueDecrease = true;
        }

        if(contadorFrutas%2 == 0 && contadorFrutas!=0 && trueBig == false && trueDecrease == false) {
            g.setColor(Big.getCor3());
            posXMacaB = (int) macaBomba.getPosX();
            posYMacaB = (int) macaBomba.getPosY();
            g.fillRect(posXMacaB, posYMacaB, escala, escala);
        }

        g.setColor(Obstaculo.getCor());
        int posXObstaculo = (int) problema.getPosX();
        int posYObstaculo = (int) problema.getPosY();
        g.fillRect(posXObstaculo,posYObstaculo,escala,escala);

        int posXObstaculo2 = (int) problema2.getPosX();
        int posYObstaculo2 = (int) problema2.getPosY();
        g.fillRect(posXObstaculo2,posYObstaculo2,escala,escala);

        int posXObstaculo3 = (int) problema3.getPosX();
        int posYObstaculo3 = (int) problema3.getPosY();
        g.fillRect(posXObstaculo3,posYObstaculo3,escala,escala);

        int posXObstaculo4 = (int) problema4.getPosX();
        int posYObstaculo4 = (int) problema4.getPosY();
        g.fillRect(posXObstaculo4,posYObstaculo4,escala,escala);

        int posXObstaculo5 = (int) problema5.getPosX();
        int posYObstaculo5 = (int) problema5.getPosY();
        g.fillRect(posXObstaculo5,posYObstaculo5,escala,escala);

        g.setColor(Fruta.getCor1());
        posXMaca = (int) maca.getPosX();
        posYMaca = (int) maca.getPosY();
        g.fillRect(posXMaca,posYMaca,escala,escala);

        g.setColor(Snake.getCor());
        for (int z = normal.getTamanhoDaCobra() - 1; z > 0; --z) {
            int posX = (int) normal.getPosicaoCorpo()[z].getX();
            int posY = (int) normal.getPosicaoCorpo()[z].getY();
            g.fillRect(posX, posY, escala, escala);
        }
        trueDecrease = false;
        trueBig = false;
        Toolkit.getDefaultToolkit().sync();
    }

    private void doGameOver(Graphics g){
        System.out.println(normal.getScore());
        String msg = "Game Over";
        Integer scorei = normal.getScore();
        String score = ("Your Score: "+Integer.toString(scorei));
        Font big = new Font("Helvetica", Font.BOLD, 25);
        Font small = new Font("Helvetica", Font.BOLD, 15);
        FontMetrics metr = getFontMetrics(big);
        FontMetrics metr2 = getFontMetrics(small);

        g.setColor(Color.white);
        g.setFont(big);
        g.drawString(msg, (B_WIDTH - metr.stringWidth(msg)) / 2, B_HEIGHT / 2);
        g.setFont(small);
        g.drawString(score,((B_WIDTH - metr2.stringWidth(score)) / 2),B_HEIGHT / 2+ 40);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (jogando) {
            comeuFrutaDecrease();
            comeuFrutaBig();
            comeuFruta();
            colisao();
            normal.move();
        }
        repaint();
    }

    private void comeuFruta(){
        if(normal.posicaoCorpo[0].x == posXMaca && normal.posicaoCorpo[0].y == posYMaca){
            if(!trueStar) {
                normal.crescerCobra(1);
            }
            else{
                normal.crescerCobra(2);
            }
            maca.gerarFruta();
            problema.gerarObstaculo();
            problema2.gerarObstaculo();
            problema3.gerarObstaculo();
            problema4.gerarObstaculo();
            problema5.gerarObstaculo();
            contadorFrutas++;
        }
    }

    private void comeuFrutaBig(){
        if(normal.posicaoCorpo[0].x == posXMacaG && normal.posicaoCorpo[0].y == posYMacaG){
            if(!trueStar) {
                normal.crescerCobraBig(1);
            }
            else{
                normal.crescerCobraBig(2);
            }
            macaGrande.gerarFruta();
            problema.gerarObstaculo();
            problema2.gerarObstaculo();
            problema3.gerarObstaculo();
            problema4.gerarObstaculo();
            problema5.gerarObstaculo();
            contadorFrutas++;
        }
    }

    private void comeuFrutaDecrease(){
        if(normal.posicaoCorpo[0].x == posXMacaD && normal.posicaoCorpo[0].y == posYMacaD){
            normal.setTamanhoDaCobra(macaDiminui.diminuir());
            macaDiminui.gerarFruta();
            problema.gerarObstaculo();
            problema2.gerarObstaculo();
            problema3.gerarObstaculo();
            problema4.gerarObstaculo();
            problema5.gerarObstaculo();
            contadorFrutas++;
        }
    }

    private void colisao(){
        if(normal.verColisao()){
            jogando = false;
            morto = true;
        }
        if(normal.getPosicaoCorpo()[0].x == problema.getPosX() && normal.getPosicaoCorpo()[0].y == problema.getPosY() && !trueKitty){
            jogando = false;
            morto = true;
        }

        if(normal.getPosicaoCorpo()[0].x == problema2.getPosX() && normal.getPosicaoCorpo()[0].y == problema2.getPosY() && !trueKitty){
            jogando = false;
            morto = true;
        }

        if(normal.getPosicaoCorpo()[0].x == problema3.getPosX() && normal.getPosicaoCorpo()[0].y == problema3.getPosY() && !trueKitty){
            jogando = false;
            morto = true;
        }

        if(normal.getPosicaoCorpo()[0].x == problema4.getPosX() && normal.getPosicaoCorpo()[0].y == problema4.getPosY() && !trueKitty){
            jogando = false;
            morto = true;
        }

        if(normal.getPosicaoCorpo()[0].x == problema5.getPosX() && normal.getPosicaoCorpo()[0].y == problema5.getPosY() && !trueKitty){
            jogando = false;
            morto = true;
        }

        if(normal.getPosicaoCorpo()[0].x == macaBomba.getPosX() && normal.getPosicaoCorpo()[0].y == macaBomba.getPosY()){
            jogando = false;
            morto = true;
        }

        if(!jogando){
            timer.stop();
        }
    }

    public boolean getJogando() {
        return jogando;
    }

    private class TAdapter extends KeyAdapter{

        @Override
        public void keyPressed(KeyEvent e) {

            int key = e.getKeyCode();

            if ((key == KeyEvent.VK_LEFT) && (!normal.isAndandoDireita())) {
                normal.setAndandoEsquerda(true);
                normal.setAndandoCima(false);
                normal.setAndandoBaixo(false);
            }

            if ((key == KeyEvent.VK_RIGHT) && (!normal.isAndandoEsquerda())) {
                normal.setAndandoDireita(true);
                normal.setAndandoCima(false);
                normal.setAndandoBaixo(false);
            }

            if ((key == KeyEvent.VK_UP) && (!normal.isAndandoBaixo())) {
                normal.setAndandoCima(true);
                normal.setAndandoDireita(false);
                normal.setAndandoEsquerda(false);
            }

            if ((key == KeyEvent.VK_DOWN) && (!normal.isAndandoCima())) {
                normal.setAndandoBaixo(true);
                normal.setAndandoDireita(false);
                normal.setAndandoEsquerda(false);
            }
        }
    }

    public boolean isTrueNormal() {
        return trueNormal;
    }

    public void setTrueNormal(boolean trueNormal) {
        this.trueNormal = trueNormal;
    }

    public boolean isTrueKitty() {
        return trueKitty;
    }

    public void setTrueKitty(boolean trueKitty) {
        this.trueKitty = trueKitty;
    }

    public boolean isTrueStar() {
        return trueStar;
    }

    public void setTrueStar(boolean trueStar) {
        this.trueStar = trueStar;
    }

    public boolean isJogando() {
        return jogando;
    }

    public void setJogando(boolean jogando) {
        this.jogando = jogando;
    }

    public boolean isMorto() {
        return morto;
    }

    public void setMorto(boolean morto) {
        this.morto = morto;
    }

    public Snake getSnake(){
        return normal;
    }
    public void setSnake(Snake snake){
        this.normal = normal;
    }


    public Kitty getKitty() {return scape;}
    public void setKitty(Kitty scape) {this.scape = scape;}

    public Star getStar() {
        return dobro;
    }

    public void setStar(Star dobro) {
        this.dobro = dobro;
    }

    public int getPontosMatriz() {
        return PontosMatriz;
    }
}
