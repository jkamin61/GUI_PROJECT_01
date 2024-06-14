import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class BrigadeView extends JPanel {
    private DefaultTableModel tableModelBrigade;
    private JTable tableDataBrigade;
    private JScrollPane scrollPane;

    public BrigadeView() {
        setLayout(new BorderLayout());
        tableModelBrigade = new DefaultTableModel(new Object[]{"Brigade"}, 0);
        tableDataBrigade = new JTable(tableModelBrigade);
        tableDataBrigade.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        scrollPane = new JScrollPane(tableDataBrigade);
        add(scrollPane, BorderLayout.CENTER);
        tableModelBrigade.setRowCount(0);
    }

    public void addBrigade() {
        String brigadeName = JOptionPane.showInputDialog(this, "Enter Brigade Name:");
        if (brigadeName != null && !brigadeName.isEmpty()) {
            tableModelBrigade.addRow(new Object[]{brigadeName});
        }
    }

    public void editBrigade() {
        int selectedIndex = tableDataBrigade.getSelectedRow();
        if (selectedIndex != -1) {
            String newBrigadeName = JOptionPane.showInputDialog(this, "Enter new brigade name:");
            if (newBrigadeName != null && !newBrigadeName.isEmpty()) {
                tableModelBrigade.setValueAt(newBrigadeName, selectedIndex, 0);
            }
        }
    }

    public void deleteBrigade() {
        int[] selectedIndices = tableDataBrigade.getSelectedRows();
        if (selectedIndices.length > 0) {
            DefaultTableModel model = (DefaultTableModel) tableDataBrigade.getModel();
            for (int i = selectedIndices.length - 1; i >= 0; i--) {
                model.removeRow(selectedIndices[i]);
            }
        }
    }
}
