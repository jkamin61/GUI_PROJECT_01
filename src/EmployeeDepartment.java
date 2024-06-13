import java.util.List;
import java.util.ArrayList;

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
            departments.add(department);
            return department;
        }
    }

    public static void addEmployeesToDepartment(Employee employee) {
        employeesInDepartment.add(employee);
    }

    public static List<Employee> getEmployeesFromDepartment(EmployeeDepartment department) {
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
        for (EmployeeDepartment department : departments) {
            if (department.departmentName.equals(departmentName)) {
                return department;
            } else {
                throw new IllegalArgumentException("Department " + departmentName + " does not exist!");
            }
        }
        return null;
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

