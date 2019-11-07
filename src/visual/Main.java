package visual;

import java.awt.EventQueue;

public class Main {
    public static void main(String args[]) {
        EventQueue.invokeLater(() -> {
            try {
                Janela window = new Janela();
                window.getJanelaJogo().setVisible(true);
            } catch (Exception e) {}
        });

    }
}
