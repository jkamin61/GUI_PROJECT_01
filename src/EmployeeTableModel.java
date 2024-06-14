import javax.swing.table.AbstractTableModel;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class EmployeeTableModel extends AbstractTableModel {
    private final List<Employee> employees;
    private final String[] columnNames = {"Name", "Surname", "Date of Birth", "Department"};

    public EmployeeTableModel(List<Employee> employees) {
        this.employees = employees;
    }

    @Override
    public int getRowCount() {
        return employees.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public String getColumnName(int columnIndex) {
        return columnNames[columnIndex];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Employee employee = employees.get(rowIndex);
        switch (columnIndex) {
            case 0: return employee.getName();
            case 1: return employee.getSurname();
            case 2: return employee.getDateOfBirth().format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
            case 3: return employee.getDepartment().getDepartmentName();
            default: return null;
        }
    }

    public void addEmployee() {
        fireTableDataChanged();
    }
}
