/**
 * 
 */
package com.core.java.test;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

import org.junit.Test;

import com.core.java.multithreading.pool.ConnectionPoolSemaphore;
import com.core.java.multithreading.pool.ObjectPoolBlockingQueue;
import com.core.java.multithreading.pool.ObjectPoolManager;

/**
 * @author Siddhant sahu
 *
 */
public class TestCustomPool {
	public static void main(String[] args) {
		ObjectPoolBlockingQueue<Object> objectPool = new ObjectPoolBlockingQueue<>(5);
		objectPool.createObjects();
		for (int i = 0; i < 10; i++) {
			ObjectPoolManager<Object> manager = new ObjectPoolManager<>(objectPool);
			new Thread(manager).start();
		}
	}

	@Test
	public void testConnectionPoolSemaphore() {
		Semaphore semaphore = new Semaphore(5);
		ConnectionPoolSemaphore poolSemaphore = new ConnectionPoolSemaphore(semaphore, 1);
		for (int i = 0; i < 10; i++) {
			new Thread(() -> {
				poolSemaphore.getConnection();
			}).start();
		}
	}

	@Test
	public void testObjectPoolBlockingQueue() {
		ObjectPoolBlockingQueue objectPool = new ObjectPoolBlockingQueue(5);
		objectPool.createObjects();
		for (int i = 0; i < 10; i++) {
			new Thread(() -> {
				try {
					Object object = objectPool.getObject();
					TimeUnit.SECONDS.sleep(3);
					objectPool.addObject(object);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}).start();
		}
	}
}
