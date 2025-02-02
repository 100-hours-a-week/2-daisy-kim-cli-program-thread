package models;

import java.util.ArrayList;

public class PremiumBenefits {
    private ArrayList<String> benefits;

    public PremiumBenefits() {
        this.benefits = new ArrayList<>();
        this.benefits.add("높은 이자율");
        this.benefits.add("VIP 전용 상담");
    }

    public void displayBenefits() {
        System.out.println("🎖️ 프리미엄 혜택 목록 🎖️");
        for (String benefit : benefits) {
            System.out.println("- " + benefit);
        }
    }
}