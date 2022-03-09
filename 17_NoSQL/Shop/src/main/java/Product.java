public class Product {

    private int cost;
    private String name;

    public Product() {}

    public Product(String name, int cost) {
        this.name = name;
        this.cost = cost;
    }

    public Product(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }
}
