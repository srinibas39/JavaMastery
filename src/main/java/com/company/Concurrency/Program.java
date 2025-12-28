package com.company.Concurrency;

public class Program {

    public class Weather implements Runnable {

        @Override
        public void run() {
            // API calls and all
            System.out.println("Weather is running");
        }

    }

    void startWeatherThread() {
        Thread thread = new Thread(new Weather());
        thread.start();
    }

    public static void main(String[] args) {
        Program program = new Program();
        program.startWeatherThread();
    }
}
