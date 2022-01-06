public class IndividualBusinessman extends Client {

    public IndividualBusinessman() {
    }

    public IndividualBusinessman(double amount) {
        super(amount);
    }


    @Override
    protected double getWithdrawalCommission() {
        return 0;
    }

    @Override
    protected double getDepositCommission(double amount) {
        if (amount < 1000) {
            return 0.01;
        } else {
            return 0.005;
        }
    }
}
