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
import com.core.java.multithreading.prodcon.consumer.ConsumerPrinter;
import com.core.java.multithreading.prodcon.producer.PrintThread;
import com.core.java.multithreading.prodcon.producer.Producer;
import com.core.java.multithreading.prodcon.producer.ProducerPrinter;
import com.core.java.multithreading.prodcon.shared.Print2ArrayLock;
import com.core.java.multithreading.prodcon.shared.PrintArrayLock;
import com.core.java.multithreading.prodcon.shared.SharedObjectContainer;
import com.core.java.multithreading.prodcon.shared.WaitNotifyObjectContainer;

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

	@Ignore
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

	@Ignore
	public void testWaitNotifyObjectProdCon() {
		WaitNotifyObjectContainer<Integer> bucket = new WaitNotifyObjectContainer<>();
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

	@Ignore
	public void testPrint2ArrayObjectLockProdCon() {
		int[] object1 = { 1, 2, 3, 4 };
		int[] object2 = { 5, 6, 7, 8 };
		Print2ArrayLock bucket = new Print2ArrayLock(object1, object2);
		ProducerPrinter producer = new ProducerPrinter(bucket, 1);
		Thread pro = new Thread(producer);
		pro.start();
		ConsumerPrinter consumer = new ConsumerPrinter(bucket, 2);
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
	public void testPrintArrayObjectLockProdCon() {
		int[] object = { 1, 2, 3, 4, 5, 6, 7, 8 };
		PrintArrayLock bucket = new PrintArrayLock(object, 0, 3);
		PrintThread producer = new PrintThread(bucket, 0);
		PrintThread consumer = new PrintThread(bucket, 1);
		PrintThread printThread = new PrintThread(bucket, 2);
		Thread pro = new Thread(producer, "PrintThread:1");
		Thread con = new Thread(consumer, "PrintThread:2");
		Thread thread = new Thread(printThread, "PrintThread:3");
		pro.start();
		con.start();
		thread.start();
		try {
			pro.join();
			con.join();
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
