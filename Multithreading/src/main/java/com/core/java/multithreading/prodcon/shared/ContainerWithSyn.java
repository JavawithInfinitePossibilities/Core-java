/**
 * 
 */
package com.core.java.multithreading.prodcon.shared;

/**
 * @author Siddhant sahu
 *
 */
public class ContainerWithSyn {
	private int contain;
	private boolean status;

	public ContainerWithSyn() {
		super();
		this.status = true;
	}

	public synchronized void producer(int value) {
		while (!this.status) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Producer produce value:" + value);
		this.contain = value;
		this.status = false;
		this.notifyAll();
	}

	public synchronized void Consumer() {
		while (this.status) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Consumer consume value:" + this.contain);
		this.status = true;
		this.notifyAll();
	}
}
