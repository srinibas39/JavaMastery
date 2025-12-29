package com.company.Concurrency;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

public class AlarmClock {

    /*
     * Requirement: Multiple client will be able to set Alarm
     * [c1,c2,3,c4 , c5]
     * Capacity is 5
     * shared Resources --> List of Alarms
     * 
     */

    List<Alarm> alarms = new ArrayList<>();
    // private final int capacity = 5;

    private Semaphore vacancy = new Semaphore(5);
    private Semaphore filled = new Semaphore(0);

    // producer
    public void addAlarm(Alarm alarm) {
        // synchronized (this) {
        // while (alarms.size() == capacity) {
        // try {
        // wait();
        // } catch (InterruptedException e) {
        // Thread.currentThread().interrupt();
        // e.printStackTrace();
        // }
        // }

        try {
            vacancy.acquire(); // 5 - 1
            // if non-negative , then proceed else wait
            if (alarm.getDateTime().isAfter(LocalDateTime.now())) {
                alarms.add(alarm);
                filled.release();
                // notifyAll();
            }
            // 0 + 1
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    // consumer
    public void startAlarms() {
        // synchronized (this) {
        // while (alarms.isEmpty()) {
        // try {
        // wait();
        // } catch (InterruptedException e) {
        // Thread.currentThread().interrupt();
        // e.printStackTrace();
        // }
        // }
        // }

        try {
            filled.acquire(); // 5 - 1
            Alarm alarm = alarms.remove(alarms.size() - 1);
            System.out.println("Alarm triggered " + alarm.getReminder());
            vacancy.release(); // 0 + 1
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}