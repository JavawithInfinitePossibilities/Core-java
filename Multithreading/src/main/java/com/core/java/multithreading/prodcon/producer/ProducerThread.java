/**
 * 
 */
package com.core.java.multithreading.prodcon.producer;

import java.util.Random;

import com.core.java.multithreading.prodcon.shared.ContainerWithoutSyn;

/**
 * @author Siddhant sahu
 *
 */
public class ProducerThread implements Runnable {
	private ContainerWithoutSyn container;

	public ProducerThread(ContainerWithoutSyn container) {
		super();
		this.container = container;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		Random random = new Random();
		while (true) {
			if (container.isStatus()) {
				container.producer(random.nextInt(10));
				container.setStatus(false);
			}
		}
	}

	/*private ContainerWithSyn container;
	
	public ProducerThread(ContainerWithSyn container) {
		super();
		this.container = container;
	}
	
	
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Runnable#run()
	 
	@Override
	public void run() {
		Random random = new Random();
		while (true) {
			container.producer(random.nextInt(10));
		}
	}*/
}
