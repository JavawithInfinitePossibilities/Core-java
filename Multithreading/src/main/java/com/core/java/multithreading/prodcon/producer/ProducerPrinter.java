/**
 * 
 */
package com.core.java.multithreading.prodcon.producer;

import com.core.java.multithreading.prodcon.shared.Print2ArrayLock;

/**
 * @author Siddhant sahu
 *
 */
public class ProducerPrinter implements Runnable {
	private Print2ArrayLock producer;
	private int id;
	private int count;

	public ProducerPrinter() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProducerPrinter(Print2ArrayLock producer, int id) {
		super();
		this.producer = producer;
		this.id = id;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		while (true) {
			producer.printObject1();
		}
	}

}
