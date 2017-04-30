/**
 * 
 */
package com.core.java.test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.junit.Ignore;
import org.junit.Test;

import com.core.java.multithreading.synchronization.CountdownLatchSynch;
import com.core.java.multithreading.synchronization.CyclicBarrierSynch;

/**
 * @author Siddhant sahu
 *
 */
public class TestThreadSynchronization {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		CountDownLatch latch = new CountDownLatch(3);
		for (int i = 0; i < 10; i++) {
			CountdownLatchSynch countdownLatchSynch = new CountdownLatchSynch(latch, i);
			new Thread(countdownLatchSynch).start();
		}
	}

	@Ignore
	public void testCountdownletch() {
		ExecutorService service = Executors.newFixedThreadPool(5);
		CountDownLatch latch = new CountDownLatch(3);
		for (int i = 0; i < 10; i++) {
			CountdownLatchSynch countdownLatchSynch = new CountdownLatchSynch(latch, i);
			service.execute(countdownLatchSynch);
		}
		service.shutdown();
		try {
			service.awaitTermination(1, TimeUnit.DAYS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testCyclicBarrier() {
		ExecutorService service = Executors.newFixedThreadPool(5);
		CyclicBarrier barrier = new CyclicBarrier(3);
		for (int i = 0; i < 10; i++) {
			CyclicBarrierSynch barrierSynch = new CyclicBarrierSynch(barrier, i);
			service.submit(barrierSynch);
		}
		service.shutdown();
		try {
			service.awaitTermination(1, TimeUnit.DAYS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
