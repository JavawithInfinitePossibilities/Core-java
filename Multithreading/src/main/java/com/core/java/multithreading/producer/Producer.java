/**
 * 
 */
package com.core.java.multithreading.producer;

import java.util.Random;
import java.util.Scanner;

import com.core.java.multithreading.IModel.IModelBlockingQueue;

/**
 * @author Siddhant sahu
 *
 */
public class Producer<T> implements Runnable {
	private IModelBlockingQueue<T> queue;

	public Producer() {
	}

	public Producer(IModelBlockingQueue<T> queue) {
		this.queue = queue;
	}

	public void run() {
		Scanner scanner = new Scanner(System.in);
		while (true) {
			System.out.println("Please enter the value...");
			T value = (T) scanner.nextLine();
			try {
				queue.add(value);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
