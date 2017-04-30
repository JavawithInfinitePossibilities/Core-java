/**
 * 
 */
package com.core.java.multithreading.prodcon.shared;

import com.core.java.multithreading.prodcon.intf.IModelShared;

/**
 * @author Siddhant sahu
 *
 */
public class SharedObjectContainer<T> implements IModelShared<T> {
	private boolean status;
	private T bucket;

	public synchronized void add(T prod) throws InterruptedException {
		if (!status) {
			//System.out.println("Produce value:" + prod);
			this.bucket = prod;
			this.status = true;
			this.notifyAll();
		}
		this.wait();
	}

	public synchronized T remove() throws InterruptedException {
		if (status) {
			this.status = false;
			this.notifyAll();
		}
		this.wait();
		return this.bucket;
	}

}
