import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Accumulators;
import com.mongodb.client.model.Aggregates;
import com.mongodb.client.model.BsonField;
import com.mongodb.client.model.Filters;
import org.bson.conversions.Bson;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;

public class Main {

    private static final List<Merch> myNet = new ArrayList<>();

    public static void addMerch(String product, String shop, int cost) {
        myNet.add(new Merch(product, shop, cost));
    }
    private static MongoDatabase mongoDB = DBConnector.getInstance("dwarf-trader");

    private static MongoCollection<Shop> shopList = mongoDB.getCollection("shops", Shop.class);
    private static MongoCollection<Merch> netList = mongoDB.getCollection("products", Merch.class);
    private static MongoCollection<Product> products = mongoDB.getCollection("storage", Product.class);

    public static void main(String[] args) {
        mongoDB.drop();

        for(;;) {

            Scanner scanner = new Scanner(System.in);
            String scanString = scanner.nextLine();

            String[] scanArray = scanString.split(" ", 2);
            switch (scanArray[0]) {
                case ("add_shop"):
                    addShop(scanArray[1]);
                    break;
                case ("add_product"):
                    addProductInStorage(scanArray[1]);
                    break;
                case("move"):
                    String[] productToShop = scanArray[1].split(", ", 3);
                    addProductInShop(productToShop[0], productToShop[1], Integer.parseInt(productToShop[2]));
                    break;
                case("commands"):
                    try {
                        File file = new File("/Users/pigeon/Documents/skillbox/java_basics/17_NoSQL/Shop/src/main/resources/commands.txt");
                        FileReader fileReader = new FileReader(file);
                        BufferedReader reader = new BufferedReader(fileReader);
                        while (reader.ready()) {
                            System.out.println(reader.readLine());
                        }
                    }
                    catch (Exception ex) {
                        ex.printStackTrace();
                    }
                    break;
                case("exit"):
                    break;
                case("info"):
                    System.out.println();
                    break;
                default:
                    System.out.println("try again");
                    break;
            }

        }
    }

    public static void addShop (String name) {
        shopList.insertOne(new Shop(name));
    }

    public static void addProductInStorage (String name) {
        products.insertOne(new Product(name));
    }

    public static void delFromStorage(String productName) {
        products.findOneAndDelete(Filters.eq("name", productName));
    }

    public static boolean isShopInList(String name) {
        return shopList.find(Filters.eq("name", name)).first() != null;
    }

    public static void addProductInShop(String productName, String shopName, int cost) {
        Product result = new Product();
        if (products.find(Filters.eq("name", productName)).first() != null) {
            delFromStorage(productName);
            result.setName(productName);
            result.setCost(cost);
        } else {
            System.out.println("product not found in storage");
            return;
        }
        if (isShopInList(shopName)) {
            netList.insertOne(new Merch(result.getName(), shopName, result.getCost()));
        } else {
            System.out.println("shop not found");
        }

    }


}
