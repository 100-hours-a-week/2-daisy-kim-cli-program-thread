package models;

public class PremiumAccount extends Account {
    private PremiumBenefits premiumBenefits;

    public PremiumAccount(User owner, String accountNumber) {
        super(owner, accountNumber);
        this.premiumBenefits = new PremiumBenefits();
    }

    public void showBenefits() {
        premiumBenefits.displayBenefits();
    }
}