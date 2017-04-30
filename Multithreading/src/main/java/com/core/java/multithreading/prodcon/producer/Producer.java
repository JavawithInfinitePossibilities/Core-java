/**
 * 
 */
package com.core.java.multithreading.prodcon.producer;

import java.util.Random;
import java.util.Scanner;

import com.core.java.multithreading.prodcon.intf.IModelShared;

/**
 * @author Siddhant sahu
 *
 */
public class Producer<T> implements Runnable {
	private IModelShared<T> queue;

	public Producer() {
	}

	public Producer(IModelShared<T> queue) {
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
