/**
 * 
 */
package com.core.java.multithreading.prodcon.shared;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Siddhant sahu
 *
 */
public class PrintArrayLock {
	private int[] object;
	private AtomicInteger count;
	private int threadCount;

	public PrintArrayLock() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PrintArrayLock(int[] object, int count, int threadCount) {
		super();
		this.object = object;
		this.count = new AtomicInteger(count);
		this.threadCount = threadCount;
	}

	public int[] getObject() {
		return object;
	}

	public void setObject(int[] object) {
		this.object = object;
	}

	public AtomicInteger getCount() {
		return count;
	}

	public void setCount(AtomicInteger count) {
		this.count = count;
	}

	public int getThreadCount() {
		return threadCount;
	}

	public void setThreadCount(int threadCount) {
		this.threadCount = threadCount;
	}

	public void printValue(int value) {
		System.out.println(Thread.currentThread().getName() + " : " + value);
	}
}
