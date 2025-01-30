package models;

public class AccountHolder extends User {
    private String accountNumber;
    private double balance;

    public AccountHolder(String name, String userId, String password, String accountNumber) {
        super(name, userId, password);
        this.accountNumber = accountNumber;
        this.balance = 0;
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println(amount + "원이 입금되었습니다. 현재 잔액: " + balance + "원");
    }

    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println(amount + "원이 출금되었습니다. 현재 잔액: " + balance + "원");
        } else {
            System.out.println("잔액이 부족합니다.");
        }
    }

    public void transfer(AccountHolder toAccount, double amount) {
        if (balance >= amount) {
            balance -= amount;
            toAccount.deposit(amount);
            System.out.println(amount + "원이 " + toAccount.getName() + "님께 송금되었습니다.");
        } else {
            System.out.println("잔액이 부족합니다.");
        }
    }

    public void checkBalance() {
        System.out.println("현재 잔액: " + balance + "원");
    }
}