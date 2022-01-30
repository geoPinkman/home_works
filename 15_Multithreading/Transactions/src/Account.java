public class Account {

    private long money;
    private String accNumber;
    private boolean frozen;

    public Account(long money, String accNumber) {
        this.money = money;
        this.accNumber = accNumber;
        this.frozen = false;
    }

    public long getMoney() {
        return money;
    }

    public void setMoney(long money) {
        this.money = money;
    }

    public String getAccNumber() {
        return accNumber;
    }

    public void setAccNumber(String accNumber) {
        this.accNumber = accNumber;
    }

    public boolean isFrozen() {
        return frozen;
    }

    public void setFrozen(boolean frozen) {
        this.frozen = frozen;
    }

    @Override
    public String toString() {
        return "Account{" +
                "money=" + money +
                ", accNumber='" + accNumber + '\'' +
                ", frozen=" + frozen +
                '}';
    }


}
