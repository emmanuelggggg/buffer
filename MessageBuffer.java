package Buffer;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class MessageBuffer {
    public static void main(String[] args) {
        final int bufferSize = 10;
        final BlockingQueue<String> buffer = new ArrayBlockingQueue<>(bufferSize);

        Thread producerThread = new Thread(() -> {
            try {
                for (int i = 1; i <= 10; i++) {
                    String message = "Mensaje " + i;
                    buffer.put(message);
                    System.out.println("Productor: " + message);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        Thread consumerThread = new Thread(() -> {
            try {
                for (int i = 1; i <= 10; i++) {
                    String message = buffer.take();
                    System.out.println("Consumidor: " + message);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        producerThread.start();
        consumerThread.start();
    }
}


