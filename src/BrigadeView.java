import javax.swing.*;
import java.awt.*;
import java.util.List;

public class BrigadeView extends JPanel {
    private DefaultListModel<String> listModelBrigade;
    private JList<String> listData;
    private JScrollPane scrollPane;

    public BrigadeView() {
        setLayout(new BorderLayout());
        listModelBrigade = new DefaultListModel<>();
        listData = new JList<>(listModelBrigade);
        listData.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        scrollPane = new JScrollPane(listData);
        add(scrollPane, BorderLayout.CENTER);

        loadBrigades();
    }

    public void loadBrigades() {
        listModelBrigade.clear();
        for (Brigade brigade : Brigade.getBrigades()) {
            listModelBrigade.addElement(brigade.toString());
        }
    }

    public void addBrigade() {
        String brigadeName = JOptionPane.showInputDialog(this, "Enter brigade name:");
        if (brigadeName == null || brigadeName.trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Brigade name cannot be empty.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        List<Foreman> foremen = Foreman.getForemans();
        List<Employee> employees = Employee.getEmployees();

        if (foremen.isEmpty() || employees.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No foremen or employees available.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Foreman selectedForeman = (Foreman) JOptionPane.showInputDialog(this, "Select Foreman:", "Foreman Selection",
                JOptionPane.QUESTION_MESSAGE, null, foremen.toArray(), foremen.get(0));

        if (selectedForeman == null) {
            JOptionPane.showMessageDialog(this, "No foreman selected.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        JList<Employee> employeeList = new JList<>(employees.toArray(new Employee[0]));
        employeeList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        JScrollPane employeeScrollPane = new JScrollPane(employeeList);

        int result = JOptionPane.showConfirmDialog(this, employeeScrollPane, "Select Employees",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        if (result != JOptionPane.OK_OPTION || employeeList.getSelectedValuesList().isEmpty()) {
            JOptionPane.showMessageDialog(this, "No employees selected.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        List<Employee> selectedEmployees = employeeList.getSelectedValuesList();
        Brigade brigade = new Brigade(brigadeName, selectedForeman, selectedEmployees);
        listModelBrigade.addElement(brigade.toString());
    }
}
