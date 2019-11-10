package visual;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

@SuppressWarnings("serial")
public class Map extends JPanel implements ActionListener {

    private final int B_WIDTH = 380;
    private final int B_HEIGHT = 280;
    private final int escala = 10;
    private boolean trueNormal;
    private boolean trueKitty;
    private boolean trueStar;

    public int getPontosMatriz() {
        return PontosMatriz;
    }

    private final int PontosMatriz = 900;
    private final int DELAY = 100;

    private boolean jogando = false;
    private boolean morto = false;
    Timer timer;

    private Snake normal;
    private Kitty scape;
    private Star dobro;

    private final int x[] = new int[PontosMatriz];
    private final int y[] = new int[PontosMatriz];

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

    public void doDrawing(Graphics g){
        g.setColor(Snake.getCor());
        for (int z = normal.getTamanhoDaCobra() - 1; z > 0; --z) {
            int posX = (int) normal.getPosicaoCorpo()[z].getX();
            int posY = (int) normal.getPosicaoCorpo()[z].getY();
            g.fillRect(posX, posY, escala, escala);
        }
        Toolkit.getDefaultToolkit().sync();
    }

    public void doGameOver(Graphics g){
        String msg = "Game Over";
        Font big = new Font("Helvetica", Font.BOLD, 25);
        FontMetrics metr = getFontMetrics(big);

        g.setColor(Color.white);
        g.setFont(big);
        g.drawString(msg, (B_WIDTH - metr.stringWidth(msg)) / 2, B_HEIGHT / 2);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (jogando) {
            colisao();
            normal.move();
        }
        repaint();
    }

    public void colisao(){
        System.out.println(normal.getHouveColisao()+" "+jogando);
        if(normal.verColisao()){
            jogando = false;
            morto = true;
        }
        if(!jogando){
            timer.stop();
        }
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
}
