package com.company.Concurrency;

import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        // BankAccount.BankBranch bankBranch = new BankAccount.BankBranch();
        // bankBranch.start();
        // DataProcessor dataProcessor = new DataProcessor();
        // dataProcessor.processBoth();

        AlarmClock alarmClock = new AlarmClock();

        // multi producer setup
        for (int i = 1; i <= 10; i++) {
            final int index = i;
            Thread thread = new Thread(
                    () -> alarmClock.addAlarm(new Alarm(LocalDateTime.now().plusSeconds(10), "Alarm " + index)));
            thread.start();
        }

        // consumer setup
        try {
            while (true) {
                alarmClock.startAlarms();
            }
        } catch (Exception e) {
            Thread.currentThread().interrupt();
            e.printStackTrace();
        }

    }
}
