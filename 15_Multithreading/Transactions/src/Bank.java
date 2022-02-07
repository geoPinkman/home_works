import java.util.*;

public class Bank {

    private Map<String, Account> accounts;
    //private final Random random = new Random();

//    public synchronized boolean isFraud(String fromAccountNum, String toAccountNum, long amount)
//        throws InterruptedException {
//        Thread.sleep(1000);
//        return random.nextBoolean();
//    }


    public Bank() {
        this.accounts = new Hashtable<>();
    }

    public Map<String, Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(Map<String, Account> accounts) {
        this.accounts = accounts;
    }

    public void addAccount(Account account) {
        accounts.put(account.getAccNumber(), account);
    }

    /**
     * TODO: реализовать метод. Метод переводит деньги между счетами. Если сумма транзакции > 50000,
     * то после совершения транзакции, она отправляется на проверку Службе Безопасности – вызывается
     * метод isFraud. Если возвращается true, то делается блокировка счетов (как – на ваше
     * усмотрение)
     */
    public void transfer(String fromAccountNum, String toAccountNum, long amount) {
        if (areAccInSystem(fromAccountNum, toAccountNum)) {
            System.out.println("ok");
            if (!isAccFroze(fromAccountNum) & getAccMoney(fromAccountNum) >= amount) {
                System.out.println(accounts.get(fromAccountNum).getAccNumber() + " ok");
                if (amount >= 50) {
                    Thread sc = new Thread(new Secure(accounts.get(fromAccountNum), accounts.get(toAccountNum)));
                    sc.start();
                    try {
                        sc.join();
                        return;
                    } catch (InterruptedException e) {
                        e.getStackTrace();
                    }
                } else if (!isAccFroze(toAccountNum)) {
                    System.out.println(accounts.get(toAccountNum).getAccNumber() + " ok");
                    synchronized (accounts.get(fromAccountNum).compareTo(accounts.get(toAccountNum)) > 0 ? this : accounts.get(toAccountNum)) {
                        synchronized (accounts.get(toAccountNum)) {
                            long result1 = accounts.get(fromAccountNum).getMoney() - amount;
                            accounts.get(fromAccountNum).setMoney(result1);
                            long result2 = accounts.get(toAccountNum).getMoney() + amount;
                            accounts.get(toAccountNum).setMoney(result2);
                        }
                    }

                } else {
                    System.out.println("some wrong with " + accounts.get(toAccountNum).getAccNumber());
                }
            } else {
                System.out.println("some wrong with " + accounts.get(fromAccountNum).getAccNumber());
            }
        } else {
            System.out.println("one or more acc not found in system");
        }
    }

    private int getIntCodeToCompare(String fromAccountNum, String toAccountNum) {
        int result = 0;
        if (accounts.containsKey(fromAccountNum) & accounts.containsKey(toAccountNum)) {
            result = 1;
        }
        if(accounts.containsKey(fromAccountNum) & !accounts.containsKey(toAccountNum)
                | !accounts.containsKey(fromAccountNum) & accounts.containsKey(toAccountNum)
                | !accounts.containsKey(fromAccountNum) & !accounts.containsKey(toAccountNum)) {
            result = -1;
        }
        return result;
    }
    private boolean areAccInSystem(String fromAccountNum, String toAccountNum) {
        return getIntCodeToCompare(fromAccountNum, toAccountNum) == 1;
    }



    private boolean isAccFroze(String acc) {
        return accounts.get(acc).isFreeze();
    }

    private long getAccMoney(String acc) {
        return accounts.get(acc).getMoney();
    }

    /**
     * TODO: реализовать метод. Возвращает остаток на счёте.
     */
    public long getBalance(String accountNum) {
        return 0;
    }

    public long getSumAllAccounts() {
        return accounts.values().stream().mapToLong(Account::getMoney).sum();
    }
}
