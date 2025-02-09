package services;
import models.AccountHolder;

public class BankService {
    private UserService userService;
    private AccountService accountService;
    private AccountHolder account;

    public BankService() {
        this.userService = new UserService();
        this.account = new AccountHolder(userService.getUser(), "010-123-456");
        this.accountService = new AccountService(account);
    }

    public boolean isLoggedIn() {
        return userService.isLoggedIn();
    }

    public void login(String userId, String password) {
        userService.login(userId, password);
    }

    public void deposit(int amount) {
        if (!isLoggedIn()) {
            System.out.println("🔑 로그인 후 이용 가능합니다.");
            return;
        }
        accountService.deposit(amount);
    }

    public void withdraw(int amount) {
        if (!isLoggedIn()) {
            System.out.println("🔑 로그인 후 이용 가능합니다.");
            return;
        }
        accountService.withdraw(amount);
    }

    public void checkBalance() {
        if (!isLoggedIn()) {
            System.out.println("🔑 로그인 후 이용 가능합니다.");
            return;
        }
        accountService.checkBalance();
    }

    public void viewPremiumBenefits() {
        if (!isLoggedIn()) {
            System.out.println("🔑 로그인 후 이용 가능합니다.");
            return;
        }
        accountService.viewPremiumBenefits();
    }

    public void sendToFriends(String friendId, int amount) {
        if (!isLoggedIn()) {
            System.out.println("🔑 로그인 후 이용 가능합니다.");
            return;
        }

        if (account.getBalance() < amount) {
            System.out.println("❌ 잔액이 부족하여 송금할 수 없습니다.");
            return;
        }

        account.withdraw(amount);
        System.out.println("💸 " + amount + "원이 '" + friendId + "'님에게 송금되었습니다.");
        System.out.println("📌 현재 잔액: " + account.getBalance() + "원");
    }
}