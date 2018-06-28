package com.shdosh.quartz.job;

import java.util.Date;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class HelloWorldJob implements Job{

	
	/**
	 * "0/10 * * * * ?  
	 */
	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		System.out.println("----hello world---" + new Date());
	}

}
