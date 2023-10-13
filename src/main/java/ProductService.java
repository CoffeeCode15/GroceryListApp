import java.util.List;

public interface ProductService {
    Product createProduct(Product product);
    
    Product getProductById(int userId);
    
    List<Product> getAllProducts();
    
    Product updateProduct(Product product);
    
    void deleteProduct(int userId);
}
