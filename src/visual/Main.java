package visual;

import java.awt.EventQueue;

public class Main {
    public static void main(String args[]) {
        EventQueue.invokeLater(() -> {
            try {
                Window window = new Window();
            } catch (Exception e) {}
        });

    }
}
