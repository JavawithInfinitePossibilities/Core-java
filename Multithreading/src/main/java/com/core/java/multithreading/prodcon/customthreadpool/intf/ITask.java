/**
 * 
 */
package com.core.java.multithreading.prodcon.customthreadpool.intf;

/**
 * @author Siddhant sahu
 *
 */
public interface ITask {
	void enqueue(Runnable task) throws InterruptedException;

	Runnable dequeue() throws InterruptedException;
}
