package visual;
import java.awt.*;

public class Snake{

    protected boolean andandoDireita = true;
    protected boolean andandoEsquerda = false;
    protected boolean andandoCima = false;
    protected boolean andandoBaixo = false;

    protected int tamanhoDaCobra;
    protected Point[] posicaoCorpo;
    protected final int escala = 10;
    protected int velocidade;
    protected static Color cor;
    protected int score;

    public Snake(int Pontos){
        tamanhoDaCobra = 5;
        posicaoCorpo = new Point[Pontos];
        posicaoCorpo[0] = (new Point(100,100));
        posicaoCorpo[1] = (new Point(90,100));
        posicaoCorpo[2] = (new Point(80,100));
        posicaoCorpo[3] = (new Point(70,100));
        posicaoCorpo[4] = (new Point(60,100));
        velocidade = 5;
        cor = new Color(255,255,255);
        score = 0;
    }

    public void move(){
        for(int z =this.tamanhoDaCobra-1; z > 0;z--){
            this.posicaoCorpo[z].x = this.posicaoCorpo[z-1].x;
            this.posicaoCorpo[z].y = this.posicaoCorpo[z-1].y;
        }
        if(andandoEsquerda){
            posicaoCorpo[0].x -= escala;
        }
        if(andandoDireita){
            posicaoCorpo[0].x += escala;
        }
        if(andandoBaixo){
            posicaoCorpo[0].y += escala;
        }
        if(andandoCima){
            posicaoCorpo[0].y -= escala;
        }
    }

    public int getTamanhoDaCobra() {
        return tamanhoDaCobra;
    }

    public void setTamanhoDaCobra(int tamanhoDaCobra) {
        this.tamanhoDaCobra = tamanhoDaCobra;
    }

    public Point[] getPosicaoCorpo() {
        return posicaoCorpo;
    }

    public void setPosicaoCorpo(Point[] posicaoCorpo) {
        this.posicaoCorpo = posicaoCorpo;
    }

    public int getEscala() {
        return escala;
    }

    public int getVelocidade() {
        return velocidade;
    }

    public void setVelocidade(int velocidade) {
        this.velocidade = velocidade;
    }

    public static Color getCor() {
        return cor;
    }

    public void setCor(Color cor) {
        this.cor = cor;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public boolean isAndandoDireita() {
        return andandoDireita;
    }

    public void setAndandoDireita(boolean andandoDireita) {
        this.andandoDireita = andandoDireita;
    }

    public boolean isAndandoEsquerda() {
        return andandoEsquerda;
    }

    public void setAndandoEsquerda(boolean andandoEsquerda) {
        this.andandoEsquerda = andandoEsquerda;
    }

    public boolean isAndandoCima() {
        return andandoCima;
    }

    public void setAndandoCima(boolean andandoCima) {
        this.andandoCima = andandoCima;
    }

    public boolean isAndandoBaixo() {
        return andandoBaixo;
    }

    public void setAndandoBaixo(boolean andandoBaixo) {
        this.andandoBaixo = andandoBaixo;
    }
}