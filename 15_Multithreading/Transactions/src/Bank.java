import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Bank {

    private Map<String, Account> accounts;
    //private final Random random = new Random();



    /**
     * TODO: реализовать метод. Метод переводит деньги между счетами. Если сумма транзакции > 50000,
     * то после совершения транзакции, она отправляется на проверку Службе Безопасности – вызывается
     * метод isFraud. Если возвращается true, то делается блокировка счетов (как – на ваше
     * усмотрение)
     */
    public void transfer(String fromAccountNum, String toAccountNum, long amount) {

        Account source = accounts.get(fromAccountNum);
        Account recipient = accounts.get(toAccountNum);
        SelfSecurity ss = new SelfSecurity(amount, source, recipient);
        ss.run();
        if (amount < 0) {
            return;
        } else if (source.isFrozen()) {
            System.out.println("аккаунт отправителя заблокирован");
            return;
        } else if (recipient.isFrozen()) {
            System.out.println("аккаунт получателя заблокирован");
            return;
        } else if (source.getMoney() < amount) {
            System.out.println("на счету отправителя недостаточно средств");
            return;
        } else {
            long resultSrc = source.getMoney() - amount;
            long resultRec = recipient.getMoney() + amount;
            source.setMoney(resultSrc);
            recipient.setMoney(resultRec);
        }




    }

    /**
     * TODO: реализовать метод. Возвращает остаток на счёте.
     */
    public long getBalance(String accountNum) {
        return 0;
    }

    public long getSumAllAccounts() {
        return 0;
    }

    public Bank() {
        this.accounts = new HashMap<>();
    }

    public void addClients(Account account) {
        accounts.put(account.getAccNumber(), account);
    }

    public static void main(String[] args) {

        Bank testBank = new Bank();

        Account test1 = new Account(100000, "0101");
        Account test2 = new Account(100000, "0102");

        testBank.addClients(test1);
        testBank.addClients(test2);

        System.out.println(test1);
        System.out.println(test2);
        testBank.transfer("0101", "0102", 51000);

        System.out.println(test1);
        System.out.println(test2);
        testBank.transfer("0101", "0102", 1000);
        System.out.println(test1);
        System.out.println(test2);

//        testBank.transfer("0101", "0102", 51000);
//        System.out.println(test1);
//        System.out.println(test2);

    }
}
