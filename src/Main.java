import gui.S29352;

import java.awt.*;

public class Main {
    public static void main(String[] args) {
            //initialize GUI
            EventQueue.invokeLater(() -> {
                try {
                    S29352 window = new S29352();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
    }
}
