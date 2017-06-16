/**
 * 
 */
package com.core.java.test;

import com.core.java.multithreading.prodcon.consumer.ConsumerThread;
import com.core.java.multithreading.prodcon.producer.ProducerThread;
import com.core.java.multithreading.prodcon.shared.ContainerWithoutSyn;

/**
 * @author Siddhant sahu
 *
 */
public class TestProducerConsumer {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ContainerWithoutSyn syn = new ContainerWithoutSyn();
		ProducerThread producerThread = new ProducerThread(syn);
		ConsumerThread consumerThread = new ConsumerThread(syn);
		Thread producer = new Thread(producerThread);
		Thread consumer = new Thread(consumerThread);
		producer.start();
		consumer.start();
	}

}
