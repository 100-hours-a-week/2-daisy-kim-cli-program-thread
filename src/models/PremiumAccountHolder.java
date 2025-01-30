package models;

import java.util.ArrayList;

public class PremiumAccountHolder extends AccountHolder {
    private ArrayList<String> premiumBenefits;

    public PremiumAccountHolder(String name, String userId, String password, String accountNumber) {
        super(name, userId, password, accountNumber);
        this.premiumBenefits = new ArrayList<>();
    }

    public void addPremiumBenefit(String benefit) {
        premiumBenefits.add(benefit);
    }

    public void displayPremiumBenefits() {
        System.out.println("🎖️ 프리미엄 혜택 목록 🎖️");
        for (String benefit : premiumBenefits) {
            System.out.println("- " + benefit);
        }
    }
}