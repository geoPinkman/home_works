public class Secure implements Runnable{

    private Account donor;
    private Account recipient;

    public Secure(Account donor, Account recipient) {

        this.donor = donor;
        this.recipient = recipient;
    }

    public synchronized void secure() {
            donor.setFreeze(true);
            recipient.setFreeze(true);
    }


    @Override
    public void run() {
        secure();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.getStackTrace();
        }
    }
}
