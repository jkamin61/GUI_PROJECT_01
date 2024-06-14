import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class ForemanView extends JPanel {
    private DefaultTableModel tableModelForeman;
    private JTable tableDataForeman;
    private JScrollPane scrollPane;

    public ForemanView() {
        setLayout(new BorderLayout());
        tableModelForeman = new DefaultTableModel(new Object[]{"Name", "Surname"}, 0);
        tableDataForeman = new JTable(tableModelForeman);
        tableDataForeman.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        scrollPane = new JScrollPane(tableDataForeman);
        add(scrollPane, BorderLayout.CENTER);
        tableModelForeman.setRowCount(0);
    }

    public void addForeman() {
        String foremanName = JOptionPane.showInputDialog(this, "Enter Foreman Name:");
        String foremanSurname = JOptionPane.showInputDialog(this, "Enter Foreman Surname:");
        if (foremanName != null && !foremanName.isEmpty() && foremanSurname != null && !foremanSurname.isEmpty()) {
            tableModelForeman.addRow(new Object[]{foremanName, foremanSurname});
        }
    }

    public void editForeman() {
        int selectedIndex = tableDataForeman.getSelectedRow();
        if (selectedIndex != -1) {
            String newForemanName = JOptionPane.showInputDialog(this, "Enter new foreman name:");
            String newForemanSurname = JOptionPane.showInputDialog(this, "Enter new foreman surname:");
            if (newForemanName != null && !newForemanName.isEmpty() && newForemanSurname != null && !newForemanSurname.isEmpty()) {
                tableModelForeman.setValueAt(newForemanName, selectedIndex, 0);
                tableModelForeman.setValueAt(newForemanSurname, selectedIndex, 1);
            }
        }
    }

    public void deleteForeman() {
        int[] selectedIndices = tableDataForeman.getSelectedRows();
        if (selectedIndices.length > 0) {
            DefaultTableModel model = (DefaultTableModel) tableDataForeman.getModel();
            for (int i = selectedIndices.length - 1; i >= 0; i--) {
                model.removeRow(selectedIndices[i]);
            }
        }
    }
}
