package com.message.message_driven_application;

import org.junit.Test;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class TestProducerConsumer {
    @Test
    public void testProducerConsumerWithMultipleMessages() {
        BlockingQueue<String> queue = new LinkedBlockingQueue<>();
        List<String> messages = Arrays.asList("Message 1", "Message 2", "Message 3", "Message 4", "Message 5");

        Thread producerThread = new Thread(new Producer(queue, messages));
        Thread consumerThread = new Thread(new Consumer(queue));

        producerThread.start();
        consumerThread.start();

        try {
            producerThread.join();
            consumerThread.join();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }

    @Test
    public void testProducerConsumerWithSingleMessage() {
        BlockingQueue<String> queue = new LinkedBlockingQueue<>();
        List<String> messages = Arrays.asList("Single Message");

        Thread producerThread = new Thread(new Producer(queue, messages));
        Thread consumerThread = new Thread(new Consumer(queue));

        producerThread.start();
        consumerThread.start();

        try {
            producerThread.join();
            consumerThread.join();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }

    @Test
    public void testProducerConsumerWithNoMessages() {
        BlockingQueue<String> queue = new LinkedBlockingQueue<>();
        List<String> messages = Arrays.asList();

        Thread producerThread = new Thread(new Producer(queue, messages));
        Thread consumerThread = new Thread(new Consumer(queue));

        producerThread.start();
        consumerThread.start();

        try {
            producerThread.join();
            consumerThread.join();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
}

