import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import org.bson.BsonDocument;
import org.bson.codecs.ValueCodecProvider;
import org.bson.codecs.configuration.CodecRegistries;
import org.bson.codecs.jsr310.Jsr310CodecProvider;
import org.bson.codecs.pojo.PojoCodecProvider;

public class DBConnector {

    public static MongoDatabase getInstance(String name) {
        MongoClient client = new MongoClient("127.0.0.1");
        return client.getDatabase(name)
               .withCodecRegistry(CodecRegistries
                        .fromProviders(PojoCodecProvider
                                .builder()
                                .register(Merch.class, Product.class, Shop.class)
                                .build(), new Jsr310CodecProvider(), new ValueCodecProvider()));
    }

}
