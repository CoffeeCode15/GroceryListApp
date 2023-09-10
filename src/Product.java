package GroceryListApp.src;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class Product {
    private String name;
    private int quantity;
    private float price;
    private boolean completed;

    public Product(String name) {
        this.name = name;
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

    public boolean isCompleted(){return completed;}
        }

    
    public boolean isCompleted() {
        return completed;
    }
}

