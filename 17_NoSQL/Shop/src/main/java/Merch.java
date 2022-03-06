import org.bson.types.ObjectId;

public class Merch {

    private String productName;
    private String groceryName;
    private int cost;

    public Merch() {
    }

    public Merch(String productName, String groceryName, int cost) {
        this.productName = productName;
        this.groceryName = groceryName;
        this.cost = cost;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getGroceryName() {
        return groceryName;
    }

    public void setGroceryName(String groceryName) {
        this.groceryName = groceryName;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }
}
