/**
 * 
 */
package com.core.java.multithreading.IModel;

/**
 * @author Siddhant sahu
 *
 */
public interface IModelBlockingQueue<T> {
	void add(T value) throws InterruptedException;

	T remove() throws InterruptedException;
}
