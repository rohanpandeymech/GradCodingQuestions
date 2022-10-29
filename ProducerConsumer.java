package src.amzao;

import java.util.*;

public class ProducerConsumer {
    static final int BUFFER_SIZE = 100; // constant for the buffer size
    static Producer producer = new Producer(); // instantiate a new Producer thread
    static Consumer consumer = new Consumer(); // instantiate a new Consumer thread
    static MonitorClassImpl monitor = new MonitorClassImpl(); // instantiate a new OurMonitor

    public static void main(String args[]) {
        producer.start(); // start the Producer thread
        consumer.start(); // start the Consumer thread
    }

    static class Producer extends Thread {
        public void run() { // run method with the thread code
            int producerItem;
            for(int i=0; i < 5; i++) { // producer loop: Run for 5 times
                producerItem = produceItem();
                monitor.insert(producerItem);
            } // end of while
        } // run()

        private int produceItem() {
            Random randomValue = new Random();
            int num = randomValue.nextInt(100)+1;
            System.out.println("Producer produced:" + num + " ");
            return num;
        } // produceItem()

    } // class Producer

    static class Consumer extends Thread {
        public void run() { // run method with the thread code
            int consumerItem;
            while (true) { // consumer loop : infinite loop
                consumerItem = monitor.remove();
                consumeItem(consumerItem);
            } // end of while
        } // run()

        private void consumeItem(int item) {
            System.out.println("Consumer consumed:" + item + " ");
        } // consumeItem()
    } // class Consumer

    static class MonitorClassImpl { // Monitor definition
        // shared data of the Monitor
        private int monitorBuffer[] = new int [BUFFER_SIZE];
        private int currentCount = 0;
        private int lo = 0, hi = 0;

        // Monitor operations
        // 1. insert() operator
        public synchronized void insert(int val) {
            if (currentCount == BUFFER_SIZE) gotoSleep(); // if the buffer is full, go to sleep
            monitorBuffer[hi] = val; // insert an item into the buffer
            hi = (hi+1) % BUFFER_SIZE; // slot to place next item in
            currentCount = currentCount + 1;
            if (currentCount ==1) notify(); // if consumer was sleeping, wake it up
        } // insert()

        // 2. remove() operator
        public synchronized int remove() {
            int val;
            if (currentCount ==0) gotoSleep(); // if the buffer is empty, go to sleep
            val = monitorBuffer[lo]; // fetch an item from the buffer
            lo = (lo+1) % BUFFER_SIZE; // slot to fetch next item from
            currentCount = currentCount - 1;
            if (currentCount == BUFFER_SIZE -1) notify(); // if producer was sleeping, wake it up
            return val;
        } // remove()

        private void gotoSleep() {
            try {
                wait(); // wait() can be interrupted
            } catch(InterruptedException exc) {
                System.out.println("Interrupt occurred!");
            };
        } // gotoSleep()
    } // class OurMonitor
} // class ProducerCons

