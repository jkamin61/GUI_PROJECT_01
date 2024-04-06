import java.util.Date;
class Specialist extends Employee {
    private String specialization;

    public Specialist(String name, String surname, Date dateOfBirth, EmployeeDepartment department, String specialization) {
        super(name, surname, dateOfBirth, department);
        this.specialization = specialization;
    }

    public String getSpecialist() {
        return getInitial();
    }

    public String getSpecialization() {
        return specialization;
    }
}
