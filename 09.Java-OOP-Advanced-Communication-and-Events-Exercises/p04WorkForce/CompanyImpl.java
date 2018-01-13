package p04WorkForce;

import java.util.ArrayList;
import java.util.List;

public class CompanyImpl implements Company {
    private List<Observer> jobs;
    private List<Observer> finishedJobs;

    public CompanyImpl() {
        this.jobs = new ArrayList<>();
        this.finishedJobs = new ArrayList<>();
    }

    @Override
    public void attach(Observer observer){
        jobs.add(observer);
    }

    @Override
    public void clearJobsDone(){
        for (Observer job : this.jobs) {
            if (job.getHoursOfWorkRequired() <= 0){
                finishedJobs.add(job);
                System.out.println(String.format("Job %s done!", job.getName()));
            }
        }
        for (Observer job : this.finishedJobs) {
            this.jobs.remove(job);
        }
        this.finishedJobs.clear();
    }

    @Override
    public void notifyAllObservers(){
        for (Observer observer : this.jobs) {
            observer.update();
        }
    }

    @Override
    public String status(){
        StringBuilder sb = new StringBuilder();
        for (Observer observer : this.jobs) {
            sb.append(String.format("Job: %s Hours Remaining: %d",
                    observer.getName(), observer.getHoursOfWorkRequired()))
            .append(System.lineSeparator());
        }
        return sb.toString().trim();
    }
}
