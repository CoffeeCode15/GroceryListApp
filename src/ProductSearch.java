package GroceryListApp.src;

import java.util.HashMap;
import java.util.Map;

public class ProductSearch {
    private Map<String, Product> productMap = new HashMap<>();

    public void addProduct(Product product) {
        productMap.put(product.getName(), product);
    }

    public Product findProduct(String productName) {
        return productMap.get(productName);
    }
}
