public class CardAccount extends BankAccount {

    public static final double TAX = 0.01;

    public CardAccount(){}
    public CardAccount(double account, String name) {
        super(account, name);
    }

    public void take(double amountToTake) {
        double result;
        if (amountToTake > getAmount() + (amountToTake * TAX)) {
            return;
        }
        result = getAmount() - amountToTake * (1 + TAX);
        setAccount(result);
    }

    public static void main(String[] args) {
        CardAccount cardAccount = new CardAccount(100, "geo");
        cardAccount.put(20);
        System.out.println(cardAccount.getAmount());
        cardAccount.take(20);
        System.out.println(cardAccount.getAmount());
    }
}
