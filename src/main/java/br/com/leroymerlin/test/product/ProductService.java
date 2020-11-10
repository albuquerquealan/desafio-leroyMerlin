package br.com.leroymerlin.test.product;

import br.com.leroymerlin.test.product.entity.Product;

import java.util.List;

public interface ProductService {
    List<Product> listAllProducts();

    List<Product> findProductByLm(Double lm);

    void deleteProduct(Double lm);

    Product editProduct(Double lm, Product product);

    List<Product> saveAll(List<Product> products);
}
