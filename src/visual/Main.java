package visual;

import java.awt.EventQueue;

public class Main {
    public static void main(String args[]) {
        EventQueue.invokeLater(() -> {
            try {
                Tela window = new Tela();
                window.getJanelaJogo().setVisible(true);
            } catch (Exception e) {
            }
        });

    }
}
