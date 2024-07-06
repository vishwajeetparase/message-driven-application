package com.message.message_driven_application;

import org.apache.log4j.Logger;
import java.util.concurrent.BlockingQueue;

/**
 * The Consumer class implements a consumer in a producer-consumer scenario.
 * It consumes messages from a queue.
 */
public class Consumer implements Runnable {
    private final BlockingQueue<String> queue;
    private static final Logger logger = Logger.getLogger(Consumer.class);

    /**
     * Constructor for the Consumer class.
     * @param queue The queue to consume messages from.
     */
    public Consumer(BlockingQueue<String> queue) {
        this.queue = queue;
    }

    /**
     * This method is called when the thread is started.
     * It consumes messages from the queue.
     */
    @Override
    public void run() {
        try {
            String message;
            while (!(message = queue.take()).equals("END")) {
                logger.info("Consumed: " + message);
                System.out.println("Consumed: " + message);
            }
        } catch (InterruptedException ex) {
            logger.error("Consumer was interrupted", ex);
            System.out.printf("Consumer was interrupted", ex);
        }
    }
}