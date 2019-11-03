import visual.Tela;
import visual.map;

import javax.swing.*;
import java.awt.*;

public class main {
    public static void main(String[] args){
        EventQueue.invokeLater(()->{
            try{
                Tela principal = new Tela();
                principal.getJanelaJogo().setLocationRelativeTo(null);
                principal.getJanelaJogo().setVisible(true);
            }
            catch(Exception e){}
        });
    }
}