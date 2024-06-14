import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.List;

public class EmployeeDepartmentView extends JPanel {
    private DefaultListModel<String> listModelDepartment;
    private JList<String> listData;
    private JScrollPane scrollPane;
    private JTextField departmentNameField;
    private EmployeeDepartment employeeDepartment;

    public EmployeeDepartmentView() {
        setLayout(new BorderLayout());
        listModelDepartment = new DefaultListModel<>();
        listData = new JList<>(listModelDepartment);
        listData.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        scrollPane = new JScrollPane(listData);
        add(scrollPane, BorderLayout.CENTER);
        try {
            loadDepartments();
        } catch (NotUniqueException e) {
            throw new RuntimeException(e);
        }
    }

    public void createDepartment() {
        String departmentName = JOptionPane.showInputDialog(this, "Enter Department Name:");
        try {
            EmployeeDepartment department = employeeDepartment.createDepartment(departmentName);
            listModelDepartment.addElement(department.toString());

        } catch (NotUniqueException | IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void editDepartment() {
        int selectedIndex = listData.getSelectedIndex();
        if (selectedIndex != -1) {
            String newDepartmentName = JOptionPane.showInputDialog(this, "Enter new department name:");
            if (!newDepartmentName.isEmpty()) {
                EmployeeDepartment department = employeeDepartment.getDepartments().get(selectedIndex);
                department.setDepartmentName(newDepartmentName);
                listModelDepartment.set(selectedIndex, department.toString());
            }
        }
    }

    public void deleteDepartment() {
        int[] selectedIndices = listData.getSelectedIndices();
        if (selectedIndices.length > 0) {
            Arrays.sort(selectedIndices);

            for (int i = selectedIndices.length - 1; i >= 0; i--) {
                int index = selectedIndices[i];
                EmployeeDepartment department = employeeDepartment.getDepartments().get(index);
                employeeDepartment.getDepartments().remove(department);
                listModelDepartment.remove(index);
            }
        }
    }

    private void loadDepartments() throws NotUniqueException {
        listModelDepartment.clear();
        if (employeeDepartment == null) {
            employeeDepartment = new EmployeeDepartment("IT");
            employeeDepartment.createDepartment("IT");
        }
        for (EmployeeDepartment department : employeeDepartment.getDepartments()) {
            listModelDepartment.addElement(department.toString());
        }
    }

    public JTextField getDepartmentNameField() {
        return departmentNameField;
    }

    public JList<String> getListData() {
        return listData;
    }

    public void showEmployees() {
        int selectedIndex = listData.getSelectedIndex();
        if (selectedIndex != -1) {
            EmployeeDepartment department = employeeDepartment.getDepartments().get(selectedIndex);

            List<Employee> employees = department.getEmployeesFromDepartment(department);

            JFrame frame = new JFrame("Employees in " + department.getDepartmentName());
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame.setSize(400, 300);
            frame.setLayout(new BorderLayout());

            DefaultListModel<String> listModelEmployee = new DefaultListModel<>();
            JList<String> listDataEmployee = new JList<>(listModelEmployee);
            listDataEmployee.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
            JScrollPane scrollPane = new JScrollPane(listDataEmployee);
            frame.add(scrollPane, BorderLayout.CENTER);

            // Dodaj pracowników do modelu listy
            for (Employee employee : employees) {
                listModelEmployee.addElement(employee.toString());
            }

            // Ustaw widoczność ramki na true
            frame.setVisible(true);
        }
    }
}
