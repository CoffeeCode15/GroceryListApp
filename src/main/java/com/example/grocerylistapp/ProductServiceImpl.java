package com.example.grocerylistapp;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    
    private ProductRepository productRepository;
    
    @Override
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }
    
    @Override
    public Product getProductById(int userId) {
        Optional<Product> optionalProduct = productRepository.findById(userId);
        return optionalProduct.get();
    }
    
    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
    
    @Override
    public Product updateProduct(Product product) {
        Product existingProduct = productRepository.findById(product.getId()).get();
        existingProduct.setName(product.getName());
        existingProduct.setQuantity(product.getQuantity());
        existingProduct.setPrice(product.getPrice());
        existingProduct.setCompleted(product.isCompleted());
        Product updatedProduct = productRepository.save(existingProduct);
        return updatedProduct;
    }
    
    @Override
    public void deleteProduct(int userId) {
        productRepository.deleteById(userId);
    }
}
