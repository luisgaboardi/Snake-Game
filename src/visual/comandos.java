package visual;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class comandos extends KeyAdapter {
    private boolean andandoDireita = true;
    private boolean andandoEsquerda = false;
    private boolean andandoCima = false;
    private boolean andandoBaixo = false;

    private int botao;

    public void botaoApertado(KeyEvent e){
        botao = e.getKeyCode();
        if (botao == KeyEvent.VK_LEFT && (!andandoDireita)) {
            andandoEsquerda = true;
            andandoBaixo = false;
            andandoCima = false;
        }

        if (botao == KeyEvent.VK_RIGHT && (!andandoEsquerda)) {
            andandoDireita = true;
            andandoBaixo = false;
            andandoCima = false;
        }

        if (botao == KeyEvent.VK_DOWN && (!andandoCima)) {
            andandoBaixo = true;
            andandoEsquerda = false;
            andandoDireita = false;
        }
        if (botao == KeyEvent.VK_UP && (!andandoBaixo)) {
            andandoCima = true;
            andandoEsquerda = false;
            andandoDireita = false;
        }
    }
}