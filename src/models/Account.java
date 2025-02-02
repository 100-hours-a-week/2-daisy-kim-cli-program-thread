package models;

public class Account {
    private User owner;  // ✅ `private`으로 변경하여 직접 접근 방지
    protected String accountNumber;
    protected double balance;

    public Account(User owner, String accountNumber) {
        this.owner = owner;
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

    public void checkBalance() {
        System.out.println(owner.getName() + "님의 현재 잔액: " + balance + "원");
    }

    // ✅ 안전한 getter 추가 (BankService에서 사용)
    public User getOwner() {
        return owner;
    }
}