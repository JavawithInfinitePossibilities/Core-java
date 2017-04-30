/**
 * 
 */
package com.core.java.multithreading.pool;

import java.util.concurrent.TimeUnit;

/**
 * @author Siddhant sahu
 *
 */
public class ObjectPoolManager<T> implements Runnable {
	private ObjectPoolBlockingQueue<T> bucket;

	public ObjectPoolManager(ObjectPoolBlockingQueue<T> bucket) {
		super();
		this.bucket = bucket;
	}

	public ObjectPoolManager() {
		super();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		try {
			Object object = bucket.getObject();
			TimeUnit.SECONDS.sleep(2);
			bucket.addObject(object);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
