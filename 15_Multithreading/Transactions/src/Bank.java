import java.util.*;

public class Bank {

    private Map<Integer, Account> accounts;
    //private final Random random = new Random();

//    public synchronized boolean isFraud(String fromAccountNum, String toAccountNum, long amount)
//        throws InterruptedException {
//        Thread.sleep(1000);
//        return random.nextBoolean();
//    }


    public Bank() {
        this.accounts = new Hashtable<>();
    }

    public Map<Integer, Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(Map<Integer, Account> accounts) {
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
    public void transfer(int fromAccountNum, int toAccountNum, long amount) {
        Thread sc = new Thread(new Secure(accounts.get(fromAccountNum), accounts.get(toAccountNum), amount));
        sc.start();

        if (areAccInSystem(fromAccountNum, toAccountNum)) {
            System.out.println("ok");
            if (!isAccFroze(fromAccountNum) & getAccMoney(fromAccountNum) >= amount) {
                System.out.println(accounts.get(fromAccountNum).getAccNumber() + " ok");
                    if (!isAccFroze(toAccountNum)) {
                        System.out.println(accounts.get(toAccountNum).getAccNumber() + " ok");
                        if (amount < 50) {
                            synchronized (accounts.get(fromAccountNum).compareTo(accounts.get(toAccountNum)) > 0 ? this : accounts.get(toAccountNum)) {
                                synchronized (accounts.get(toAccountNum).compareTo(accounts.get(fromAccountNum)) < 0 ? this : accounts.get(fromAccountNum)) {
                                    long result1 = accounts.get(fromAccountNum).getMoney() - amount;
                                    accounts.get(fromAccountNum).setMoney(result1);
                                    long result2 = accounts.get(toAccountNum).getMoney() + amount;
                                    accounts.get(toAccountNum).setMoney(result2);
                                }
                            }
                        } else {
                            try {
                                sc.join();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
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

    private int getIntCodeToCompare(int fromAccountNum, int toAccountNum) {
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
    private boolean areAccInSystem(int fromAccountNum, int toAccountNum) {
        return getIntCodeToCompare(fromAccountNum, toAccountNum) == 1;
    }



    private boolean isAccFroze(int accNumber) {
        return accounts.get(accNumber).isFreeze();
    }

    private long getAccMoney(int accNumber) {
        return accounts.get(accNumber).getMoney();
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
