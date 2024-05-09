import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        try {
            EmployeeDepartment itDepartment = EmployeeDepartment.createDepartment("IT");

            Employee juniorDeveloper = new Employee("John", "Taylor", LocalDateTime.of(1990, 2, 12, 0, 0), itDepartment);
            Employee.addEmployee(juniorDeveloper);
            Employee seniorDeveloper = new Employee("Mark", "Brahams", LocalDateTime.of(1985, 3, 10, 0, 0), itDepartment);
            Employee.addEmployee(seniorDeveloper);
            Employee itManager = new Employee("Zack", "Swift", LocalDateTime.of(1991, 5, 28, 0, 0), itDepartment);
            Employee.addEmployee(itManager);

            for (Employee employee :
                    Employee.getEmployees()) {
                System.out.println(employee);
            }

            Specialist springSpecialist = new Specialist(seniorDeveloper, "Angular.js");
            Specialist.addSpecialist(springSpecialist);
            for (Specialist specialist
                    : Specialist.specialists
            ) {
                System.out.println(specialist);
            }
            User itAdmin = new User(itManager, "login", "password");
            System.out.println(itAdmin);
            Foreman itForeman = new Foreman(itAdmin);

            Brigade frontend = new Brigade("Frontend", itForeman, Employee.getEmployees());
            itForeman.setBrigade(frontend);

            System.out.println(frontend);

            Job job1 = new Job(TypeOfJob.General, 1000, "Implementation of layout");
            Job job2 = new Job(TypeOfJob.Installation, 2000, "Installation of validation");

            Contract loginPage = new Contract(itForeman, frontend, LocalDateTime.now());

            loginPage.addJobs(job1);
            loginPage.addJobs(job2);

            loginPage.run();

            job1.start();
            Job.watchJob(job1);
            job1.join();

            job2.start();
            Job.watchJob(job2);
            job2.join();

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
