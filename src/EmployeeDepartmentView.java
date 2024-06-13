import javax.swing.*;
import java.awt.*;

public class EmployeeDepartmentView extends JPanel {
    private DefaultListModel<String> listModelDepartment;
    private JList<String> listData;
    private JScrollPane scrollPane;
    private JTextField departmentNameField;

    public EmployeeDepartmentView() {
        setLayout(new BorderLayout());
        listModelDepartment = new DefaultListModel<>();
        listData = new JList<>(listModelDepartment);
        listData.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        scrollPane = new JScrollPane(listData);
        add(scrollPane, BorderLayout.CENTER);

        loadDepartments();
    }

    public void createDepartment() {
        String departmentName = JOptionPane.showInputDialog(this, "Enter Department Name:");
        try {
            EmployeeDepartment department = EmployeeDepartment.createDepartment(departmentName);
            listModelDepartment.addElement(department.toString());
        } catch (NotUniqueException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void editDepartment() {
        int selectedIndex = listData.getSelectedIndex();
        if (selectedIndex != -1) {
            String newDepartmentName = JOptionPane.showInputDialog(this, "Enter new department name:");
            if (!newDepartmentName.isEmpty()) {
                EmployeeDepartment department = EmployeeDepartment.getDepartments().get(selectedIndex);
                department.setDepartmentName(newDepartmentName);
                listModelDepartment.set(selectedIndex, department.toString());
            }
        }
    }

    public void deleteDepartment() {
        int selectedIndex = listData.getSelectedIndex();
        if (selectedIndex != -1) {
            EmployeeDepartment department = EmployeeDepartment.getDepartments().get(selectedIndex);
            EmployeeDepartment.getDepartments().remove(department);
            listModelDepartment.remove(selectedIndex);
        }
    }

    private void loadDepartments() {
        listModelDepartment.clear();
        for (EmployeeDepartment department : EmployeeDepartment.getDepartments()) {
            listModelDepartment.addElement(department.toString());
        }
    }

    public JTextField getDepartmentNameField() {
        return departmentNameField;
    }

    public JList<String> getListData() {
        return listData;
    }
}
