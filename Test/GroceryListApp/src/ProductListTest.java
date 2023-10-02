package GroceryListApp.src;



import org.junit.jupiter.api.Test;
import java.util.List;
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
        //test per verificare che il prodotto sia stato aggiunto alla lista.
    void findProductShouldFindExistingProduct() {
        ProductList productList = new ProductList();
        Product product = new Product("carta", 1, 1);
        productList.addProduct(product);

        Product foundProduct = productList.findProduct("carta");

        assertNotNull(foundProduct);
        assertEquals("carta", foundProduct.getName());
    }


    @Test
        // Test per verificare che il prodotto non è presente.
    void findProductShouldNotFindNonExistingProduct() {

        ProductList productList = new ProductList();
        Product foundProduct = productList.findProduct("prodotto_inesistente");
        assertNull(foundProduct);
    }

    @Test
        //Test per verificare il corretto inseirmento di un nuovo simbolo di valuta.
    void setSymbol() {
        ProductList productList = new ProductList();
        String newSymbol = "£";
        productList.setCurrencySymbol(newSymbol);
        assertEquals(newSymbol, productList.getCurrencySymbol());
    }

    @Test
        //Test per segnare con un marker il prodotto.
    void markProductComplete() {
        ProductList productList = new ProductList();
        Product product = new Product("carta", 1, 1);
        productList.addProduct(product);
        productList.markProductAsCompleted("carta");
        assertTrue(product.isCompleted());
    }
    @Test
    // test che verifica l'ordinamento alfabetico.
    void testSortingAlphabetical() {
        ProductList productList = new ProductList();
        productList.addProduct(new Product("banana", 2, 1.0f));
        productList.addProduct(new Product("mela", 3, 1.5f));
        productList.displayProductList(ProductList.SortMethods.ALPHABETICAL);

        List<Product> sortedList = productList.getProductList();
        assertEquals("banana", sortedList.get(0).getName());
        assertEquals("mela", sortedList.get(1).getName());
    }

    @Test
    //test che verifica l'ordinamento in base al prezzo.
    void testSortingByPrice() {
        ProductList productList = new ProductList();
        productList.addProduct(new Product("prodotto1", 2, 1.0f));
        productList.addProduct(new Product("prodotto2", 3, 1.5f));
        productList.displayProductList(ProductList.SortMethods.PRICE);

        List<Product> sortedList = productList.getProductList();
        assertEquals("prodotto1", sortedList.get(0).getName());
        assertEquals("prodotto2", sortedList.get(1).getName());
    }
}
