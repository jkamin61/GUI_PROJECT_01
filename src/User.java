
public class User extends Employee {
    private String login;
    private String password;
    private String initial;
    Employee employee;

    public User(Employee employee, String login, String password) {
        super(employee.getName(), employee.getSurname(), employee.getDateOfBirth(), employee.getDepartment());
        this.employee = employee;
        this.login = login;
        this.password = password;
        this.initial = (employee.getName().charAt(0) + "" + employee.getSurname().charAt(0)).toUpperCase();
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getInitial() {
        return initial;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", initial='" + initial + '\'' +
                ", employee=" + employee +
                '}';
    }
}
