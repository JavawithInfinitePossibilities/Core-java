/**
 * 
 */
package com.core.java.multithreading.prodcon.consumer;

import java.util.concurrent.TimeUnit;

import com.core.java.multithreading.prodcon.intf.IModelShared;

/**
 * @author Siddhant sahu
 *
 */
public class Consumer<T> implements Runnable {
	private IModelShared<T> queue;

	public Consumer() {
		super();
	}

	public Consumer(IModelShared<T> queue) {
		super();
		this.queue = queue;
	}

	@Override
	public void run() {
		while (true) {
			try {
				System.out.println("Concumer get the value :" + queue.remove());
				TimeUnit.SECONDS.sleep(2);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
