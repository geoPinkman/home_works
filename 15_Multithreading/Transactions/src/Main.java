public class Main {
    public static void main(String[] args) {
        Bank alfa = new Bank();

        Account acc1 = new Account(1000, "0101");
        Account acc2 = new Account(1200, "0102");
        Account acc3 = new Account(1100, "0103");

        alfa.addAccount(acc1);
        alfa.addAccount(acc2);
        alfa.addAccount(acc3);

        System.out.println(alfa.getSumAllAccounts());

        for (int i = 0; i < 101; i++) {
            long am = 10;
            alfa.transfer(acc1.getAccNumber(), acc2.getAccNumber(), am);
            alfa.transfer(acc2.getAccNumber(), acc1.getAccNumber(), 15);
            //alfa.transfer(acc2.getAccNumber(), acc3.getAccNumber(), am);
//            System.out.println(i + ":  " + acc1.getMoney() + " - " + acc2.getMoney());
//            System.out.println(i + ":  " + acc1.getMoney() + " - " + acc3.getMoney());
//            System.out.println(i + ":  " + acc2.getMoney() + " - " + acc3.getMoney());
        }

        System.out.println(alfa.getSumAllAccounts());
    }
}
