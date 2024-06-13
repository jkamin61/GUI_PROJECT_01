import java.time.LocalDateTime;
import java.util.*;

class Employee implements Comparable<Employee> {
    private static List<Employee> employees = new ArrayList<>();
    private String name, surname;
    private EmployeeDepartment employeeDepartment;
    private LocalDateTime dateOfBirth;

    public Employee(String name, String surname, LocalDateTime dateOfBirth, EmployeeDepartment employeeDepartment) {
        this.name = name;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
        this.employeeDepartment = employeeDepartment;
        employees.add(this);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name ='" + name + '\'' +
                ", surname ='" + surname + '\'' +
                ", Employee department =" + employeeDepartment +
                ", Date of birth =" + dateOfBirth +
                '}';
    }

    public static List<Employee> getEmployees() {
        return employees;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public LocalDateTime getDateOfBirth() {
        return dateOfBirth;
    }

    public EmployeeDepartment getDepartment() {
        return employeeDepartment;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getInitial() {
        return (name.charAt(0) + "" + surname.charAt(0)).toUpperCase();
    }

    @Override
    public int compareTo(Employee p) {
        int compareTo = name.compareTo(p.getName());
        if (compareTo != 0) return compareTo;
        compareTo = surname.compareTo(p.getSurname());
        if (compareTo != 0) return compareTo;
        return dateOfBirth.compareTo(p.getDateOfBirth());
    }

    public void setEmployeeName(String newName) {
        this.name = newName;
    }

    public void setEmployeeSurname(String newSurname) {
        this.surname = newSurname;
    }

    public void setDateOfBirth(LocalDateTime dateTime) {
        this.dateOfBirth = dateTime;
    }

    public void setEmployeeDepartment(EmployeeDepartment department) {
        this.employeeDepartment = department;
    }
}
