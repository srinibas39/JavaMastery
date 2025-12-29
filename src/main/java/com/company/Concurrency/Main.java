package com.company.Concurrency;

public class Main {
    public static void main(String[] args) {
        // BankAccount.BankBranch bankBranch = new BankAccount.BankBranch();
        // bankBranch.start();
        DataProcessor dataProcessor = new DataProcessor();
        dataProcessor.processBoth();

    }
}
