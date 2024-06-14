import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class ContractView extends JPanel {
    private DefaultTableModel tableModelContract;
    private JTable tableDataContract;
    private JScrollPane scrollPane;

    public ContractView() {
        setLayout(new BorderLayout());
        tableModelContract = new DefaultTableModel(new Object[]{"Contract"}, 0);
        tableDataContract = new JTable(tableModelContract);
        tableDataContract.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        scrollPane = new JScrollPane(tableDataContract);
        add(scrollPane, BorderLayout.CENTER);
        tableModelContract.setRowCount(0);
    }

    public void addContract() {
        String contractName = JOptionPane.showInputDialog(this, "Enter Contract Name:");
        if (contractName != null && !contractName.isEmpty()) {
            tableModelContract.addRow(new Object[]{contractName});
        }
    }

    public void editContract() {
        int selectedIndex = tableDataContract.getSelectedRow();
        if (selectedIndex != -1) {
            String newContractName = JOptionPane.showInputDialog(this, "Enter new contract name:");
            if (newContractName != null && !newContractName.isEmpty()) {
                tableModelContract.setValueAt(newContractName, selectedIndex, 0);
            }
        }
    }

    public void deleteContract() {
        int[] selectedIndices = tableDataContract.getSelectedRows();
        if (selectedIndices.length > 0) {
            DefaultTableModel model = (DefaultTableModel) tableDataContract.getModel();
            for (int i = selectedIndices.length - 1; i >= 0; i--) {
                model.removeRow(selectedIndices[i]);
            }
        }
    }
}
