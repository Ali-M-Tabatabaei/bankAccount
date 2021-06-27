package com.learn;

public class CurrentAccount extends Account{
    final double MinBalance;
    final double InterestRate;
    public CurrentAccount(int type, Id myId, double balance, String dateOfCreation, String alias) {
        super(type, myId, balance, dateOfCreation, alias);
        InterestRate = 10;
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
    public boolean AddInterest(){
        if(true/*if the time is right*/){
            setBalance(getBalance()+(getBalance()*InterestRate/100));
            return true;
        }
        else
            return  false;
    }

    @Override
    public String toString() {
        return "CurrentAccount{" +
                "MyId=" + MyId +
                ", MinBalance=" + MinBalance +
                ", InterestRate=" + InterestRate +
                '}';
    }
}
