import java.util.List;
import java.util.ArrayList;

public class EmployeeDepartment {
    private static List<EmployeeDepartment> departments = new ArrayList<>();
    private String departmentName;

    public EmployeeDepartment(String departmentName) {
        this.departmentName = departmentName;
    }

    public static EmployeeDepartment createDepartment(String departmentName) throws NotUniqueException {
        for (EmployeeDepartment department : departments) {
            if (department.departmentName.equals(departmentName)) {
                throw new NotUniqueException("Department " + departmentName + " already exists!");
            }
        }
        EmployeeDepartment department = new EmployeeDepartment(departmentName);
        departments.add(department);
        return department;
    }

    public String toString() {
        return "Department: " + departmentName;
    }
}

