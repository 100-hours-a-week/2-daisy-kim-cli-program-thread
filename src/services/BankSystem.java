package services;

import models.*;

import java.util.Scanner;

public class BankSystem {
    private Scanner scanner;
    private PremiumAccountHolder user;
    private boolean isLoggedIn;

    public BankSystem() {
        this.scanner = new Scanner(System.in);
        this.user = new PremiumAccountHolder("김다은", "daisy", "password", "010-123-456");
        this.user.addPremiumBenefit("높은 이자율");
        this.user.addPremiumBenefit("VIP 전용 상담");
        this.isLoggedIn = false;
    }

    public void start() {
        while (true) {
            System.out.println("\n🌟 풀스택 은행 🌟");
            System.out.println("1️⃣ 로그인\n2️⃣ 입금\n3️⃣ 출금\n4️⃣ 송금\n5️⃣ 잔액 조회\n6️⃣ 프리미엄 혜택 보기\n7️⃣ 종료");
            System.out.print("🛠 선택: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    login();
                    break;
                case "2":
                    deposit();
                    break;
                case "3":
                    withdraw();
                    break;
                case "4":
                    transfer();
                    break;
                case "5":
                    checkBalance();
                    break;
                case "6":
                    viewPremiumBenefits();
                    break;
                case "7":
                    System.out.println("🏦 은행을 종료합니다.");
                    scanner.close();
                    return;
                default:
                    System.out.println("❌ 올바른 선택이 아닙니다. 다시 시도하세요.");
            }
        }
    }

    private void login() {
        System.out.print("👤 아이디 입력: ");
        String userId = scanner.nextLine();
        System.out.print("🔒 비밀번호 입력: ");
        String password = scanner.nextLine();

        if (user.login(userId, password)) {
            isLoggedIn = true;
            System.out.println("✅ 로그인 성공! 환영합니다, " + user.getName() + "님.");
        } else {
            System.out.println("❌ 로그인 실패! 아이디 또는 비밀번호가 잘못되었습니다.");
        }
    }

    private void deposit() {
        if (isLoggedIn) {
            System.out.print("💰 입금할 금액: ");
            double amount = scanner.nextDouble();
            scanner.nextLine();
            user.deposit(amount);
        } else {
            System.out.println("🔑 로그인 후 이용 가능합니다.");
        }
    }

    private void withdraw() {
        if (isLoggedIn) {
            System.out.print("💸 출금할 금액: ");
            double amount = scanner.nextDouble();
            scanner.nextLine();
            user.withdraw(amount);
        } else {
            System.out.println("🔑 로그인 후 이용 가능합니다.");
        }
    }

    private void transfer() {
        if (isLoggedIn) {
            System.out.print("👥 송금할 상대 이름: ");
            String toName = scanner.nextLine();
            System.out.print("💵 송금할 금액: ");
            double amount = scanner.nextDouble();
            scanner.nextLine();

            AccountHolder toAccount = new AccountHolder(toName, "dummy", "dummy", "000-000-000");
            user.transfer(toAccount, amount);
        } else {
            System.out.println("🔑 로그인 후 이용 가능합니다.");
        }
    }

    private void checkBalance() {
        if (isLoggedIn) {
            user.checkBalance();
        } else {
            System.out.println("🔑 로그인 후 이용 가능합니다.");
        }
    }

    private void viewPremiumBenefits() {
        if (isLoggedIn) {
            user.displayPremiumBenefits();
        } else {
            System.out.println("🔑 로그인 후 이용 가능합니다.");
        }
    }
}