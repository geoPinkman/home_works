public class BankAccount {

    private double balance;
    private String name;

    public BankAccount(){

    }
    public BankAccount(double account, String name) {
        this.balance = account;
        this.name = name;
    }

    public double getAmount() {
        return balance;
    }

    public void setAccount(double account) {
        this.balance = account;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void put(double amountToPut) {
        if(amountToPut < 0)
            return;
        balance += amountToPut;
    }

    public void take(double amountToTake) {
        if (getAmount() < amountToTake)
            return;
        balance -= amountToTake;
    }

    public boolean send(BankAccount account, double amount) {

        if (amount > 0 & this.getAmount() > amount) {
            double before = account.getAmount();
            account.setAccount(before + amount);
            before = this.getAmount();
            this.setAccount(before - amount);
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        BankAccount acc1 = new BankAccount(100, "geo");
        BankAccount acc2 = new CardAccount(100, "lizi");
        System.out.println("Баланс первого аккаунта " + acc1.getAmount());
        System.out.println("Баланс второго аккаунта " + acc2.getAmount());
        acc1.send(acc2, 20);
        System.out.println("Баланс первого аккаунта " + acc1.getAmount());
        System.out.println("Баланс второго аккаунта " + acc2.getAmount());
    }
}
