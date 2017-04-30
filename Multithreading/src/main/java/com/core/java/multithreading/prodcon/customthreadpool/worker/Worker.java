/**
 * 
 */
package com.core.java.multithreading.prodcon.customthreadpool.worker;

import java.util.concurrent.TimeUnit;

import com.core.java.multithreading.prodcon.customthreadpool.intf.ITask;

/**
 * @author Siddhant sahu
 *
 */
public class Worker implements Runnable {
	private ITask tasks;

	public Worker() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Worker(ITask task) {
		super();
		this.tasks = task;
	}

	@Override
	public void run() {
		while (true) {
			try {
				Runnable task = tasks.dequeue();
				task.run();
				TimeUnit.SECONDS.sleep(2);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
