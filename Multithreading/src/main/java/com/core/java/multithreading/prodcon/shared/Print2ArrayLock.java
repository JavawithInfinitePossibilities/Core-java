/**
 * 
 */
package com.core.java.multithreading.prodcon.shared;

/**
 * @author Siddhant sahu
 *
 */
public class Print2ArrayLock {
	private int[] object1;
	private int[] object2;
	private int count1;
	private int count2;

	public Print2ArrayLock() {
		super();
	}

	public Print2ArrayLock(int[] object1, int[] object2) {
		super();
		this.object1 = object1;
		this.object2 = object2;
	}

	public synchronized void printObject1() {
		while (count1 < object1.length) {
			if (count1 < object1.length) {
				System.out.println("Object 1 value:" + object1[count1++]);
				this.notifyAll();
			} else {
				this.notifyAll();
				break;
			}
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public synchronized void printObject2() {
		while (count2 < object2.length) {
			if (count2 < object2.length) {
				System.out.println("Object 2 value:" + object2[count2++]);
				this.notifyAll();
			} else {
				this.notifyAll();
				break;
			}
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
