import java.util.List;

class Brigade {
    private String brigadesName;
    private Foreman foreman;
    private List<Employee> employees;

    public Brigade(String brigadesName, Foreman foreman, List<Employee> employees) {
        this.brigadesName = brigadesName;
        this.foreman = foreman;
        this.employees = employees;
    }

    public String getBrigadesName() {
        return brigadesName;
    }

    public Foreman getForeman() {
        return foreman;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setBrigadesName(String brigadesName) {
        this.brigadesName = brigadesName;
    }

    public void setForeman(Foreman foreman) {
        this.foreman = foreman;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees.addAll(employees);
    }

    public void setEmployees(Employee employee) {
        this.employees.add(employee);
    }

    @Override
    public String toString() {
        return "Brigade{" +
                "name ='" + brigadesName + '\'' +
                ", foreman =" + foreman +
                ", employees =" + employees +
                '}';
    }


    public void deleteEmployeeFromBrigade(Employee employee) {
        employees.remove(employee);
    }
}
