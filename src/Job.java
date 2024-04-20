import java.util.HashMap;
import java.util.Map;

class Job extends Thread {
    private TypeOfJob typeOfJob;
    private int jobsAmountOfTime;
    private boolean isFinished;
    private String description;
    private static int numberOfJobs = 0;
    private int jobId;
    private Map<Integer, Job> jobs;

    public Job(TypeOfJob typeOfJob, int jobsAmountOfTime, String description) {
        this.jobId = ++numberOfJobs;
        this.typeOfJob = typeOfJob;
        this.jobsAmountOfTime = jobsAmountOfTime;
        this.isFinished = false;
        this.description = description;
        this.jobs = new HashMap<>();
    }

    public Job getJobs(int jobId) {
        return jobs.get(jobId);
    }

    public void addJob(Job job) {
        jobs.put(job.getJobId(), job);
    }

    public int getJobId() {
        return jobId;
    }

    @Override
    public void run() {
    }

    @Override
    public String toString() {
        return "Job ID: " + jobId +
                "\nType of work: " + typeOfJob +
                "\nTime job has consumed: " + jobsAmountOfTime +
                "\nIs finished: " + isFinished +
                "\nDescription: " + description +
                "\nAwaiting jobs: " + jobs.keySet();
    }
}
