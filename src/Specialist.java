import java.time.LocalDateTime;;

class Specialist extends Employee {
    String specialization;

    public Specialist(String name, String surname, LocalDateTime dateOfBirth, EmployeeDepartment department, String specialization) {
        super(name, surname, dateOfBirth, department);
        this.specialization = specialization;
    }

    public String getSpecialist() {
        return getInitial();
    }

    public String getSpecialization() {
        return specialization;
    }

    @Override
    public String toString() {
        return "Specialist{" +
                "specialization='" + specialization + '\'' +
                '}';
    }
}
