import java.util.ArrayList;

class Specialist extends Employee {
    String specialization;
    Employee employee;
    static ArrayList<Specialist> specialists = new ArrayList<>();

    public Specialist(Employee employee, String specialization) {
        super(employee.getName(), employee.getSurname(), employee.getDateOfBirth(), employee.getDepartment());
        this.specialization = specialization;
        this.employee = employee;
    }

   public static void addSpecialist(Specialist specialist) {
        specialists.add(specialist);
    }

    @Override
    public String toString() {
        return "Specialist{" +
                "specialization='" + specialization + '\'' +
                ", employee=" + employee +
                '}';
    }
}
