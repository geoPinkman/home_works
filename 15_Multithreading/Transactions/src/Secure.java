public class Secure implements Runnable{

    private Account donor;
    private Account recipient;
    private long amount;

    public Secure(Account donor, Account recipient, long amount) {
        this.donor = donor;
        this.recipient = recipient;
        this.amount = amount;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    public synchronized void secure() {
        donor.setFreeze(true);
        recipient.setFreeze(true);
    }


    @Override
    public void run() {
        while (getAmount() < 50) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        secure();

    }
}
