import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

class Contract implements Runnable {

    ContractStatus contractStatus;
    private static int numberOfContracts = 0;
    private int contractId;
    Map<Integer, Job> jobs;
    Foreman foreman;
    Map<EmployeeDepartment, Employee> employeesDepartment;
    Brigade brigade;
    boolean isBrigadeAssigned = false;
    LocalDateTime dateOfContractCreation;
    LocalDateTime dateOfStart;
    LocalDateTime dateOfEnd;
    boolean isStarted = false;
    boolean isFinished = false;

    public Contract(Foreman foreman, Brigade brigade, LocalDateTime dateOfContractCreation) {
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

    public void addJobs(Job job) {
        System.out.println("Job ID: " + job.getJobId() + " has been added to contract");
        jobs.put(job.getJobId(), job);
    }

    public void getJobs(int jobId) {
        jobs.get(jobId);
    }

    public void addEmployeeToContract(EmployeeDepartment department, Employee employee) {
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
        return "Contract {" +
                ", contractId=" + contractId +
                ", jobs number=" + jobs +
                ", foreman='" + foreman.getName()+" "+foreman.getSurname() + '\'' +
                ", brigade=" + brigade +
                ", isBrigadeAssigned=" + isBrigadeAssigned +
                ", dateOfContractCreation=" + dateOfContractCreation +
                '}';
    }

    @Override
    public void run() {
        isStarted = true;
        System.out.println("Contract ID: " + contractId + " is running");
        System.out.println("Contract information: " + this);
    }
}
