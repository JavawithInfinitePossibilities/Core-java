/**
 * 
 */
package com.core.java.multithreading.prodcon.customthreadpool.task;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import com.core.java.multithreading.prodcon.customthreadpool.intf.ITask;

/**
 * @author Siddhant sahu
 *
 */
public class Task implements ITask {
	private BlockingQueue<Runnable> tasks;

	public Task() {
		super();
	}

	public Task(int taskSize) {
		super();
		tasks = new ArrayBlockingQueue<>(taskSize);
	}

	/* (non-Javadoc)
	 * @see com.core.java.multithreading.prodcon.customthreadpool.intf.ITask#enqueue(java.lang.Runnable)
	 */
	@Override
	public void enqueue(Runnable task) throws InterruptedException {
		this.tasks.put(task);
	}

	/* (non-Javadoc)
	 * @see com.core.java.multithreading.prodcon.customthreadpool.intf.ITask#dequeue()
	 */
	@Override
	public Runnable dequeue() throws InterruptedException {
		return this.tasks.take();
	}
}
