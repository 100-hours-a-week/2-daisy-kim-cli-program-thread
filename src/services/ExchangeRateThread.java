package services;

import java.util.Random;

public class ExchangeRateThread extends Thread {
    private double exchangeRate = 1300.0;
    private boolean running = true;

    public void run() {
        Random random = new Random();
        while (running) {
            try {
                Thread.sleep(10000);
                double change = (random.nextDouble() - 0.5) * 10;
                exchangeRate += change;
            } catch (InterruptedException e) {
                System.out.println("환율 업데이트 중단");
                break;
            }
        }
    }

    public double getExchangeRate() {
        return exchangeRate;
    }

    public void stopUpdating() {
        running = false;
    }
}