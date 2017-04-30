/**
 * 
 */
package com.core.java.multithreading.pool;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Siddhant sahu
 *
 */
public class ConnectionPoolSemaphore {
	private Semaphore lock;
	private AtomicInteger count;

	public ConnectionPoolSemaphore() {
		super();
	}

	public ConnectionPoolSemaphore(Semaphore lock, int count) {
		super();
		this.lock = lock;
		this.count = new AtomicInteger(count);
	}

	private void connection() {
		System.out.println("Acquiring the connection no:" + this.count.getAndIncrement());
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Releasing the connection no:" + this.count.decrementAndGet());
	}

	public void getConnection() {
		try {
			lock.acquire();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		connection();
		lock.release();
	}
}
