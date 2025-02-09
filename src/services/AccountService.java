package services;
import models.Account;
import models.AccountHolder;
import models.PremiumAccount;
import models.User;

public class AccountService {
    private Account account;

    public AccountService(Account account) {
        this.account = account;
    }

    public void deposit(int amount) {
        account.deposit(amount);
        System.out.println("💰 " + amount + "원이 입금되었습니다.");
        checkAndUpgradeAccount();
    }

    public void withdraw(int amount) {
        if (account.getBalance() >= amount) {
            account.withdraw(amount);
            System.out.println("💸 " + amount + "원이 출금되었습니다.");
            System.out.println("📌 현재 잔액: " + account.getBalance() + "원");
        } else {
            System.out.println("❌ 잔액이 부족합니다. 현재 잔액: " + account.getBalance() + "원");
        }
    }

    public void checkBalance() {
        account.checkBalance();
    }

    public void sendToFriends(String friendId, int amount) {
        if (account.getBalance() < amount) {
            System.out.println("❌ 잔액이 부족하여 송금할 수 없습니다.");
            return;
        }

        account.withdraw(amount);
        System.out.println("💸 " + amount + "원이 '" + friendId + "'님에게 송금되었습니다.");
        System.out.println("📌 현재 잔액: " + account.getBalance() + "원");
    }

    public void viewPremiumBenefits() {
        if (account instanceof PremiumAccount) {
            ((PremiumAccount) account).showBenefits();
        } else {
            System.out.println("❌ 일반 계좌는 프리미엄 혜택을 볼 수 없습니다.");
        }
    }

    private void checkAndUpgradeAccount() {
        if (!(account instanceof PremiumAccount) && account.getBalance() >= 1000000) {
            User owner = account.getOwner();
            account = new PremiumAccount(owner, account.getAccountNumber());
            System.out.println("🎉 축하합니다! 프리미엄 계좌로 자동 전환되었습니다.");
        }
    }
}