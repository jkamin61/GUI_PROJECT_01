import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

        JPanel inputPanel = new JPanel(new FlowLayout());
        departmentNameField = new JTextField(15);

        inputPanel.add(new JLabel("Department Name:"));
        inputPanel.add(departmentNameField);

        add(inputPanel, BorderLayout.SOUTH);

        loadDepartments();
    }

    public void createDepartment() {
        String name = departmentNameField.getText();
        try {
            EmployeeDepartment department = EmployeeDepartment.createDepartment(name);
            listModelDepartment.addElement(department.toString());
            departmentNameField.setText("");
        } catch (NotUniqueException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void editDepartment() {
        int selectedIndex = listData.getSelectedIndex();
        if (selectedIndex != -1) {
            String newName = departmentNameField.getText();
            if (!newName.isEmpty()) {
                EmployeeDepartment department = EmployeeDepartment.getDepartments().get(selectedIndex);
                department.setDepartmentName(newName);
                listModelDepartment.set(selectedIndex, department.toString());
                departmentNameField.setText("");
            }
        }
    }

    public void deleteDepartment() {
        int selectedIndex = listData.getSelectedIndex();
        if (selectedIndex != -1) {
            EmployeeDepartment department = EmployeeDepartment.getDepartments().get(selectedIndex);
            EmployeeDepartment.getDepartments().remove(department);
            listModelDepartment.remove(selectedIndex);
            departmentNameField.setText("");
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
