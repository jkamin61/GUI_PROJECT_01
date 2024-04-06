import java.util.Date;

public class Foreman extends User {
    private String brigade;

    public Foreman(String name, String surname, Date dateOfBirth, EmployeeDepartment department, String login, String password, String brigade) {
        super(name, surname, dateOfBirth, department, login, password);
        this.brigade = brigade;
    }

    public String getBrigade() {
        return brigade;
    }

    public void setBrigade(String brigade) {
        this.brigade = brigade;
    }
}
