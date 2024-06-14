import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class EmployeeView extends JPanel {
    private EmployeeTableModel employeeTableModel;
    private JTable employeeTable;
    private JScrollPane scrollPane;
    private JComboBox<String> departmentComboBox;

    public EmployeeView() {
        setLayout(new BorderLayout());
//        loadEmployees();
        employeeTableModel = new EmployeeTableModel(Employee.getEmployees());
        employeeTable = new JTable(employeeTableModel);
        scrollPane = new JScrollPane(employeeTable);
        add(scrollPane, BorderLayout.CENTER);

        departmentComboBox = new JComboBox<>();
        updateDepartmentComboBox();
        for (EmployeeDepartment department : EmployeeDepartment.getDepartments()) {
            departmentComboBox.addItem(department.getDepartmentName());
        }

        departmentComboBox.addActionListener(e -> {
        });
    }

    private void updateDepartmentComboBox() {
        departmentComboBox.removeAllItems();
        for (EmployeeDepartment department : EmployeeDepartment.getDepartments()) {
            departmentComboBox.addItem(department.getDepartmentName());
        }
    }

    public void loadEmployees() {
        for (Employee employee : Employee.getEmployees()) {
            employeeTableModel.addEmployee();
        }
    }

    public void createEmployee() {
        JTextField nameField = new JTextField(5);
        JTextField surnameField = new JTextField(5);
        JTextField dateOfBirthField = new JTextField(5);

        JPanel myPanel = new JPanel();
        myPanel.setLayout(new BoxLayout(myPanel, BoxLayout.Y_AXIS));
        myPanel.add(new JLabel("Enter Employee Name:"));
        myPanel.add(nameField);
        myPanel.add(new JLabel("Enter Employee Surname:"));
        myPanel.add(surnameField);
        myPanel.add(new JLabel("Enter Employee Date of Birth (dd.MM.yyyy):"));
        myPanel.add(dateOfBirthField);
        myPanel.add(new JLabel("Select Department:"));
        myPanel.add(departmentComboBox);
        updateDepartmentComboBox();
        int result = JOptionPane.showConfirmDialog(null, myPanel,
                "Please Enter Employee Details", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            String name = nameField.getText();
            String surname = surnameField.getText();
            String dateOfBirth = dateOfBirthField.getText();
            String selectedDepartmentName = (String) departmentComboBox.getSelectedItem();

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
            LocalDate date;
            try {
                date = LocalDate.parse(dateOfBirth, formatter);
            } catch (DateTimeParseException e) {
                JOptionPane.showMessageDialog(this, "Invalid date format. Please enter the date in the format dd.MM.yyyy");
                return;
            }
            LocalDateTime dateTime = date.atStartOfDay();
            try {
                EmployeeDepartment department = EmployeeDepartment.getDepartmentByName(selectedDepartmentName);
                if (department == null) {
                    JOptionPane.showMessageDialog(this, "Department " + selectedDepartmentName + " does not exist!");
                    return;
                }
                Employee employee = new Employee(name, surname, dateTime, department);
                employeeTableModel.addEmployee();
            } catch (IllegalArgumentException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }


    public void deleteEmployee() {
        int[] selectedRow = employeeTable.getSelectedRows();
        if (selectedRow.length > 0) {
            for (int i = selectedRow.length - 1; i >= 0; i--) {
                Employee employee = Employee.getEmployees().get(selectedRow[i]);
                Employee.getEmployees().remove(employee);
                EmployeeDepartment.removeEmployeesFromDepartment(employee);
                employeeTableModel.fireTableRowsDeleted(selectedRow[i], selectedRow[i]);
            }
        }
    }

    public void editEmployee() {
        int selectedRow = employeeTable.getSelectedRow();
        if (selectedRow != -1) {
            Employee employee = Employee.getEmployees().get(selectedRow);
            JTextField nameField = new JTextField(employee.getName());
            JTextField surnameField = new JTextField(employee.getSurname());
            JTextField dateOfBirthField = new JTextField(employee.getDateOfBirth().format(DateTimeFormatter.ofPattern("dd.MM.yyyy")));
            JTextField departmentField = new JTextField(employee.getDepartment().getDepartmentName());

            JPanel myPanel = new JPanel();
            myPanel.setLayout(new BoxLayout(myPanel, BoxLayout.Y_AXIS));
            myPanel.add(new JLabel("Enter Employee Name:"));
            myPanel.add(nameField);
            myPanel.add(new JLabel("Enter Employee Surname:"));
            myPanel.add(surnameField);
            myPanel.add(new JLabel("Enter Employee Date of Birth (dd.MM.yyyy):"));
            myPanel.add(dateOfBirthField);
            myPanel.add(new JLabel("Enter Employee Department:"));
            myPanel.add(departmentField);

            int result = JOptionPane.showConfirmDialog(null, myPanel,
                    "Please Enter Employee Details", JOptionPane.OK_CANCEL_OPTION);
            if (result == JOptionPane.OK_OPTION) {
                String name = nameField.getText();
                String surname = surnameField.getText();
                String dateOfBirth = dateOfBirthField.getText();
                String employeeDepartment = departmentField.getText();

                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
                LocalDate date;
                try {
                    date = LocalDate.parse(dateOfBirth, formatter);
                } catch (DateTimeParseException e) {
                    JOptionPane.showMessageDialog(this, "Invalid date format. Please enter the date in the format dd.MM.yyyy");
                    return;
                }

                LocalDateTime dateTime = date.atStartOfDay();
                EmployeeDepartment department = new EmployeeDepartment(employeeDepartment);
                department = department.getDepartmentByName(employeeDepartment);
                if (department == null) {
                    JOptionPane.showMessageDialog(this, "Department " + employeeDepartment + " does not exist!");
                    return;
                }
                employee.setName(name);
                employee.setSurname(surname);
                employee.setDateOfBirth(dateTime);
                employee.setEmployeeDepartment(department);
                employeeTableModel.fireTableRowsUpdated(selectedRow, selectedRow);
            }
        }
    }
}
