import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

class Contract implements Runnable {

    ContractStatus contractStatus;
    private static int numberOfContracts = 0;
    private int contractId;
    Map<Integer, Job> jobs;
    String foreman;
    Map<String, String> employeesDepartment;
    Brigade brigade;
    boolean isBrigadeAssigned = false;
    LocalDateTime dateOfContractCreation;
    LocalDateTime dateOfStart;
    LocalDateTime dateOfEnd;
    boolean isStarted = false;
    boolean isFinished = false;

    public Contract(String foreman, Brigade brigade, LocalDateTime dateOfContractCreation) {
        this.contractId = ++numberOfContracts;
        this.jobs = new HashMap<>();
        this.foreman = foreman;
        this.employeesDepartment = new HashMap<>();
        this.brigade = brigade;
        this.isBrigadeAssigned = true;
        this.dateOfContractCreation = dateOfContractCreation;
        this.dateOfStart = LocalDateTime.now();
    }

    public Contract(boolean isPlanned) {
        this.contractStatus = isPlanned ? ContractStatus.PLANNED : ContractStatus.NOT_PLANNED;
    }

    public Contract(Brigade brigade, boolean isPlaned) {
        this.brigade = brigade;
        this.isBrigadeAssigned = true;
        this.contractStatus = isPlaned ? ContractStatus.PLANNED : ContractStatus.NOT_PLANNED;
    }

    public Contract(HashMap<Integer, Job> jobs, boolean isPlaned) {
        this.jobs = jobs;
        this.contractStatus = isPlaned ? ContractStatus.PLANNED : ContractStatus.NOT_PLANNED;
    }

    public Contract(HashMap<Integer, Job> jobs, boolean isPlanned, Brigade brigade) {
        this.jobs = jobs;
        this.contractStatus = isPlanned ? ContractStatus.PLANNED : ContractStatus.NOT_PLANNED;
        this.brigade = brigade;
        this.isBrigadeAssigned = true;
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

    public void endContract(Contract contract) {
        contract.isFinished = true;
        contract.dateOfEnd = LocalDateTime.now();
    }

    public static void getContractStatus(Contract contract) {
        if (contract.isFinished) {
            System.out.println("Contract has ended");
        } else if (contract.isStarted) {
            System.out.println("Contract is running");
        } else {
            System.out.println("Contract has not started yet");
        }
    }

    @Override
    public String toString() {
        return "Contract number: " + contractId +
                "\nJobs: " + jobs +
                "\nForeman: " + foreman +
                "\nEmployee's Department: " + employeesDepartment;
    }

    @Override
    public void run() {
        isStarted = true;
        System.out.println("Contract is running");
    }
}
