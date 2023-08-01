package GroceryListApp.src;

public class Product {
    private String name;
    private int quantity;
    private float price;

    public Product(String name) {
        this.name = name;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }
}
