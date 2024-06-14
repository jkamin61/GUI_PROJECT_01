import javax.swing.*;
import java.awt.*;

public class LoginFrame {
    private JDialog dialog;
    private JTextField loginField;
    private JPasswordField passwordField;
    public static String initialPassword = "admin";
    public static String initialUser = "AA";
    public LoginFrame() {
        createLoginDialog();
    }

    private void createLoginDialog() {
        dialog = new JDialog((Frame) null, "Login", true);
        dialog.setLayout(new GridLayout(3, 2));
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        dialog.setSize(300, 150);
        dialog.setLocationRelativeTo(null);

        JLabel loginLabel = new JLabel("Login:");
        loginField = new JTextField();
        JLabel passwordLabel = new JLabel("Password:");
        passwordField = new JPasswordField();
        JButton loginButton = new JButton("Login");

        dialog.add(loginLabel);
        dialog.add(loginField);
        dialog.add(passwordLabel);
        dialog.add(passwordField);
        dialog.add(new JLabel());
        dialog.add(loginButton);

        loginButton.addActionListener(e -> {
            String username = loginField.getText();
            String password = new String(passwordField.getPassword());
            if (validateCredentials(username, password)) {
                Main.isLoggedIn = true;
                showMessage("Logged in as: " + username);
                dialog.dispose();
            } else {
                showMessage("Invalid credentials.");
            }
        });
    }

    public void showLoginDialog() {
        dialog.setVisible(true);
    }

    private boolean validateCredentials(String username, String password) {
        return (username.equals("admin") && password.equals(initialPassword)) ||
                (username.equals("user") && password.equals("user"));
    }

    private void showMessage(String message) {
        JOptionPane.showMessageDialog(dialog, message);
    }
}
