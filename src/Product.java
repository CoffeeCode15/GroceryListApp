package GroceryListApp.src;

public class Product {

    private String name;
    private int quantity;
    private float price;
    private boolean completed;
    //Aggiunzione di nextID insieme a int id per generare automaticamente un ID.
    // Il motivo è che causava problemi con uno dei test e con la tabella stessa.
    private static int nextId = 1;
    private int id;

    public Product(String name) {
        this.id = nextId++;
        this.name = name;
        this.completed = false;
    }



    public Product(String name, int quantity, float price) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.completed = false;
        this.id = nextId++;
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

    public int getId() {
        return id;
    }


}

