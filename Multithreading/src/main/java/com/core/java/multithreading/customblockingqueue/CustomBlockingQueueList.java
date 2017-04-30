/**
 * 
 */
package com.core.java.multithreading.customblockingqueue;

import java.util.ArrayList;
import java.util.List;

import com.core.java.multithreading.prodcon.intf.IModelShared;

/**
 * @author Siddhant sahu
 *
 */
public class CustomBlockingQueueList<T> implements IModelShared<T> {
	private List<T> bucket;
	private int size;
	private int counter;

	public CustomBlockingQueueList() {
		this.size = 10;
		this.bucket = new ArrayList<>();
	}

	public CustomBlockingQueueList(int size) {
		this.size = size;
		this.bucket = new ArrayList<>();
	}

	public synchronized void add(T value) throws InterruptedException {
		if (this.size == this.bucket.size()) {
			System.out.println("Waiting to remove atlease one element...");
			wait();
		}
		this.bucket.add(value);
		System.out.println("Notifying all to add value...");
		this.notifyAll();
	}

	public synchronized T remove() throws InterruptedException {
		if (this.bucket.size() == 0) {
			System.out.println("Waiting to add atlease one element...");
			wait();
		}
		System.out.println("Notifying all to remove value...");
		this.notifyAll();
		return this.bucket.remove(0);
	}
}
