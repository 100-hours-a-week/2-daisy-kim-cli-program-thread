package models;

public class AccountHolder extends Account {

    public AccountHolder(User owner, String accountNumber) {
        super(owner, accountNumber);
    }

    public void transfer(AccountHolder toAccount, double amount) {
        if (balance >= amount) {
            balance -= amount;
            toAccount.deposit(amount);
            System.out.println(amount + "원이 " + toAccount.getOwner().getName() + "님께 송금되었습니다.");
        } else {
            System.out.println("잔액이 부족합니다.");
        }
    }
}