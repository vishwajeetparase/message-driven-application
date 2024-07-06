package com.message.message_driven_application;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * The Main class starts the producer and consumer threads.
 */
public class Main {
    public static void main(String[] args) {
        BlockingQueue<String> queue = new LinkedBlockingQueue<>();

        List<String> messages = Arrays.asList("Test Message 1", "Test Message 2", "Test Message 3");

        Thread producerThread = new Thread(new Producer(queue, messages));

        Thread consumerThread = new Thread(new Consumer(queue));

        producerThread.start();
        consumerThread.start();
    }
}
