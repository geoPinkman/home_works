import org.redisson.Redisson;
import org.redisson.api.*;
import org.redisson.client.RedisConnectionException;
import org.redisson.config.Config;

public class RedisClass {

    private RedissonClient client;

    private RKeys rKeys;

    private RScoredSortedSet<String> sortedSet;

    private final String KEY = "test";

    void init() {
        Config config = new Config();
        config.useSingleServer().setAddress("redis://127.0.0.1:6379");
        try {
            client = Redisson.create(config);
        } catch (RedisConnectionException Exc) {
            System.out.println("Не удалось подключиться к Redis");
            System.out.println(Exc.getMessage());
        }
        rKeys = client.getKeys();
        sortedSet = client.getScoredSortedSet(KEY);
        //rKeys.delete(KEY);
    }
    public void listKeys() {
        Iterable<String> keys = rKeys.getKeys();
        for(String key: keys) {
            System.out.println("KEY: " + key + ", type:" + rKeys.getType(key));
        }
    }

    public void shutDown() {
        client.shutdown();
    }


    public boolean add(int userId) {
        sortedSet.tryAdd(System.currentTimeMillis(), String.valueOf(userId));
        return true;
    }

    public boolean makeFirst(int userId) {
        sortedSet.add(0, String.valueOf(userId));
        return true;
    }
    public boolean makeLast(int userId) {
        sortedSet.add(System.currentTimeMillis(), String.valueOf(userId));
        return true;
    }

    public String getUser() {
        return sortedSet.first();
    }

}
