import java.time.LocalDateTime;

public class User extends Employee {
    private String login;
    private String password;
    private String initial;

    public User(String name, String surname, LocalDateTime dateOfBirth, EmployeeDepartment department, String login, String password) {
        super(name, surname, dateOfBirth, department);
        this.login = login;
        this.password = password;
        this.initial = (name.charAt(0) + "" + surname.charAt(0)).toUpperCase();
    }

    public void setName(String name) {
        super.setName(name);
        this.initial = (name.charAt(0) + "" + this.getSurname().charAt(0)).toUpperCase();
    }

    public void setSurname(String surname) {
        super.setSurname(surname);
        this.initial = (this.getName().charAt(0) + "" + surname.charAt(0)).toUpperCase();
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

}
