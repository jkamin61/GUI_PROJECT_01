import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.Arrays;
import java.util.List;

public class EmployeeDepartmentView extends JPanel {
    private EmployeeDepartment employeeDepartment;

    private DefaultTableModel tableModelDepartment;
    private JTable tableData;
    private JScrollPane scrollPane;

    private DefaultTableModel tableModelEmployeeInDepartment;
    private JTable tableDataEmployeeInDepartment;
    private JScrollPane scrollPaneEmployeeInDepartment;

    public EmployeeDepartmentView() {
        setLayout(new BorderLayout());
        tableModelDepartment = new DefaultTableModel(new Object[]{"Department"}, 0);
        tableData = new JTable(tableModelDepartment);
        tableData.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        scrollPane = new JScrollPane(tableData);
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
            tableModelDepartment.addRow(new Object[]{department.getDepartmentName()});
        } catch (NotUniqueException | IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void editDepartment() {
        int selectedIndex = tableData.getSelectedRow();
        if (selectedIndex != -1) {
            String newDepartmentName = JOptionPane.showInputDialog(this, "Enter new department name:");
            if (newDepartmentName != null && !newDepartmentName.isEmpty()) {
                EmployeeDepartment department = employeeDepartment.getDepartments().get(selectedIndex);
                department.setDepartmentName(newDepartmentName);
                tableModelDepartment.setValueAt(newDepartmentName, selectedIndex, 0);
            }
        }
    }

    public void deleteDepartment() {
        int[] selectedIndices = tableData.getSelectedRows();
        if (selectedIndices.length > 0) {
            Arrays.sort(selectedIndices);
            for (int i = selectedIndices.length - 1; i >= 0; i--) {
                int index = selectedIndices[i];
                EmployeeDepartment department = employeeDepartment.getDepartments().get(index);
                employeeDepartment.getDepartments().remove(department);
                tableModelDepartment.removeRow(index);
            }
        }
    }

    private void loadDepartments() throws NotUniqueException {
        tableModelDepartment.setRowCount(0);
        for (EmployeeDepartment department : employeeDepartment.getDepartments()) {
            tableModelDepartment.addRow(new Object[]{department.getDepartmentName()});
        }
    }

    public void showEmployees() {
        int selectedIndex = tableData.getSelectedRow();
        if (selectedIndex != -1) {
            EmployeeDepartment department = employeeDepartment.getDepartments().get(selectedIndex);
            List<Employee> employees = department.getEmployeesFromDepartment(department);

            JFrame frame = new JFrame("Employees in " + department.getDepartmentName());
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame.setSize(400, 300);
            frame.setLayout(new BorderLayout());

            tableModelEmployeeInDepartment = new DefaultTableModel(new Object[]{"Name", "Surname", "Date of birth"}, 0);
            tableDataEmployeeInDepartment = new JTable(tableModelEmployeeInDepartment);
            tableDataEmployeeInDepartment.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
            scrollPaneEmployeeInDepartment = new JScrollPane(tableDataEmployeeInDepartment);
            frame.add(scrollPaneEmployeeInDepartment, BorderLayout.CENTER);

            for (Employee employee : employees) {
                tableModelEmployeeInDepartment.addRow(new Object[]{employee.getName(), employee.getSurname(), employee.getDateOfBirth()});
            }
            frame.setVisible(true);
        }
    }
}
