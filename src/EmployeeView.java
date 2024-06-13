import javax.swing.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class EmployeeView extends JPanel {
    private DefaultListModel<String> listModelEmployee;
    private JList<String> listData;
    private JScrollPane scrollPane;


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
        EmployeeDepartment IT = EmployeeDepartment.getDepartmentByName("IT");
        Employee employee1 = new Employee("John", "Doe", LocalDateTime.of(1999, 10, 20, 0, 0), IT);
        Employee employee2 = new Employee("Jane", "Doe", LocalDateTime.of(1999, 10, 20, 0, 0), IT);
        listModelEmployee.addElement(employee1.toString());
        listModelEmployee.addElement(employee2.toString());
    }

    public void createEmployee() {
        JTextField nameField = new JTextField(5);
        JTextField surnameField = new JTextField(5);
        JTextField dateOfBirthField = new JTextField(5);
        JTextField departmentField = new JTextField(5);

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
            LocalDate date = null;
            try {
                date = LocalDate.parse(dateOfBirth, formatter);
            } catch (DateTimeParseException e) {
                JOptionPane.showMessageDialog(this, "Invalid date format. Please enter the date in the format dd.MM.yyyy");
                return;
            }

            LocalDateTime dateTime = date.atStartOfDay();
            EmployeeDepartment department = EmployeeDepartment.getDepartmentByName(employeeDepartment);
            if (department == null) {
                JOptionPane.showMessageDialog(this, "Department " + employeeDepartment + " does not exist!");
                return;
            }
            Employee employee = new Employee(name, surname, dateTime, department);
            listModelEmployee.addElement(employee.toString());
        }
    }

    public void deleteEmployee() {
        int[] selectedIndices = listData.getSelectedIndices();
        if (selectedIndices.length > 0) {
            for (int i = selectedIndices.length - 1; i >= 0; i--) {
                Employee employee = Employee.getEmployees().get(selectedIndices[i]);
                Employee.getEmployees().remove(employee);
                listModelEmployee.remove(selectedIndices[i]);
            }
        }
    }

    public void editEmployee() {
        int selectedIndex = listData.getSelectedIndex();
        if (selectedIndex != -1) {
            Employee employee = Employee.getEmployees().get(selectedIndex);
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
                EmployeeDepartment department = EmployeeDepartment.getDepartmentByName(employeeDepartment);

                employee.setName(name);
                employee.setSurname(surname);
                employee.setDateOfBirth(dateTime);
                employee.setEmployeeDepartment(department);
                listModelEmployee.set(selectedIndex, employee.toString());
            }
        }
    }
}
