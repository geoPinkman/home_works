import java.util.Calendar;
import java.util.Map;
import java.util.TreeMap;

public class DepositAccount extends BankAccount {

    private Calendar lastIncome = Calendar.getInstance();
    private Map<Calendar, Double>buffer = new TreeMap<>();


    public DepositAccount(){}

    public DepositAccount(double account, String name) {
        super(account, name);
        setCalendar(lastIncome);
    }
    public Calendar getCalendar() {
        return lastIncome;
    }

    public void setCalendar(Calendar lastIncome) {
        lastIncome.add(Calendar.MONTH, 1);
    }

    public void take(double amountToTake) {
            double result;
            Calendar toDay = Calendar.getInstance();
            if (toDay.after(lastIncome) & amountToTake <= this.getAmount()) {
                result = this.getAmount() - amountToTake;
                setAccount(result);
            }
        }


    public void put(double amountToPut) {
        if (amountToPut < 0)
            return;
        lastIncome = Calendar.getInstance();
        double result = this.getAmount() + amountToPut;
        setAccount(result);
    }

//    public static void main(String[] args) throws InterruptedException {
//
//        BankAccount bankAccount = new DepositAccount(0,"geo");
//        bankAccount.put(20);
//        Thread.sleep(10000);
//        System.out.println("первая попытка снять");
//        bankAccount.take(12);
//        System.out.println(bankAccount.getAmount());
//        Thread.sleep(10000);
//        System.out.println("вторая попытка снять");
//        bankAccount.take(12);
//        System.out.println(bankAccount.getAmount());
//        Thread.sleep(10000);
//        System.out.println("третья попытка снять");
//        bankAccount.take(12);
//        System.out.println(bankAccount.getAmount());
//        Thread.sleep(10000);
//        System.out.println("четвертая попытка снять");
//        bankAccount.take(12);
//        System.out.println(bankAccount.getAmount());
//        bankAccount.take(2);
//        System.out.println(bankAccount.getAmount());
//    }
}
