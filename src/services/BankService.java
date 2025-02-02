package services;

import models.*;

public class BankService {
    private Account userAccount;
    private boolean isLoggedIn;

    public BankService() {
        User user = new User("김다은", "daisy", "password");
        this.userAccount = new PremiumAccount(user, "010-123-456");
        this.isLoggedIn = false;
    }

    public boolean login(String userId, String password) {
        // ✅ `getOwner()` 메서드를 사용하여 owner에 접근
        if (userAccount.getOwner().login(userId, password)) {
            isLoggedIn = true;
            System.out.println("✅ 로그인 성공! 환영합니다, " + userAccount.getOwner().getName() + "님.");
            return true;
        } else {
            System.out.println("❌ 로그인 실패! 아이디 또는 비밀번호가 잘못되었습니다.");
            return false;
        }
    }

    public void deposit(double amount) {
        if (isLoggedIn) {
            userAccount.deposit(amount);
        } else {
            System.out.println("🔑 로그인 후 이용 가능합니다.");
        }
    }

    public void withdraw(double amount) {
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
        if (isLoggedIn && userAccount instanceof PremiumAccount) {
            ((PremiumAccount) userAccount).showBenefits();
        } else {
            System.out.println("🔑 로그인 후 이용 가능합니다.");
        }
    }
}