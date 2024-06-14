import java.util.ArrayList;
import java.util.List;

public class User extends Employee {
    private String login;
    private String password;
    public static String initial;
    Employee employee;
    private static List<User> users = new ArrayList<>();

    public User(Employee employee, String login, String password) {
        super(employee.getName(), employee.getSurname(), employee.getDateOfBirth(), employee.getDepartment());
        this.employee = employee;
        this.login = login;
        this.password = password;
        this.initial = (employee.getName().charAt(0) + "" + employee.getSurname().charAt(0)).toUpperCase();
        users.add(this);
    }

    public static List<User> getUsers() {
        return users;
    }

    public static User getUserByLogin(String login) {
        for (User user : users) {
            if (user.getLogin().equals(login)) {
                return user;
            }
        }
        return null;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String newPassword) {
        this.password = newPassword;
    }

    public String getInitial() {
        return initial;
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
