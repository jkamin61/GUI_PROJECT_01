import java.util.*;

public class Main {
    public static void main(String[] args) {

        try {
            //Ustalamy działy i ich pracowników
            EmployeeDepartment dzialProgramistow = EmployeeDepartment.createDepartment("IT");
            Employee programista1 = new Employee("Jan", "Kowalski", new Date(90, 5, 10), dzialProgramistow);
            Employee programista2 = new Employee("Anna", "Nowak", new Date(85, 8, 20), dzialProgramistow);


            EmployeeDepartment dzialSprzedazy = EmployeeDepartment.createDepartment("SALES");
            Employee sprzedawca1 = new Employee("Marek", "Jankowski", new Date(88, 2, 15), dzialSprzedazy);
            Employee sprzedawca2 = new Employee("Katarzyna", "Nowicka", new Date(92, 11, 1), dzialSprzedazy);

            //Ustalamy specjalistów i ich specjalizacje
            Specialist programista3 = new Specialist("Adam", "Murek", new Date(), dzialProgramistow, "Java");
            Specialist sprzedawca3 = new Specialist("Tomasz", "Lewandowski", new Date(), dzialSprzedazy, "e-Commerce");
            //Zbiór wszystkich pracowników
            System.out.println("Pracownicy:");
            for (Employee employee : Employee.getEmployees()) {
                System.out.println(employee);
            }
            //Wymiana specjalistów i ich specjalizacji
            System.out.println("Specjalizacją pracownika " + programista3.getSpecialist() + " z " + programista3.getDepartment() + " jest " + programista3.getSpecialization());
            System.out.println("Specjalizacja pracownika " + sprzedawca3.getSpecialist() + " z " + sprzedawca3.getDepartment() + " jest " + sprzedawca3.getSpecialization());
            //Ustalenie brygadzistów, brygad i ich pracowników
            Foreman foreman1 = new Foreman("Marcin", "Kowal", new Date(90, 5, 10), dzialProgramistow, "login123", "haslo123", "brygada1");
            Brigade brigade1 = new Brigade("brygada1", foreman1, new ArrayList<>());
            System.out.println("Brygada: " + brigade1.getBrigadesName() + " brygadzista: " + brigade1.getForeman().getInitial());

            brigade1.addEmployeesToBrigade(programista1);
            brigade1.addEmployeesToBrigade(programista2);
            System.out.println("Pracownicy brygady: " + brigade1.getEmployees());
            //Ustalenie użytkowników i ich uprawnień
            User user1 = new User("Jan", "Kowalski", new Date(90, 5, 10), dzialProgramistow, "login123", "haslo123");
            System.out.println("Uzytkownik: " + user1.getInitial());

            Job job1 = new Job(TypeOfJob.General, 10, "Praca ogólna 1");
            Job job2 = new Job(TypeOfJob.Installation, 20, "Praca montażowa 1");
            Job job3 = new Job(TypeOfJob.Deinstallation, 15, "Praca demontażowa 1");

            Contract contract = new Contract("Jan Kowalski");
            contract.addJob(job1);
            contract.addJob(job2);
            contract.addJob(job3);
            contract.addEmployeeToDepartment("Dział A", "Mariusz Nowak");
            contract.addEmployeeToDepartment("Dział B", "Anna Wiśniewska");

            job2.addAwaitingJob(job1);
            job3.addAwaitingJob(job2);

            Thread watek1 = new Thread(job1);
            Thread watek2 = new Thread(job2);
            Thread watek3 = new Thread(job3);

            watek1.start();
            watek2.start();
            watek3.start();

            // Wyświetlanie informacji o zleceniu
            System.out.println(contract.toString());


        } catch (NotUniqueException e) {
            System.out.println(e.getMessage());
        }


    }
}
