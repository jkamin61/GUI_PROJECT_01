import java.awt.*;

public class Main {
    public static boolean isLoggedIn = false;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            showLoginAndInitializeApp();
        });
    }

    public static void showLoginAndInitializeApp() {
        LoginFrame loginFrame = new LoginFrame();
        loginFrame.showLoginDialog();
        if (isLoggedIn) {
            try {
                S29352 window = new S29352();
                window.frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
