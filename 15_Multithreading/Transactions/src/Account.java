public class Account implements Comparable<Account> {

    private long money;
    private String accNumber;
    private boolean isFreeze;


    public Account(long money, String accNumber) {
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

    public String getAccNumber() {
        return accNumber;
    }

    public void setAccNumber(String accNumber) {
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
        return this.getAccNumber().compareTo(o.accNumber);
    }
}
