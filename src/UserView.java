import javax.swing.*;
import java.awt.*;

public class UserView  extends JPanel {
    private DefaultListModel<String> listModelUser;
    private JList<String> listData;
    private JScrollPane scrollPane;

    public UserView() {
        setLayout(new BorderLayout());
        listModelUser = new DefaultListModel<>();
        listData = new JList<>(listModelUser);
        listData.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        scrollPane = new JScrollPane(listData);
        add(scrollPane, BorderLayout.CENTER);

        loadUsers();
    }

    public void loadUsers() {
        listModelUser.clear();
        for (User user : User.getUsers()) {
            listModelUser.addElement(user.toString());
        }
    }

    public void changeUserPassword() {
        int selectedIndex = listData.getSelectedIndex();
        if (selectedIndex != -1) {
            String newPassword = JOptionPane.showInputDialog(this, "Enter new password:");
            if (newPassword != null && !newPassword.trim().isEmpty()) {
                User user = User.getUsers().get(selectedIndex);
                user.setPassword(newPassword);
                listModelUser.set(selectedIndex, user.toString());
            } else {
                JOptionPane.showMessageDialog(this, "Password cannot be empty.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "No user selected.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

}
