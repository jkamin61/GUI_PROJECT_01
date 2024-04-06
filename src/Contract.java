import java.util.HashMap;
import java.util.Map;

class Contract implements Runnable {
    private static int numberOfContracts = 0;
    private int contractId;
    private Map<Integer, Job> jobs;
    private String foreman;
    private Map<String, String> employeesDepartment;

    public Contract(String foreman) {
        this.contractId = ++numberOfContracts;
        this.jobs = new HashMap<>();
        this.foreman = foreman;
        this.employeesDepartment = new HashMap<>();
    }

    public void addJob(Job job) {
        jobs.put(job.getJobId(), job);
    }

    public void addEmployeeToDepartment(String department, String employee) {
        employeesDepartment.put(department, employee);
    }

    public boolean didForemanTakePartInJob(String foreman) {
        return this.foreman.equals(foreman);
    }

    @Override
    public String toString() {
        return "Contract number: " + contractId +
                "\nJobs: " + jobs.keySet() +
                "\nForeman: " + foreman +
                "\nEmployee's Department: " + employeesDepartment.keySet();
    }

    @Override
    public void run() {
    }
}
