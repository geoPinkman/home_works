import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import javax.naming.PartialResultException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;

public class Test {
//
//    private static MongoDatabase mongoDB = DBConnector.getInstance("dwarf-trader");
//
//    private static MongoCollection<Shop> shopList = mongoDB.getCollection("shops", Shop.class);
//    private static MongoCollection<Merch> netList = mongoDB.getCollection("products", Merch.class);
//    private static MongoCollection<Product> products = mongoDB.getCollection("storage", Product.class);
//    public static void printList(String kind) {
//        if (kind.equals("storage")) {
//            products.find().forEach((Consumer<Product>) p -> System.out.println(p.getName()));
//        }
//        if (kind.equals("shops")) {
//            shopList.find().forEach((Consumer<Shop>) p -> System.out.println(p.getName()));
//        }
//        if (kind.equals("net")) {
//            netList.find().forEach((Consumer<Merch>) p -> System.out.println(p.getProductName() + " "
//            + p.getCost() + " in " + p.getGroceryName()));
//        }
//        else {
//            System.out.println("no data's");
//        }
//
//    }
//    public static void main(String[] args) {
//        products.insertOne(new Product("lance"));
//        products.insertOne(new Product("breaker"));
//        printList("shop");
//
//

//        try {
//            File file = new File("/Users/pigeon/Documents/skillbox/java_basics/17_NoSQL/Shop/src/main/resources/commands.txt");
//            FileReader fileReader = new FileReader(file);
//            BufferedReader reader = new BufferedReader(fileReader);
//            while (reader.ready()) {
//                System.out.println(reader.readLine());
//            }
//            }
//         catch (Exception ex) {
//            ex.printStackTrace();
//        }





//        Scanner scanner = new Scanner(System.in);
//        String test = scanner.nextLine();
//        String[] testArr = test.split(" ", 2);
//        System.out.println(testArr[0]);
//        String[] testArrOfArr = testArr[1].split(", ");
//        Arrays.stream(testArrOfArr).forEach(testString -> System.out.println(testString));

        //swords
//        Storage.addProductInList("Samurai Long Sword");
//        Storage.addProductInList("Sword of Revolution");
//        Storage.addProductInList("Dynasty Sword");
//        Storage.addProductInList("Dynasty Sword");
//        Storage.addProductInList("Dynasty Sword");
//        //shields
//        Storage.addProductInList("Dynamis Shield");
//        Storage.addProductInList("Dynasty Shield");
//        Storage.addProductInList("Revolution Shield");
//        //spears
//        Storage.addProductInList("Great Axe");
//        Storage.addProductInList("Scorpion");
//        Storage.addProductInList("Lance");
//        Storage.addProductInList("Lance");
//        Storage.addProductInList("Lance");
//
//        //daggers
//        Storage.addProductInList("Crystal Dagger");
//        Storage.addProductInList("Dark Screamer");
//        Storage.addProductInList("Doom Dagger");
//        //bows
//        Storage.addProductInList("Crystallized Ice Bow");
//        Storage.addProductInList("Light Crossbow");
//        Storage.addProductInList("Akat Long Bow");
//        //staffs
//        Storage.addProductInList("Flaming Dragon Skull");
//        Storage.addProductInList("Staff of Life");
//        Storage.addProductInList("Staff of Life");
//        Storage.addProductInList("Staff of Life");
//        Storage.addProductInList("Demon Staff");
//        Storage.addProductInList("Demon Staff");
//        Storage.addProductInList("Demon Staff");
//
//
//        //products.insertMany(Storage.getStorage());
//
//
//        //Storage.getStorage().forEach(product -> System.out.println(product.getName()));
//        myNet.forEach(p -> System.out.println(p.getProductName() + " - " + p.getCost() + " golds in " + p.getGroceryName()));
//
//        Storage.getProduct("Demon Staff", 150, "Giran");
//        Storage.getProduct("Demon Staff", 160, "Oren");
//        Storage.getProduct("Demon Staff", 170, "Aden");
//
//        Storage.getProduct("Lance", 250, "Aden");
//        Storage.getProduct("Lance", 240, "Giran");
//        Storage.getProduct("Lance", 260, "Oren");
//
//        Storage.getProduct("Staff of Life", 210, "Oren");
//        Storage.getProduct("Staff of Life", 200, "Giran");
//        Storage.getProduct("Staff of Life", 190, "Aden");
//
//        Storage.getProduct("Flaming Dragon Skull", 220, "Giran");
//        Storage.getProduct("Akat Long Bow", 170, "Oren");
//        Storage.getProduct("Light Crossbow", 190, "Giran");
//        Storage.getProduct("Crystallized Ice Bow", 250, "Oren");
//        Storage.getProduct("Doom Dagger", 240, "Aden");
//        Storage.getProduct("Great Axe", 260, "Giran");
//        Storage.getProduct("Scorpion", 230, "Oren");
//
//        Storage.getProduct("Dynasty Sword", 150, "Aden");
//        Storage.getProduct("Dynasty Sword", 170, "Oren");
//        Storage.getProduct("Dynasty Sword", 200, "Giran");
//
//        Storage.getProduct("Dynasty Shield", 100, "Aden");
//        Storage.getProduct("Sword of Revolution", 220, "Aden");
//
//        products.insertMany(Storage.getStorage());
////        collection.insertMany(myNet);
////        collection.aggregate(List.of(Aggregates.group("$productName", Accumulators.max("cost", 2))));

   // }


}
