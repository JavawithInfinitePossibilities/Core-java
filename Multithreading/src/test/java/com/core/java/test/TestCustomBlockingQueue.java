/**
 * 
 */
package com.core.java.test;

import java.util.concurrent.ArrayBlockingQueue;

import org.junit.Ignore;
import org.junit.Test;

import com.core.java.multithreading.customblockingqueue.BlockingQueueArray;
import com.core.java.multithreading.customblockingqueue.CustomBlockingQueueArray;
import com.core.java.multithreading.customblockingqueue.CustomBlockingQueueList;
import com.core.java.multithreading.prodcon.consumer.Consumer;
import com.core.java.multithreading.prodcon.producer.Producer;
import com.core.java.multithreading.prodcon.shared.SharedObjectContainer;

/**
 * @author Siddhant sahu
 *
 */
public class TestCustomBlockingQueue {

	public static void main(String[] args) {
		CustomBlockingQueueList<Integer> blockingQueue = new CustomBlockingQueueList<Integer>(5);
		Producer<Integer> producer = new Producer<>(blockingQueue);
		new Thread(producer).start();
		Consumer<Integer> consumer = new Consumer<>(blockingQueue);
		new Thread(consumer).start();
	}

	@Ignore
	public void testBlockingQueueList() {
		CustomBlockingQueueList<Integer> blockingQueue = new CustomBlockingQueueList<Integer>(5);
		Producer<Integer> producer = new Producer<>(blockingQueue);
		Thread pro = new Thread(producer);
		pro.start();
		Consumer<Integer> consumer = new Consumer<>(blockingQueue);
		Thread con = new Thread(consumer);
		con.start();
		try {
			pro.join();
			con.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Ignore
	public void testCustomBlockingQueueListArray() {
		CustomBlockingQueueArray<Integer> blockingQueue = new CustomBlockingQueueArray<Integer>(5);
		Producer<Integer> producer = new Producer<>(blockingQueue);
		Thread pro = new Thread(producer);
		pro.start();
		Consumer<Integer> consumer = new Consumer<>(blockingQueue);
		Thread con = new Thread(consumer);
		con.start();
		try {
			pro.join();
			con.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Ignore
	public void testBlockingQueueListArray() {
		ArrayBlockingQueue<Integer> bucket = new ArrayBlockingQueue<>(5);
		BlockingQueueArray<Integer> blockingQueue = new BlockingQueueArray<Integer>(bucket);
		Producer<Integer> producer = new Producer<>(blockingQueue);
		Thread pro = new Thread(producer);
		pro.start();
		Consumer<Integer> consumer = new Consumer<>(blockingQueue);
		Thread con = new Thread(consumer);
		con.start();
		try {
			pro.join();
			con.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testSharedObjectProdCon() {
		SharedObjectContainer<Integer> bucket = new SharedObjectContainer<>();
		Producer<Integer> producer = new Producer<>(bucket);
		Thread pro = new Thread(producer);
		pro.start();
		Consumer<Integer> consumer = new Consumer<>(bucket);
		Thread con = new Thread(consumer);
		con.start();
		try {
			pro.join();
			con.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
