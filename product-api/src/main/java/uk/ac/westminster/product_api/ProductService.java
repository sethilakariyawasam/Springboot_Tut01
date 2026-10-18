package uk.ac.westminster.product_api;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    private List<Product> products = new ArrayList<>();
    private Long nextId = 1L;

    public List<Product> getAllProducts() {
        return products;
    }

    public Product addProduct(Product product) {
        product.setId(nextId++);
        products.add(product);
        return product;
    }
    public Product getById(Long id) {
        for (Product product : products) {
            if (product.getId().equals(id)) {
                return product;
            }
        }
        return null;
    }
    public Product updateProduct(Long id, Product updatedProduct) {
        for (Product product : products) {
            if (product.getId().equals(id)) {
                product.setName(updatedProduct.getName());
                product.setPrice(updatedProduct.getPrice());
                return product;
            }
        }
        return null;
    }

    public boolean deleteProduct(Long id) {
        return products.removeIf(
                product -> product.getId().equals(id)
        );
    }
}
