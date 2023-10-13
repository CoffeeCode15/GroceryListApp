package com.example.grocerylistapp;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false, unique = true)
    private String name;
    @Column(nullable = false)
    private int quantity;
    @Column(nullable = false)
    private float price;
    @Column(nullable = false)
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
        ;
    }
    
    public Product() {
    }
    
    public Product(int id, String name, int quantity, float price, boolean completed) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.completed = completed;
    }
    
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public void setCompleted(boolean completed) {
        this.completed = completed;
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
    
    public int getId() {
        return id;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return id == product.id && quantity == product.quantity && Float.compare(price, product.price) == 0 && completed == product.completed && Objects.equals(name, product.name);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(id, name, quantity, price, completed);
    }
    
    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                ", completed=" + completed +
                '}';
    }
}

