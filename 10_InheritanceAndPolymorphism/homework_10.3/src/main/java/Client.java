public abstract class Client {

    private double amount;

    public Client(double amount) {
        this.amount = amount;
    }
    public Client(){}

    public double getAmount() {
        return amount;
    }
    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void put(double amountToPut) {
        if (amountToPut < 0) {
            return;
        }
        amount += amountToPut * (1 - getDepositCommission(amountToPut));
    }

    public void take(double amountToTake){
        if (amountToTake > this.getAmount()) {
            return;
        }
        amount -= amountToTake * (1 + getWithdrawalCommission());
    }

    protected abstract double getWithdrawalCommission();

    protected abstract double getDepositCommission(double amount);
}
