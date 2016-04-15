package golub.mco243.scheduler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class JobScheduler {
	/*
	 * Max amount of time each job runs for
	 */
	private static final int TIME_SLICE = 10;
	/*
	 * Amount of time it takes to switch jobs
	 */
	private static final int OVERHEAD = 10;
	
	private static final Random RAND = new Random();

	private List<Job> jobs;
	private Comparator<Job> comparator;
	
	private int numJobsCompleted = 0;
	private int totalTime = 0;

	public JobScheduler(List<Job>jobs, Comparator<Job> comparator) {
		this.jobs = jobs;
		this.comparator = comparator;
	}

	public void run() {
		
		Job lastJob = null;
		
		while (!jobs.isEmpty()) {
			Collections.sort(jobs, comparator);
			Job job = jobs.get(0);
			int actualTimeSlice = executeJob(job);
			
			
			totalTime += actualTimeSlice;
			
			if (job != lastJob){
				totalTime += OVERHEAD;
				lastJob = job;
			}
		}
	
	}
	 
	/**
	 * 
	 * @param job
	 * @return amount of time job took
	 */
	private int executeJob(Job job) {
		job.setState(JobState.Running);

		job.setLastRanAtTime(System.currentTimeMillis());
		
		int actualTimeSlice = computerActualTimeSlice(job);
		
		job.decrementTimeLeftToRun(actualTimeSlice);

		if (job.isFinished()) {
			jobs.remove(0);
			numJobsCompleted++;
		} else {
			job.setState(JobState.Ready);
		}
		return actualTimeSlice;
	}

	private int computerActualTimeSlice(Job job) {
		int timeLeftToRun = job.getTimeLeftToRun();
		int actualTimeSlice;
		if (job.getJobType() == JobType.IO){
			actualTimeSlice = Math.min(timeLeftToRun, RAND.nextInt(TIME_SLICE));
		}
		else{
		actualTimeSlice = Math.min(timeLeftToRun, TIME_SLICE);
		}
		return actualTimeSlice;
	}

	public static void main(String[] args) {

		List<Job> jobs = Arrays.asList(
				new Job("1", Priority.High, JobType.Computation, 100),
				new Job("2", Priority.Low, JobType.IO, 50),
				new Job("3", Priority.Medium, JobType.Computation, 36),
				new Job("4", Priority.High, JobType.Computation, 20),
				new Job("5", Priority.Low, JobType.IO, 100),
				new Job("6", Priority.Low, JobType.IO, 45),
				new Job("7", Priority.High, JobType.Computation, 70),
				new Job("8", Priority.Medium, JobType.Computation, 50),
				new Job("9", Priority.Low, JobType.IO, 30),
				new Job("10", Priority.Medium, JobType.Computation, 45)
				);
		JobScheduler scheduler = new JobScheduler(new ArrayList<Job>(jobs), new PriorityJobComparator());
		scheduler.run();
		System.out.println(String.format("numJobsCompleted=%d totalTime=%d", scheduler.getNumJobsCompleted(), scheduler.getTotalTime()));
	}

	public int getNumJobsCompleted() {
		return numJobsCompleted;
	}

	public int getTotalTime() {
		return totalTime;
	}

}
