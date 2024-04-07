import java.util.Date;
import java.util.List;

public class Foreman extends User {
    private String brigade;
    List<Brigade> listOfBrigades;
    List<Contract> listOfContracts;

    public Foreman(String name, String surname, Date dateOfBirth, EmployeeDepartment department, String login, String password, String brigade) {
        super(name, surname, dateOfBirth, department, login, password);
        this.brigade = brigade;
    }

    public void addBrigade(Brigade brigade) {
        listOfBrigades.add(brigade);
    }

    public void addContract(Contract contract) {
        listOfContracts.add(contract);
    }

    public List<Brigade> getBrigade() {
        return listOfBrigades;
    }

    public List<Contract> getListOfContracts() {
        return listOfContracts;
    }
}
