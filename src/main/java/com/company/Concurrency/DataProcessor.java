package com.company.Concurrency;

public class DataProcessor {
    private final Object lock1 = new Object();
    private final Object lock2 = new Object();
    private int sharedData1 = 0;
    private String sharedData2 = "initial";

    public void updateData1() {
        synchronized (lock1) {
            sharedData1++;
        }
    }

    public void updateData2(String newValue) {
        synchronized (lock2) {
            this.sharedData2 = newValue;
        }
    }

    public void processBoth() {
        // (order matters for deadlock prevention)
        synchronized (lock1) {
            synchronized (lock2) {
                System.out.println("Processing: " + sharedData1 + ", " + sharedData2);
            }
        }
    }
}
