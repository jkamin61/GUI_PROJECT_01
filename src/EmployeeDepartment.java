import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDepartment {
    private static List<EmployeeDepartment> departments = new ArrayList<>();
    private static List<Employee> employeesInDepartment = new ArrayList<>();
    private String departmentName;


    public EmployeeDepartment(String departmentName) {
        this.departmentName = departmentName;

    }

    public static EmployeeDepartment createDepartment(String departmentName) throws NotUniqueException, IllegalArgumentException {
        for (EmployeeDepartment department : departments) {
            if (department.departmentName.equals(departmentName)) {
                throw new NotUniqueException("Department " + departmentName + " already exists!");
            }
        }
        if (departmentName == null || departmentName.isEmpty()) {
            throw new IllegalArgumentException("Department name cannot be empty!");
        } else {
            EmployeeDepartment department = new EmployeeDepartment(departmentName);
            EmployeeDepartment employeeDepartment = new EmployeeDepartment(departmentName);
            departments.add(department);
            return department;
        }
    }

    public void addEmployeesToDepartment(Employee employee) {
        System.out.println("Adding employee to department1");
        employeesInDepartment.add(employee);
    }

    public static void removeEmployeesFromDepartment(Employee employee) {
        employeesInDepartment.remove(employee);
    }

    public List<Employee> getEmployeesFromDepartment(EmployeeDepartment department) {
        List<Employee> employees = new ArrayList<>();
        for (Employee employee : employeesInDepartment) {
            if (employee.getDepartment().equals(department)) {
                employees.add(employee);
            }
        }
        return employees;
    }

    public static List<EmployeeDepartment> getDepartments() {
        return departments;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public static EmployeeDepartment getDepartmentByName(String departmentName) {
        for (EmployeeDepartment department : getDepartments()) {
            if (department.departmentName.equals(departmentName)) {
                return department;
            }
        }
        JOptionPane.showMessageDialog(null, "Department " + departmentName + " does not exist!", "Error", JOptionPane.ERROR_MESSAGE);
        throw new IllegalArgumentException("Department " + departmentName + " does not exist!");
    }

    @Override
    public String toString() {
        return "EmployeeDepartment{" +
                "departmentName='" + departmentName + '\'' +
                '}';
    }

    public String getDepartmentName() {
        return departmentName;
    }
}
