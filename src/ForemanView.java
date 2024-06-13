import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

public class ForemanView extends JPanel {
    private DefaultListModel<String> listModelForeman;
    private JList<String> listData;
    private JScrollPane scrollPane;

    public ForemanView() {
        setLayout(new BorderLayout());
        listModelForeman = new DefaultListModel<>();
        listData = new JList<>(listModelForeman);
        listData.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        scrollPane = new JScrollPane(listData);
        add(scrollPane, BorderLayout.CENTER);

        loadForemans();
    }

    public void loadForemans() {
        listModelForeman.clear();
        User user = User.getUsers().get(0);
        Foreman foreman1 = new Foreman(user);
        listModelForeman.addElement(foreman1.toString());
        for (Foreman foreman : Foreman.getForemans()) {
            listModelForeman.addElement(foreman.toString());
        }
    }

    public void addForeman() {
        String foremanLogin = JOptionPane.showInputDialog(this, "Enter foreman name:");
        if (foremanLogin != null && !foremanLogin.trim().isEmpty()) {
            User user = User.getUserByLogin(foremanLogin);
            if (user == null) return;
            Foreman foreman = new Foreman(user);
            listModelForeman.addElement(foreman.toString());
        } else {
            JOptionPane.showMessageDialog(this, "Foreman name cannot be empty.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void editForeman() {
        int selectedIndex = listData.getSelectedIndex();
        if (selectedIndex != -1) {
            String foremanLogin = JOptionPane.showInputDialog(this, "Enter new foreman name:");
            if (foremanLogin != null && !foremanLogin.trim().isEmpty()) {
                User user = User.getUserByLogin(foremanLogin);
                if (user == null) return;
                //TODO: make possible to edit foreman
//                Foreman foreman = Foreman.getForemans().get(selectedIndex);
//                foreman.user = user;
//                listModelForeman.set(selectedIndex, foreman.toString());
            } else {
                JOptionPane.showMessageDialog(this, "Foreman name cannot be empty.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "No foreman selected.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void deleteForeman() {
        int[] selectedIndices = listData.getSelectedIndices();
        if (selectedIndices.length > 0) {
            Arrays.sort(selectedIndices);
            for (int i = selectedIndices.length - 1; i >= 0; i--) {
                Foreman.getForemans().remove(selectedIndices[i]);
                listModelForeman.removeElementAt(selectedIndices[i]);
            }
        } else {
            JOptionPane.showMessageDialog(this, "No foreman selected.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

}
