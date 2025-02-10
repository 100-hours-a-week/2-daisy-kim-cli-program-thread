package services;

import java.util.List;
import models.AccountHolder;

public class InterestCalculatorThread extends Thread {
    private List<AccountHolder> accounts;
    private boolean running = true;

    public InterestCalculatorThread(List<AccountHolder> accounts) {
        this.accounts = accounts;
    }

    public void run() {
        while (running) {
            try {
                Thread.sleep(10000);
                applyInterest();
            } catch (InterruptedException e) {
                System.out.println("이자 계산 스레드 중단");
                break;
            }
        }
    }

    private void applyInterest() {
        for (AccountHolder account : accounts) {
            double interest = account.getBalance() * 0.01;
            int roundedInterest = (int) Math.round(interest);
            account.deposit(roundedInterest);

            System.out.printf("\n💰 [이자 지급] %s님의 계좌에 %d 원이 지급되었습니다. (현재 잔액: %d원)\n",
                    account.getOwner().getName(), roundedInterest, account.getBalance());
        }
    }

    public void stopCalculator() {
        running = false;
        this.interrupt();
    }
}