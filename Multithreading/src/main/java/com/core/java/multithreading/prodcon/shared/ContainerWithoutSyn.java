/**
 * 
 */
package com.core.java.multithreading.prodcon.shared;

/**
 * @author Siddhant sahu
 *
 */
public class ContainerWithoutSyn {
	private int contain;
	private volatile boolean status;

	public ContainerWithoutSyn() {
		super();
		this.status = true;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public void producer(int value) {
		System.out.println("Producer produce value:" + value);
		this.contain = value;
	}

	public void consume() {
		System.out.println("Consumer consume:" + this.contain);
	}
}
