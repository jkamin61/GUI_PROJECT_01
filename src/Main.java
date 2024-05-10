import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        try {
//Utworzenie departamentu
            EmployeeDepartment itDepartment = EmployeeDepartment.createDepartment("IT");
//Utworzenie pracowników
            Employee juniorDeveloper = new Employee("John", "Taylor", LocalDateTime.of(1990, 2, 12, 0, 0), itDepartment);
            Employee.addEmployee(juniorDeveloper);
            Employee seniorDeveloper = new Employee("Mark", "Brahams", LocalDateTime.of(1985, 3, 10, 0, 0), itDepartment);
            Employee.addEmployee(seniorDeveloper);
            Employee itManager = new Employee("Zack", "Swift", LocalDateTime.of(1991, 5, 28, 0, 0), itDepartment);
            Employee.addEmployee(itManager);
//Wyświetlenie pracowników
            for (Employee employee :
                    Employee.getEmployees()) {
                System.out.println(employee);
            }
//Utworzenie specjalistów
            Specialist angularSpecialist = new Specialist(seniorDeveloper, "Angular.js");
            Specialist.addSpecialist(angularSpecialist);
//Wyświetlenie specjalistów
            for (Specialist specialist
                    : Specialist.specialists
            ) {
                System.out.println(specialist);
            }
//Utworzenie user
            User itAdmin = new User(itManager, "login", "password");
            System.out.println(itAdmin);
//Utworzenie brygadzisty
            Foreman itForeman = new Foreman(itAdmin);
//Utworzenie brygady
            Brigade frontend = new Brigade("Frontend", itForeman, Employee.getEmployees());
//Przypisanie brygadzisty do brygady
            itForeman.setBrigade(frontend);

            System.out.println(frontend);
//Utworzenie prac
            Job job1 = new Job(TypeOfJob.General, 1000, "Implementation of layout");
            Job job2 = new Job(TypeOfJob.Installation, 2000, "Installation of validation");
//Utworzenie kontraktu
            Contract loginPage = new Contract(itForeman, frontend, LocalDateTime.now());
//Dodanie prac do kontraktu
            loginPage.addJobs(job1);
            loginPage.addJobs(job2);
//Uruchomienie kontraktu
            loginPage.run();
//Uruchomienie prac
            job1.start();
            Job.watchJob(job1);
            job1.join();
//Uruchomienie prac
            job2.start();
            Job.watchJob(job2);
            job2.join();
//Dodanie pracowników do zlecenia
            loginPage.addEmployeeToDepartment(itDepartment, juniorDeveloper);
            loginPage.addEmployeeToDepartment(itDepartment, seniorDeveloper);

 //Zakończenie kontraktu
            loginPage.endContract(loginPage);
            Contract.getContractStatus(loginPage);

        } catch (NotUniqueException | InterruptedException e) {
            System.out.println(e.getMessage());
        }

    }
}
