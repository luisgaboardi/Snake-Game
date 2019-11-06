package visual;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings("serial")
public class map extends JPanel implements ActionListener {

    private final int B_WIDTH = 300;
    private final int B_HEIGHT = 300;
    private final int escala = 10;
    private boolean trueNormal;
    private boolean trueKitty;
    private boolean trueStar;

    public int getPontosMatriz() {
        return PontosMatriz;
    }

    private final int PontosMatriz = 900;
    private final int DELAY = 100;
    boolean jogando = false;
    boolean morto = false;
    Timer timer;

    private snake normal;
    private kitty scape;

    private star dobro;

    private final int x[] = new int[PontosMatriz];
    private final int y[] = new int[PontosMatriz];

    public snake getSnake(){
        return normal;
    }
    public void setSnake(snake snake){
        this.normal = normal;
    }


    public kitty getKitty() {return scape;}
    public void setKitty(kitty scape) {this.scape = scape;}

    public star getStar() {
        return dobro;
    }

    public void setStar(star dobro) {
        this.dobro = dobro;
    }

    public map(){
        setTrueNormal(true);
        setTrueKitty(false);
        setTrueStar(false);
        setBackground(Color.black);
        setPreferredSize(new Dimension(B_WIDTH,B_HEIGHT));
        setFocusable(true);
        iniciarJogo();
    }

    private void iniciarJogo(){
        if(trueNormal == true){
            this.normal = new snake(PontosMatriz);
            for(int z = 0; z < normal.getTamanhoDaCobra();z++){
                normal.getPosicaoCorpo()[z].x = 100-z*escala;
                normal.getPosicaoCorpo()[z].y = 100;
            }
        }
        else if(trueKitty == true){
            this.scape = new kitty(PontosMatriz);
            for(int z = 0; z < scape.getTamanhoDaCobra();z++){
                scape.getPosicaoCorpo()[z].x = 100-z*escala;
                scape.getPosicaoCorpo()[z].y = 100;
            }
        }
        else if(trueStar == true){
            this.dobro = new star(PontosMatriz);
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
        g.setColor(snake.getCor());
        for (int z = normal.getTamanhoDaCobra() - 1; z > 0; --z) {
            int posX = (int) normal.getPosicaoCorpo()[z].getX();
            int posY = (int) normal.getPosicaoCorpo()[z].getY();
            g.fillRect(posX, posY, escala, escala);

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

    @Override
    public void actionPerformed(ActionEvent actionEvent) {

    }
}
