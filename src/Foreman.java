import java.util.ArrayList;
import java.util.List;

public class Foreman extends User {
    List<Brigade> listOfBrigades = new ArrayList<>();
    List<Contract> listOfContracts = new ArrayList<>();
    User user;

    public Foreman(User user) {
        super(user.employee, user.getLogin(), user.getPassword());
    }

    public void setBrigade(Brigade brigade) {
        listOfBrigades.add(brigade);
    }

    public void addContract(Contract contract) {
        listOfContracts.add(contract);
    }

    public List<Brigade> getBrigades() {
        return listOfBrigades;
    }

    public List<Contract> getListOfContracts() {
        return listOfContracts;
    }

    @Override
    public String toString() {
        return "Foreman{" +
                "listOfBrigades=" + getBrigades() +
                ", listOfContracts=" + getListOfContracts() +
                ", user=" + user.getLogin() +
                '}';
    }
}
