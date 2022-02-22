
public class RedisTest {
    public static void main(String[] args) {
        final int USERS_COUNT = 19;
        RedisClass test = new  RedisClass();
        test.init();
        for (int i = 0; i <= USERS_COUNT; i++) {
            test.add(i);
        }
        int count = 0;
        for(;;) {
            count++;
            if (count % 10 == 0) {
                test.makeFirst((int) (Math.random() * USERS_COUNT));
                try{
                    Thread.sleep(1000);
                } catch (Exception ex) {
                    ex.getMessage();
                }
            }
            System.out.println(test.getUser());
            test.makeLast(Integer.valueOf(test.getUser()));
        }
        //test.shutDown();


    }
}
