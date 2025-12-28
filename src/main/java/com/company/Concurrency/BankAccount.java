package com.company.Concurrency;

public class BankAccount {

  private int balance = 100;

  public class BankActivity implements Runnable {

    @Override
    public void run() {
      // API calls and all
      // race consition might happen here due to no lock
      synchronized (this) {
        balance = balance + 20;
      }
      System.out.println("BankActivity is running");
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

      System.out.println("Final balance is " + bankAccount.balance);
    }
  }
}
