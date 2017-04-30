/**
 * 
 */
package com.core.java.multithreading.customblockingqueue;

import com.core.java.multithreading.IModel.IModelBlockingQueue;

/**
 * @author Siddhant sahu
 *
 */
public class CustomBlockingQueueArray<T> implements IModelBlockingQueue<T> {
	private int size;
	private int counter;
	private Object[] bucket;

	public CustomBlockingQueueArray() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CustomBlockingQueueArray(int size) {
		super();
		this.size = size;
		this.bucket = new Object[this.size];
	}

	@Override
	public synchronized void add(T value) throws InterruptedException {
		if ((this.size - 1) == this.counter) {
			System.out.println("Waiting to remove atlease one element...");
			wait();
		}
		if (this.counter < 0) {
			this.counter++;
		}
		this.bucket[this.counter++] = value;
		System.out.println("Notifying all to add value...");
		this.notifyAll();
	}

	@Override
	public synchronized T remove() throws InterruptedException {
		if (this.counter < 0) {
			System.out.println("Waiting to add atlease one element...");
			wait();
		}
		System.out.println("Notifying all to remove value...");
		this.notifyAll();
		return (T) this.bucket[this.counter--];
	}

}
