package models;

public abstract class Account {
    protected User owner;
    protected String accountNumber;
    protected int balance;

    public Account(User owner, String accountNumber) {
        this.owner = owner;
        this.accountNumber = accountNumber;
        this.balance = 0;
    }

    public User getOwner() {
        return owner;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public int getBalance() {
        return balance;
    }

    public void deposit(int amount) {
        balance += amount;
    }

    public void withdraw(int amount) {
        if (balance >= amount) {
            balance -= amount;
        } else {
            System.out.println("❌ 잔액이 부족합니다.");
        }
    }

    public void checkBalance() {
        System.out.println("📌 현재 잔액: " + balance + "원");
    }
}