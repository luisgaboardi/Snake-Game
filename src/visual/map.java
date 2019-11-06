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

    public int getPontosMatriz() {
        return PontosMatriz;
    }

    private final int PontosMatriz = 900;
    private final int DELAY = 100;
    boolean jogando = false;
    boolean morto = false;
    Timer timer;

    private snake normal;
    private kitty 

    private final int x[] = new int[PontosMatriz];
    private final int y[] = new int[PontosMatriz];

    public snake getSnake(){
        return normal;
    }

    public void setSnake(snake snake){
        this.normal = normal;
    }

    public map(){
        setBackground(Color.black);
        setPreferredSize(new Dimension(B_WIDTH,B_HEIGHT));
        setFocusable(true);
        iniciarJogo();
    }

    private void iniciarJogo(){
        this.normal = new snake(PontosMatriz);
        for(int z = 0; z < normal.getTamanhoDaCobra();z++){
            normal.getPosicaoCorpo()[z].x = 100-z*escala;
            normal.getPosicaoCorpo()[z].y = 100;
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

    @Override
    public void actionPerformed(ActionEvent actionEvent) {

    }

    public snake getKitty() {
    }
}
