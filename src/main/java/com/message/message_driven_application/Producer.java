package com.message.message_driven_application;
import org.apache.log4j.Logger;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;


/**
 * The Producer class implements a producer in a producer-consumer scenario.
 * It produces messages and puts them into a queue.
 */
public class Producer implements Runnable {
    private final BlockingQueue<String> queue;
    private final List<String> messages;
    private static final Logger logger = Logger.getLogger(Producer.class);
    public static AtomicInteger totalMessagesProduced = new AtomicInteger(0);

    /**
     * Constructor for the Producer class.
     * @param queue The queue to put messages into.
     * @param messages The messages to be produced.
     */
    public Producer(BlockingQueue<String> queue, List<String> messages) {
        this.queue = queue;
        this.messages = messages;
    }

    /**
     * This method is called when the thread is started.
     * It produces messages and puts them into the queue.
     */
    @Override
    public void run() {
        try {
            for (String message : messages) {
                queue.put(message);
                logger.info("Produced: " + message);
                System.out.println("Produced: " + message);
                totalMessagesProduced.incrementAndGet();
            }
            queue.put("END");
            logger.info("Total messages produced: " + totalMessagesProduced);
            System.out.println("Total messages produced: " + totalMessagesProduced);
        } catch (InterruptedException ex) {
            logger.error("Producer was interrupted", ex);
            System.out.printf("Producer was interrupted", ex);
        }
    }
}
