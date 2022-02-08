public class Account implements Comparable<Account> {

    private long money;
    private int accNumber;
    private boolean isFreeze;


    public Account(long money, int accNumber) {
        this.money = money;
        this.accNumber = accNumber;
        this.isFreeze = false;
    }

    public long getMoney() {
        return money;
    }

    public void setMoney(long money) {
        this.money = money;
    }

    public int getAccNumber() {
        return accNumber;
    }

    public void setAccNumber(int accNumber) {
        this.accNumber = accNumber;
    }

    public boolean isFreeze() {
        return isFreeze;
    }

    public void setFreeze(boolean freeze) {
        isFreeze = freeze;
    }

    @Override
    public int compareTo(Account o) {
        if (this.accNumber < o.accNumber) {
            return 1;
        }
        if (this.accNumber > o.accNumber) {
            return -1;
        }
        else {
            return 0;
        }

    }
}
