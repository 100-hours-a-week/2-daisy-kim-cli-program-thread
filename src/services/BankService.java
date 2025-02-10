package services;
import models.AccountHolder;
import java.util.List;

public class BankService {
    private UserService userService;
    private AccountService accountService;
    private AccountHolder account;
    private ExchangeRateThread exchangeRateThread;
    private InterestCalculatorThread interestThread;

    public BankService() {
        this.userService = new UserService();
        this.account = new AccountHolder(userService.getUser(), "010-123-456");
        this.accountService = new AccountService(account);
        this.exchangeRateThread = new ExchangeRateThread();
        this.exchangeRateThread.start();
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
        accountService.sendToFriends(friendId, amount);
    }

    public void getExchangeRate() {
        System.out.printf("💱 현재 환율: %.2f 원/USD\n", exchangeRateThread.getExchangeRate());
    }

    public void stopExchangeRateThread() {
        exchangeRateThread.stopUpdating();
    }

    public BankService(List<AccountHolder> accounts) {
        this.userService = new UserService();
        this.account = accounts.get(0);
        this.accountService = new AccountService(account);
        this.exchangeRateThread = new ExchangeRateThread();
        this.exchangeRateThread.start();

        // 중복 실행 방지
        if (interestThread == null) {
            interestThread = new InterestCalculatorThread(accounts);
            interestThread.start();
        }
    }

    public void stopInterestCalculator() {
        interestThread.stopCalculator();
    }
}