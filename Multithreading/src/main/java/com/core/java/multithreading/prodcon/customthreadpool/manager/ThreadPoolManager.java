/**
 * 
 */
package com.core.java.multithreading.prodcon.customthreadpool.manager;

import com.core.java.multithreading.prodcon.customthreadpool.intf.ITask;
import com.core.java.multithreading.prodcon.customthreadpool.worker.Worker;

/**
 * @author Siddhant sahu
 *
 */
public class ThreadPoolManager {
	private ITask tasks;
	private int size;
	private boolean poolShutdownFlag;

	public ThreadPoolManager() {
		super();
	}

	public ThreadPoolManager(ITask tasks, int size) {
		super();
		this.tasks = tasks;
		this.size = size;
		init();
	}

	private void init() {
		for (int i = 0; i < size; i++) {
			Thread thread = new Thread(new Worker(tasks));
			thread.start();
		}
	}

	public void enqueueTask(Runnable task) {
		try {
			if (!this.poolShutdownFlag) {
				this.tasks.enqueue(task);
			} else {
				System.out.println("No more task execution...");
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void shutdown() {
		this.poolShutdownFlag = true;
	}
}
