import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class JobView extends JPanel {
    private DefaultTableModel tableModelJob;
    private JTable tableDataJob;
    private JScrollPane scrollPane;

    public JobView() {
        setLayout(new BorderLayout());
        tableModelJob = new DefaultTableModel(new Object[]{"Job"}, 0);
        tableDataJob = new JTable(tableModelJob);
        scrollPane = new JScrollPane(tableDataJob);
        add(scrollPane);
        tableModelJob.setRowCount(0);
    }

    public void addJob() {
        String jobName = JOptionPane.showInputDialog(this, "Enter Job Name:");
        if (jobName != null && !jobName.isEmpty()) {
            tableModelJob.addRow(new Object[]{jobName});
        }
    }

    public void editJob() {
        int selectedIndex = tableDataJob.getSelectedRow();
        if (selectedIndex != -1) {
            String newJobName = JOptionPane.showInputDialog(this, "Enter new job name:");
            if (newJobName != null && !newJobName.isEmpty()) {
                tableModelJob.setValueAt(newJobName, selectedIndex, 0);
            }
        }
    }

    public void deleteJob() {
        int[] selectedIndices = tableDataJob.getSelectedRows();
        if (selectedIndices.length > 0) {
            DefaultTableModel model = (DefaultTableModel) tableDataJob.getModel();
            for (int i = selectedIndices.length - 1; i >= 0; i--) {
                model.removeRow(selectedIndices[i]);
            }
        }
    }

}
