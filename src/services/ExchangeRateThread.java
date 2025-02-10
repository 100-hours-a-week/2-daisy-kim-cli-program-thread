package services;

import java.util.Random;

public class ExchangeRateThread extends Thread {
    private double exchangeRate;

    public ExchangeRateThread() {
        this.exchangeRate = 1300.0;
    }

    public void run() {
        Random random = new Random();
        double change = (random.nextDouble() - 0.5) * 10;
        exchangeRate += change;
        System.out.printf("💱 현재 환율: %.2f 원/USD\n", exchangeRate);
    }
}