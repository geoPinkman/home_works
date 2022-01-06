public class PhysicalPerson extends Client {
    public PhysicalPerson(){}
    public PhysicalPerson(double amount) {
        super(amount);
    }

    @Override
    protected double getWithdrawalCommission() {
        return 0;
    }

    @Override
    protected double getDepositCommission(double amount) {
        return 0;
    }
}
