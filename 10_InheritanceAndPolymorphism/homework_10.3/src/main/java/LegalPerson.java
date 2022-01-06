public class LegalPerson extends Client {

    public LegalPerson(double amount) {
        super(amount);
    }
    public LegalPerson(){}


    @Override
    protected double getWithdrawalCommission() {
        return 0.01;
    }

    @Override
    protected double getDepositCommission(double amount) {
        return 0;
    }
}
