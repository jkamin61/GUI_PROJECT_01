import java.util.HashMap;
import java.util.Map;

class Job extends Thread {
    private static int numberOfJobs = 0;
    private int jobId;
    private TypeOfJob typeOfJob;
    private int jobsAmountOfTime;
    private boolean isFinished;
    private String description;
    private Map<Integer, Job> awaitingJobs;

    public Job(TypeOfJob typeOfJob, int jobsAmountOfTime, String description) {
        this.jobId = ++numberOfJobs;
        this.typeOfJob = typeOfJob;
        this.jobsAmountOfTime = jobsAmountOfTime;
        this.isFinished = false;
        this.description = description;
        this.awaitingJobs = new HashMap<>();
    }

    public static Job getJob(int numer) {
        return null;
    }

    public void addAwaitingJob(Job job) {
        awaitingJobs.put(job.getJobId(), job);
    }

    public int getJobId() {
        return jobId;
    }

    @Override
    public void run() {
        System.out.println(toString());
    }

    @Override
    public String toString() {
        return "Job ID: " + jobId +
                "\nType of work: " + typeOfJob +
                "\nTime job has consumed: " + jobsAmountOfTime +
                "\nIs finished: " + isFinished +
                "\nDescription: " + description +
                "\nAwaiting jobs: " + awaitingJobs.keySet();
    }
}
