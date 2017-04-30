/**
 * 
 */
package com.core.java.multithreading.prodcon.producer;

import com.core.java.multithreading.prodcon.shared.PrintArrayLock;

/**
 * @author Siddhant sahu
 *
 */
public class PrintThread implements Runnable {
	private PrintArrayLock printArray;
	private int threadId;

	public PrintThread() {
		super();
	}

	public PrintThread(PrintArrayLock printArray, int threadId) {
		super();
		this.printArray = printArray;
		this.threadId = threadId;
	}

	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		while (true) {
			synchronized (printArray) {
				if (printArray.getObject().length == printArray.getCount().get()) {
					printArray.notifyAll();
					break;
				}
				if (printArray.getCount().get() % printArray.getThreadCount() == threadId) {
					printArray.printValue(printArray.getObject()[printArray.getCount().get()]);
					printArray.getCount().incrementAndGet();
					printArray.notifyAll();
				}
				try {
					printArray.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
