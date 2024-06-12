import javax.swing.*;
import java.time.LocalDateTime;

public class EmployeeView extends JPanel {
    private DefaultListModel<String> listModelEmployee;
    private JList<String> listData;
    private JScrollPane scrollPane;
    private JTextField employeeNameField;
    private JTextField employeeSurnameField;
    private JTextField employeeDateOfBirthField;
    private JTextField employeeDepartmentField;

    public EmployeeView() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        listModelEmployee = new DefaultListModel<>();
        listData = new JList<>(listModelEmployee);
        listData.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        scrollPane = new JScrollPane(listData);

        add(scrollPane);

        loadEmployees();
    }

    public void loadEmployees() {
        listModelEmployee.clear();
        for (Employee employee : Employee.getEmployees()) {
            listModelEmployee.addElement(employee.toString());
        }
    }

    public void createEmployee() {
        String name = employeeNameField.getText();
        String surname = employeeSurnameField.getText();
        LocalDateTime dateOfBirth = LocalDateTime.parse(employeeDateOfBirthField.getText());
        String department = employeeDepartmentField.getText();
        EmployeeDepartment employeeDepartment = EmployeeDepartment.getDepartmentByName(department);
        Employee employee = new Employee(name, surname, dateOfBirth, employeeDepartment);
        listModelEmployee.addElement(employee.toString());
        employeeNameField.setText("");
        employeeSurnameField.setText("");
        employeeDateOfBirthField.setText("");
    }

    public void editEmployee() {
        int selectedIndex = listData.getSelectedIndex();
        if (selectedIndex != -1) {
            String newName = employeeNameField.getText();
            String newSurname = employeeSurnameField.getText();
            String newSalary = employeeDateOfBirthField.getText();
            if (!newName.isEmpty() && !newSurname.isEmpty() && !newSalary.isEmpty()) {
                Employee employee = Employee.getEmployees().get(selectedIndex);
                employee.setEmployeeName(newName);
                employee.setEmployeeSurname(newSurname);
                listModelEmployee.set(selectedIndex, employee.toString());
                employeeNameField.setText("");
                employeeSurnameField.setText("");
                employeeDateOfBirthField.setText("");
            }
        }
    }
}
