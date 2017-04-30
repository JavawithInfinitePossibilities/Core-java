/**
 * 
 */
package com.core.java.test;

import com.core.java.multithreading.prodcon.customthreadpool.manager.ThreadPoolManager;
import com.core.java.multithreading.prodcon.customthreadpool.task.Task;

/**
 * @author Siddhant sahu
 *
 */
public class TestCustomThreadPoolManager {
	static int count;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Main");
		Task task = new Task(5);
		ThreadPoolManager manager = new ThreadPoolManager(task, 5);
		for (int i = 0; i < 10; i++) {
			Runnable r1 = () -> {
				System.out.println("Runnable:" + ++count);
			};
			manager.enqueueTask(r1);
		}
		manager.shutdown();
		manager.enqueueTask(() -> {
			System.out.println("Runnable:" + ++count);
		});
		System.out.println("Main Ends...");
	}
}
