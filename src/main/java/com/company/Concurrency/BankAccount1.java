package com.company.Concurrency;

public class BankAccount1 {

    private static int balance = 100;
    private Object lock = 0; // unlocked

    public class BankActivity implements Runnable {

        @Override
        public void run() {
            // Infinite wait solution
            while (lock.equals(1)) {
                try {
                    wait(); // some thread is working on it;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            lock = 1;
            balance += 10;
            lock = 0;
            notifyAll();
        }
    }

    public static class BankBranch {
        public void start() {
            BankAccount bankAccount = new BankAccount();
            Thread[] thread = new Thread[100];

            for (int i = 0; i < 100; i++) {
                thread[i] = new Thread(bankAccount.new BankActivity());
            }

            for (int i = 0; i < 100; i++) {
                System.out.println(thread[i].getName());
                thread[i].start();
            }

            try {
                for (int i = 0; i < 100; i++) {
                    thread[i].join();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

}
