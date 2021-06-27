package com.learn;

public class Transaction {
    private Account MyAccount;
    private Account Target;
    private double amount;
    private String Date;

    public Transaction(Account myAccount, Account target, double amount, String date) {
        MyAccount = myAccount;
        Target = target;
        this.amount = amount;
        Date = date;
    }
}
