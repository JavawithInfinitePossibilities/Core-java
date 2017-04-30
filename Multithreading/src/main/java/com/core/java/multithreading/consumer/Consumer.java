/**
 * 
 */
package com.core.java.multithreading.consumer;

import java.util.concurrent.TimeUnit;

import com.core.java.multithreading.IModel.IModelBlockingQueue;

/**
 * @author Siddhant sahu
 *
 */
public class Consumer<T> implements Runnable {
	private IModelBlockingQueue<T> queue;

	public Consumer() {
		super();
	}

	public Consumer(IModelBlockingQueue<T> queue) {
		super();
		this.queue = queue;
	}

	@Override
	public void run() {
		while (true) {
			try {
				TimeUnit.SECONDS.sleep(2);
				System.out.println("Concumer get the value :" + queue.remove());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
