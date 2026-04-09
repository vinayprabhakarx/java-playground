package com.vinayprabhakarx.threads.runnable;

class MessageTask implements Runnable {
    private final String label;
    private final int repeatCount;

    MessageTask(String label, int repeatCount) {
        this.label = label;
        this.repeatCount = repeatCount;
    }

    @Override
    public void run() {
        for (int i = 1; i <= repeatCount; i++) {
            System.out.println(Thread.currentThread().getName() + " -> " + label + " step " + i);
            sleep(500);
        }
    }

    private void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println(Thread.currentThread().getName() + " interrupted.");
        }
    }
}

public class RunnableInterfaceExample {
    public static void main(String[] args) throws InterruptedException {
        Runnable task1 = new MessageTask("Downloading data", 4);
        Runnable task2 = new MessageTask("Processing records", 4);

        Thread thread1 = new Thread(task1, "Worker-1");
        Thread thread2 = new Thread(task2, "Worker-2");

        System.out.println("Starting Runnable interface example");

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println("Both threads finished");
    }
}
