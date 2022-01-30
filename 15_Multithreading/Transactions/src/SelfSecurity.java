import java.util.HashMap;
import java.util.Map;

public class SelfSecurity implements Runnable {
    public static final long WARNING_AMOUNT = 50_000;
    private long amount;
    private volatile Account account1;
    private volatile Account account2;

    public SelfSecurity(long amount, Account account1, Account account2) {
        this.amount = amount;
        this.account1 = account1;
        this.account2 = account2;
    }

    @Override
    public void run() {
        try {
            isFrozen(amount);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void isFrozen(long amount) throws InterruptedException {
        System.out.println("проверка данных...");
        Thread.sleep(5000);
        if (account1.isFrozen() | account2.isFrozen()) {
            System.out.println("что-то пошло нитак;(");
            return;
        }
        if (amount > WARNING_AMOUNT) {
            long account1Money = account1.getMoney();
            long account2Money = account2.getMoney();
            account1.setFrozen(true);
            account1.setMoney(account1Money);
            account2.setFrozen(true);
            account2.setMoney(account2Money);
            System.out.println(";(");
        }
    }
}
