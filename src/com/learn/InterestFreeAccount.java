package com.learn;

public class InterestFreeAccount extends Account{
    final double MinBalance;
    public InterestFreeAccount(int type, Id myId, double balance, String dateOfCreation, String alias) {
        super(type, myId, balance, dateOfCreation, alias);
        MinBalance = 1000;
    }

    @Override
    public void withdraw(int amount) {
        super.withdraw(amount);
    }

    @Override
    public void Deposit(int amount) {
        super.Deposit(amount);
    }
}
