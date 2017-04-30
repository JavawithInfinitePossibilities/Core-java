/**
 * 
 */
package com.core.java.multithreading.pool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Siddhant sahu
 *
 */
public class ObjectPoolBlockingQueue<T> {
	private BlockingQueue<T> lock;
	private AtomicInteger count;
	private Semaphore semaphore;

	public ObjectPoolBlockingQueue() {
		super();
	}

	public ObjectPoolBlockingQueue(int size) {
		super();
		lock = new ArrayBlockingQueue<>(size);
		this.count = new AtomicInteger(size);
		this.semaphore = new Semaphore(size);
	}

	public void createObjects() {
		for (int i = 0; i < this.count.get(); i++) {
			lock.add((T) new Object());
		}
	}

	public T getObject() throws InterruptedException {
		System.out.println(
				"Object has taken off from pool and now no of object in pool is :" + this.count.decrementAndGet());
		semaphore.acquire();
		return lock.take();
	}

	public void addObject(Object object) throws InterruptedException {
		System.out.println(
				"Object has returned back to pool and now no of object in pool is :" + this.count.getAndIncrement());
		semaphore.release();
		lock.put((T) object);
	}
}
