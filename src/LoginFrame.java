import javax.swing.*;
import java.awt.*;

public class LoginFrame extends JPanel{
    public LoginFrame() {
        createLoginPanel();
    }

    public void createLoginPanel() {
        JPanel loginPanel = new JPanel();
        loginPanel.setLayout(new GridLayout(3, 1));

        JLabel loginLabel = new JLabel("Login");
        JTextField loginField = new JTextField();
        JLabel passwordLabel = new JLabel("Password");
        JPasswordField passwordField = new JPasswordField();
        JButton loginButton = new JButton("Login");

        loginPanel.add(loginLabel);
        loginPanel.add(loginField);
        loginPanel.add(passwordLabel);
        loginPanel.add(passwordField);
        loginPanel.add(loginButton);

        this.add(loginPanel);
    }

    private void showLoginDialog() {
        String username = JOptionPane.showInputDialog(S29352.frame, "Username:");
        String password = JOptionPane.showInputDialog(S29352.frame, "Password:");

        if (validateCredentials(username, password)) {
            S29352.isLoggedIn = true;
            updateUI();
            showMessage("Logged in as: " + username);
        } else {
            showMessage("Błędne dane logowania.");
            System.exit(0);
        }
    }

private boolean validateCredentials(String username, String password) {
    if (username.equals("admin") && password.equals("admin")) {
        return true;
    } else return username.equals("user") && password.equals("user");
}

private void showMessage(String message) {
    JOptionPane.showMessageDialog(S29352.frame, message);
}
}
