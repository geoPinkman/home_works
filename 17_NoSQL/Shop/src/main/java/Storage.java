import java.util.ArrayList;
import java.util.List;

public class Storage {

    private static List<Product> productList = new ArrayList<>();

    public static List<Product> getStorage() {
        return productList;
    }

    public static void addProductInList(String name) {
        productList.add(new Product(name, 0));
    }

    public static boolean getProduct(String name, int cost, String shopName) {
        List<Product> toStore = new ArrayList<>(productList);
        for (Product product : toStore) {
            if (product.getName().equals(name)) {
                product.setCost(cost);
                Main.addMerch(product.getName(), shopName, product.getCost());
                productList.remove(product);
                break;
            }
        }
        return true;
    }

}
