package services;

import models.*;

public class BankService {
    private Account userAccount;
    private boolean isLoggedIn;

    public BankService() {
        User user = new User("김다은", "daisy", "1234");
        this.userAccount = new AccountHolder(user, "010-123-456");
        this.isLoggedIn = false;
    }

    public boolean login(String userId, String password) {
        if (userAccount.getOwner().login(userId, password)) {
            isLoggedIn = true;
            System.out.println("✅ 로그인 성공! 환영합니다, " + userAccount.getOwner().getName() + "님.");
            return true;
        } else {
            System.out.println("❌ 로그인 실패! 아이디 또는 비밀번호가 잘못되었습니다.");
            return false;
        }
    }

    public boolean isLoggedIn() {
        return isLoggedIn;
    }

    public void deposit(int amount) {
        if (isLoggedIn) {
            userAccount.deposit(amount);
            checkAndUpgradeAccount();
        } else {
            System.out.println("🔑 로그인 후 이용 가능합니다.");
        }
    }

    public void checkAndUpgradeAccount() {
        if (userAccount instanceof AccountHolder && userAccount.getBalance() >= 1000000) {
            User currentUser = userAccount.getOwner();
            userAccount = new PremiumAccount(currentUser, userAccount.getAccountNumber());
            System.out.println("🎉 축하합니다! 프리미엄 계좌로 자동 전환되었습니다.");
        }
    }

    public void withdraw(int amount) {
        if (isLoggedIn) {
            userAccount.withdraw(amount);
        } else {
            System.out.println("🔑 로그인 후 이용 가능합니다.");
        }
    }

    public void checkBalance() {
        if (isLoggedIn) {
            userAccount.checkBalance();
        } else {
            System.out.println("🔑 로그인 후 이용 가능합니다.");
        }
    }

    public void viewPremiumBenefits() {
        if (!isLoggedIn) {
            System.out.println("🔑 로그인 후 이용 가능합니다.");
            return;
        }

        if (userAccount instanceof PremiumAccount) {
            ((PremiumAccount) userAccount).showBenefits();
        } else {
            System.out.println("❌ 일반 계좌는 프리미엄 혜택을 볼 수 없습니다.");
        }
    }

    public void sendToFriends(String friendId, int amount) {
        if (!isLoggedIn) {
            System.out.println("🔑 로그인 후 이용 가능합니다.");
            return;
        }

        if (!(userAccount instanceof AccountHolder)) {
            System.out.println("❌ 해당 계좌에서는 송금 기능을 사용할 수 없습니다.");
            return;
        }

        if (userAccount.getBalance() < amount) {
            System.out.println("❌ 잔액이 부족하여 송금할 수 없습니다.");
            return;
        }

        userAccount.withdraw(amount);

        System.out.println("💸 " + amount + "원이 " + friendId + "님에게 송금되었습니다.");
        System.out.println("📌 현재 잔액: " + userAccount.getBalance() + "원");
    }
}