import java.util.HashMap;
import java.util.Map;

class Job extends Thread {
    TypeOfJob typeOfJob;
    int jobsAmountOfTime;
    boolean isFinished;
    String description;
    private static int numberOfJobs = 0;
    int jobId;
    Map<Integer, Job> jobs;

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
        try {
            Thread.sleep(jobsAmountOfTime);
            isFinished = true;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void watchJob(Job job) {
        System.out.println("Starting job ID: " + job.getJobId());
        while (job.isAlive()) {
            System.out.println("Job ID: " + job.getJobId() + " is still running");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        if (job.isFinished) {
            System.out.println("Job ID: " + job.getJobId() + " has finished");
        }
    }

    @Override
    public String toString() {
        return "Job{" +
                "typeOfJob=" + typeOfJob +
                ", jobsAmountOfTime=" + jobsAmountOfTime +
                ", isFinished=" + isFinished +
                ", description='" + description + '\'' +
                ", jobId=" + jobId +
                ", jobs=" + jobs +
                '}';
    }
}
