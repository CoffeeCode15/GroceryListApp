package GroceryListApp.src;

public class Product {
    private String name;
    private int quantity;
    private float price;
    private boolean completed;
    
    public Product(String name) {
        this.name = name;
        this.completed = false;
    }
    
    public Product(String name, int quantity, float price) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.completed = false;
    }
    
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    public void setPrice(float price) {
        this.price = price;
    }
    
    public void setCompleted() {
        completed = true;
    }
    
    public String getName() {
        return name;
    }
    
    public int getQuantity() {
        return quantity;
    }
    
    public float getPrice() {
        return price;
    }
    
    public boolean isCompleted() {
        return completed;
    }
}
