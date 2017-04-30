/**
 * 
 */
package com.core.java.multithreading.prodcon.consumer;

import com.core.java.multithreading.prodcon.shared.Print2ArrayLock;

/**
 * @author Siddhant sahu
 *
 */
public class ConsumerPrinter implements Runnable {
	private Print2ArrayLock consumer;
	private int id;
	private int count;

	public ConsumerPrinter() {
		super();
	}

	public ConsumerPrinter(Print2ArrayLock consumer, int id) {
		super();
		this.consumer = consumer;
		this.id = id;
	}

	@Override
	public void run() {
		while (true) {
			consumer.printObject2();
		}
	}

}
