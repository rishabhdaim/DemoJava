/**
 * 
 */
package tutorialpoints.spring;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Rishabh.Daim
 *
 */
public class XmlBasedSpringBatch {

	/**
	 * @param args
	 * @throws JobParametersInvalidException 
	 * @throws JobInstanceAlreadyCompleteException 
	 * @throws JobRestartException 
	 * @throws JobExecutionAlreadyRunningException 
	 */
	public static void main(String[] args) throws JobExecutionAlreadyRunningException, JobRestartException, JobInstanceAlreadyCompleteException, JobParametersInvalidException {

		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

		// Creating the job launcher
		JobLauncher jobLauncher = context.getBean("jobLauncher", JobLauncher.class);

		// Creating the job
		Job job = context.getBean("helloWorldJob", Job.class);

		// Executing the JOB
		JobExecution execution = jobLauncher.run(job, new JobParameters());
		System.out.println("Exit Status : " + execution.getStatus());
		
		System.out.println("-------------------------------");
		
		jobLauncher = context.getBean("jobLauncherDB", JobLauncher.class);

		// Creating the job
		job = context.getBean("helloWorldJobDB", Job.class);

		// Executing the JOB
		execution = jobLauncher.run(job, new JobParameters());
		System.out.println("Exit Status : " + execution.getStatus());
	}
}
