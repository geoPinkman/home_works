import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.*;
import org.bson.conversions.Bson;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;

public class Main {

    private static final List<Merch> myNet = new ArrayList<>();

    public static void addMerch(String product, String shop, int cost) {
        myNet.add(new Merch(product, shop, cost));
    }
    private final static MongoDatabase mongoDB = DBConnector.getInstance("dwarf-trader");

    private final static MongoCollection<Shop> shopList = mongoDB.getCollection("shops", Shop.class);
    private final static MongoCollection<Merch> netList = mongoDB.getCollection("products", Merch.class);
    private final static MongoCollection<Product> products = mongoDB.getCollection("storage", Product.class);

    public static void printList(String kind) {
        if (kind.equals("storage")) {
            products.find().forEach((Consumer<Product>) p -> System.out.println(p.getName()));
        }
        if (kind.equals("shops")) {
            shopList.find().forEach((Consumer<Shop>) p -> System.out.println(p.getName()));
        }
        if (kind.equals("net")) {
            netList.find().forEach((Consumer<Merch>) p -> System.out.println(p.getProductName() + " "
                    + p.getCost() + " golds in " + p.getGroceryName()));
        }
        else if (kind.isEmpty()){
            System.out.println("no data's");
        }
    }

    public static void printProductList(String product) {
        Bson filter = Filters.eq("productName", product);
        System.out.println(product + ":");
        netList.aggregate(Collections.singletonList(Aggregates.match(filter))).forEach((Consumer<Merch>) p ->
                System.out.println(p.getCost() + " golds in " + p.getGroceryName()));
        sumOfCost(filter);
    }

    public static void printShopList(String shop) {
        Bson filter = Filters.eq("groceryName", shop);
        System.out.println(shop + ":");
        netList.aggregate(Collections.singletonList(Aggregates.match(filter))).forEach((Consumer<Merch>) p ->
                System.out.println(p.getProductName() + " - " + p.getCost() + " golds"));
        sumOfCost(filter);
    }

    public static void sumOfCost(Bson filter) {
        AtomicInteger result = new AtomicInteger();
        AtomicInteger count = new AtomicInteger(0);
        netList.aggregate(Collections.singletonList(Aggregates.match(filter))).forEach((Consumer<Merch>) p -> {
                    result.addAndGet(p.getCost());
                    count.getAndIncrement();
                });
        int smallest = netList.find().sort(Sorts.ascending("cost")).first().getCost();
        int biggest =  netList.find().sort(Sorts.descending("cost")).first().getCost();
        System.out.println("Total sum: " + result + " golds");
        System.out.println("Average cost is: " + (double)(result.get() / count.get()) + " golds");
        System.out.println("Minimal cost is " + smallest + " and maximal - " + biggest + " golds");
    }
    public static void moreThen(int price) {
        Bson filter = Filters.gt("cost", price);
        System.out.println("list of Products greater then " + price);
        netList.aggregate(Collections.singletonList(Aggregates.match(filter))).forEach((Consumer<Merch>) p ->
                System.out.println(p.getProductName() + " " + p.getCost() + " golds in " + p.getGroceryName()));
    }

    public static void lessThen(int price) {
        Bson filter = Filters.lt("cost", price);
        System.out.println("list of Products greater then " + price);
        netList.aggregate(Collections.singletonList(Aggregates.match(filter))).forEach((Consumer<Merch>) p ->
                System.out.println(p.getProductName() + " " + p.getCost() + " golds in " + p.getGroceryName()));
    }

    public static void main(String[] args) {
        //mongoDB.drop();
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
                    return;
                case("info"):
                    printList(scanArray[1]);
                    break;
                case("stat_product"):
                    printProductList(scanArray[1]);
                    break;
                case("stat_shop"):
                    printShopList(scanArray[1]);
                    break;
                case("greater"):
                    moreThen(Integer.parseInt(scanArray[1]));
                    break;
                case("less"):
                    lessThen(Integer.parseInt(scanArray[1]));
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
