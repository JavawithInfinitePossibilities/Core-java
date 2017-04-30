/**
 * 
 */
package com.core.java.multithreading.prodcon.shared;

import com.core.java.multithreading.prodcon.intf.IModelShared;

/**
 * @author Siddhant sahu
 *
 */
public class WaitNotifyObjectContainer<T> implements IModelShared<T> {
	private boolean status;
	private T bucket;

	@Override
	public synchronized void add(T value) throws InterruptedException {
		if (status) {
			this.wait();
		}
		this.bucket = value;
		this.status = true;
		this.notifyAll();
	}

	@Override
	public synchronized T remove() throws InterruptedException {
		if (!status) {
			this.wait();
		}
		this.status = false;
		this.notifyAll();
		return this.bucket;
	}

}
