/**
 * 
 */
package com.core.java.multithreading.synchronization;

import java.util.concurrent.CountDownLatch;

/**
 * @author Siddhant sahu
 *
 */
public class CountdownLatchSynch implements Runnable {
	private CountDownLatch latch;
	private int id;

	public CountdownLatchSynch(CountDownLatch latch, int id) {
		super();
		this.latch = latch;
		this.id = id;
	}

	public CountdownLatchSynch() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void run() {
		System.out.println("Thread " + id + " started...");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Thread " + id + " completed...");
		latch.countDown();
	}

}
