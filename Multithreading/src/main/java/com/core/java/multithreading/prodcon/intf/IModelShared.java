/**
 * 
 */
package com.core.java.multithreading.prodcon.intf;

/**
 * @author Siddhant sahu
 *
 */
public interface IModelShared<T> {
	void add(T value) throws InterruptedException;

	T remove() throws InterruptedException;
}
