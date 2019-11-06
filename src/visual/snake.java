package visual;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class snake{
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

    public snake(int Pontos){
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

    private class comando extends KeyAdapter{
        public void botaoApertado(KeyEvent evento) {
            int botao = evento.getKeyCode();
            if(botao == KeyEvent.VK_LEFT && (!andandoDireita)){
                andandoEsquerda = true;
                andandoBaixo = false;
                andandoCima = false;
            }

            if(botao == KeyEvent.VK_RIGHT && (!andandoEsquerda)){
                andandoDireita = true;
                andandoBaixo = false;
                andandoCima = false;
            }

            if(botao == KeyEvent.VK_DOWN && (!andandoCima)){
                andandoBaixo = true;
                andandoEsquerda = false;
                andandoDireita = false;
            }
            if(botao == KeyEvent.VK_UP && (!andandoBaixo)){
                andandoCima = true;
                andandoEsquerda = false;
                andandoDireita = false;
            }
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

    public int getScore(int i) {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}