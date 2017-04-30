/**
 * 
 */
package com.core.java.multithreading.synchronization;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author Siddhant sahu
 *
 */
public class CyclicBarrierSynch implements Runnable {
	private CyclicBarrier barrier;
	private int id;

	public CyclicBarrierSynch() {
		super();
	}

	public CyclicBarrierSynch(CyclicBarrier barrier, int id) {
		super();
		this.barrier = barrier;
		this.id = id;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		System.out.println("Thread " + id + " started...");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Thread " + id + " completed...");
		try {
			barrier.await();
			System.out.println("Thread " + id + " barrier broken...");
		} catch (InterruptedException | BrokenBarrierException e) {
			e.printStackTrace();
		}
	}

}
