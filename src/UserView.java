import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class UserView  extends JPanel {
    private DefaultListModel<String> listModelUser;
    private JList<String> listData;
    private JScrollPane scrollPane;
    private DefaultTableModel tableModelUser;
    private JTable tableData;


    public UserView() {
        setLayout(new BorderLayout());
        tableModelUser = new DefaultTableModel(new Object[]{"Password"}, 0);
        tableData = new JTable(tableModelUser);
        tableData.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        scrollPane = new JScrollPane(tableData);
        add(scrollPane, BorderLayout.CENTER);
        tableModelUser.setRowCount(0);
        tableModelUser.addRow(new Object[]{LoginFrame.initialPassword});
    }

    public void changePassword() {
        String newPassword = JOptionPane.showInputDialog(this, "Enter new password:");
        if (newPassword != null && !newPassword.isEmpty()) {
            LoginFrame.initialPassword = newPassword;
            tableModelUser.setValueAt(newPassword, 0, 0);
        }
    }

}
