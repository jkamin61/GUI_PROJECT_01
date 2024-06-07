import gui.MainFrame;

import java.awt.*;
import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        try {
            //initialize GUI
            EventQueue.invokeLater(() -> {
                try {
                    MainFrame window = new MainFrame();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });

            EmployeeDepartment itDepartment = EmployeeDepartment.createDepartment("IT");

            Employee juniorDeveloper = new Employee("John", "Taylor", LocalDateTime.of(1990, 2, 10, 0, 0), itDepartment);
            Employee.addEmployee(juniorDeveloper);
            EmployeeDepartment.addEmployeesToDepartment(juniorDeveloper);

            Employee seniorDeveloper = new Employee("Mark", "Zuckerberg", LocalDateTime.of(1987, 4, 6, 0, 0), itDepartment);
            Employee.addEmployee(seniorDeveloper);
            EmployeeDepartment.addEmployeesToDepartment(seniorDeveloper);

            Employee itManager = new Employee("Zack", "Swift", LocalDateTime.of(1992, 2, 6, 0, 0), itDepartment);
            Employee.addEmployee(itManager);
            EmployeeDepartment.addEmployeesToDepartment(itManager);

            for (Employee employee :
                    Employee.getEmployees()) {
                System.out.println(employee);
            }

            Specialist angularSpecialist = new Specialist(seniorDeveloper, "Angular.js");
            Specialist.addSpecialist(angularSpecialist);

            for (Specialist specialist :
                    Specialist.specialists) {
                System.out.println(specialist);
            }

            User itAdmin = new User(itManager, "login", "password");
            System.out.println(itAdmin);

            Foreman itForeman = new Foreman(itAdmin);
            Brigade frontend = new Brigade("Frontend", itForeman, Employee.getEmployees());
            itForeman.setBrigade(frontend);

            System.out.println(frontend);

            Job layout = new Job(TypeOfJob.General, 1500, "Implementation of layout");
            Job validation = new Job(TypeOfJob.Installation, 3000, "Installation of validation");

            Contract loginPage = new Contract(itForeman, frontend, LocalDateTime.now());

            loginPage.addJobs(layout);
            loginPage.addJobs(validation);

            loginPage.run();
            Contract.endContract(loginPage);
            Contract.getContractStatus(loginPage);


        } catch (NotUniqueException e) {
            System.out.println(e.getMessage());
        }

    }
}
