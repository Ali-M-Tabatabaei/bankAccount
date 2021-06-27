package com.learn;

public abstract class Account {
    protected int type;
    protected Id MyId;
    private double Balance;
    private String DateOfCreation;
    private String Alias;
    private Transaction[] transaction;

    public Account(int type, Id myId, double balance, String dateOfCreation, String alias) {
        this.type = type;
        MyId = myId;
        Balance = balance;
        DateOfCreation = dateOfCreation;
        Alias = alias;
    }

    public void setBalance(double balance) {
        Balance = balance;
    }

    public int getType() {
        return type;
    }

    public double getBalance() {
        return Balance;
    }

    public void setMyId(Id myId) { }

    public void withdraw(int amount){
        if(getBalance()-amount>0)
            setBalance(getBalance()-amount);
        else
            System.out.println("not enough balance");
    }
    public void Deposit(int amount){
        setBalance(getBalance()+amount);
    }

}
