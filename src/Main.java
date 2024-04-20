import java.time.LocalDateTime;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        try {
            //Ustalamy działy i ich pracowników
            EmployeeDepartment itDepartment = EmployeeDepartment.createDepartment("IT");
            Employee developer1 = new Employee("Jan", "Kowalski", LocalDateTime.of(1990, 2, 10, 0, 0), itDepartment);
            Employee developer2 = new Employee("Anna", "Nowak", LocalDateTime.of(1985, 8, 20, 0, 0), itDepartment);

            EmployeeDepartment dzialSprzedazy = EmployeeDepartment.createDepartment("SALES");
            Employee sprzedawca1 = new Employee("Marek", "Jankowski", LocalDateTime.of(1995, 3, 12, 0, 0), dzialSprzedazy);
            Employee sprzedawca2 = new Employee("Katarzyna", "Nowicka", LocalDateTime.of(1994, 5, 12, 0, 0), dzialSprzedazy);

            //Ustalamy specjalistów i ich specjalizacje
            Specialist programista3 = new Specialist("Adam", "Murek", LocalDateTime.of(1998, 3, 12, 0, 0), itDepartment, "Java");
            Specialist sprzedawca3 = new Specialist("Tomasz", "Lewandowski", LocalDateTime.of(1991, 3, 12, 0, 0), dzialSprzedazy, "Sprzedaż");
            //Zbiór wszystkich pracowników
            System.out.println("Pracownicy:");
            for (Employee employee : Employee.getEmployees()) {
                System.out.println(employee);
            }
            //Wymiana specjalistów i ich specjalizacji
            System.out.println("Specjalizacją pracownika " + programista3.getSpecialist() + " z " + programista3.getDepartment() + " jest " + programista3.getSpecialization());
            System.out.println("Specjalizacja pracownika " + sprzedawca3.getSpecialist() + " z " + sprzedawca3.getDepartment() + " jest " + sprzedawca3.getSpecialization());
            //Ustalenie brygadzistów, brygad i ich pracowników
            Foreman foreman1 = new Foreman("Marcin", "Kowal", LocalDateTime.of(1982, 4, 12, 0, 0), itDepartment, "login123", "haslo123", "brygada1");
            Brigade brigade1 = new Brigade("brygada1", foreman1, new ArrayList<>());
            System.out.println("Brygada: " + brigade1.getBrigadesName() + " brygadzista: " + brigade1.getForeman().getInitial());

//            brigade1.setEmployees(programista1);
//            brigade1.setEmployees(programista2);
            brigade1.setEmployees(Arrays.asList(developer1, developer2));

            System.out.println("Pracownicy brygady: " + brigade1.getEmployees());
            //Ustalenie użytkowników i ich uprawnień
            User user1 = new User("Jan", "Kowalski", LocalDateTime.of(1989, 4, 12, 0, 0), itDepartment, "login123", "haslo123");
            System.out.println("Uzytkownik: " + user1.getInitial());

            Job job1 = new Job(TypeOfJob.General, 10, "Praca ogólna 1");
            Job job2 = new Job(TypeOfJob.Installation, 20, "Praca montażowa 1");
            Job job3 = new Job(TypeOfJob.Deinstallation, 15, "Praca demontażowa 1");

            Contract contract = new Contract("Jan Kowalski", brigade1, LocalDateTime.now());
            contract.addJob(job1);
            contract.addJob(job2);
            contract.addJob(job3);
            contract.addEmployeeToDepartment("Dział A", "Mariusz Nowak");
            contract.addEmployeeToDepartment("Dział B", "Anna Wiśniewska");

            job2.addJob(job1);
            job3.addJob(job2);

            Thread watek1 = new Thread(job1);
            Thread watek2 = new Thread(job2);
            Thread watek3 = new Thread(job3);

            watek1.start();
            watek2.start();
            watek3.start();

            // Wyświetlanie informacji o zleceniu
//            System.out.println(contract.toString());


        } catch (NotUniqueException e) {
            System.out.println(e.getMessage());
        }


    }
}
