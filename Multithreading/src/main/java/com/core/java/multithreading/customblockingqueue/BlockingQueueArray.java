/**
 * 
 */
package com.core.java.multithreading.customblockingqueue;

import java.util.concurrent.ArrayBlockingQueue;

import com.core.java.multithreading.IModel.IModelBlockingQueue;

/**
 * @author Siddhant sahu
 *
 */
public class BlockingQueueArray<T> implements IModelBlockingQueue<T> {
	private ArrayBlockingQueue<T> bucket;

	public BlockingQueueArray() {
		super();
	}

	public BlockingQueueArray(ArrayBlockingQueue<T> bucket) {
		super();
		this.bucket = bucket;
	}

	@Override
	public void add(T value) throws InterruptedException {
		this.bucket.put(value);
	}

	@Override
	public T remove() throws InterruptedException {
		return this.bucket.take();
	}

}
