package GroceryListApp.src;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductListTest {
    
    @Test
    void addProduct() {
        ProductList productList = new ProductList();
        assertTrue(productList.addProduct(new Product("carta", 1, 1)));
    }
    
    @Test
    void removeProduct() {
        ProductList productList = new ProductList();
        productList.addProduct(new Product("carta"));
        assertTrue(productList.removeProduct("carta"));
    }
    
    @Test
    void totalCalculationExpanse() {
        ProductList productList = new ProductList();
        productList.addProduct(new Product("carta", 1, 1));
        productList.addProduct(new Product("banana", 2, 1));
        float expectedSum = 3;
        assertEquals(expectedSum, productList.totalCalculationExpanse());
    }
    
    @Test
    void findProduct() {
    
    }
}