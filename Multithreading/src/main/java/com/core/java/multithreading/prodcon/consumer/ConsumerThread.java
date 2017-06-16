/**
 * 
 */
package com.core.java.multithreading.prodcon.consumer;

import com.core.java.multithreading.prodcon.shared.ContainerWithoutSyn;

/**
 * @author Siddhant sahu
 *
 */
public class ConsumerThread implements Runnable {
	private ContainerWithoutSyn container;

	public ConsumerThread(ContainerWithoutSyn container) {
		super();
		this.container = container;
	}

	@Override
	public void run() {
		while (true) {
			if (!container.isStatus()) {
				container.consume();
				container.setStatus(true);
			}
		}
	}

	/*private ContainerWithSyn container;
	
	public ConsumerThread(ContainerWithSyn container) {
		super();
		this.container = container;
	}
	
	@Override
	public void run() {
		while (true) {
			container.Consumer();
		}
	}*/
}
