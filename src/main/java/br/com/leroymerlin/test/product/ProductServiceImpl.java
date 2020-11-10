package br.com.leroymerlin.test.product;

import br.com.leroymerlin.test.product.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository repository;

    @Override
    public List<Product> listAllProducts() {
        return (List<Product>) repository.findAll();
    }

    @Override
    public List<Product> findProductByLm(Double lm) {
        return repository.findByLm(lm);
    }

    @Override
    public void deleteProduct(Double lm) {
        repository.deleteById(lm);
    }

    @Override
    public Product editProduct(Double lm, Product product) {
        product = Product.builder()
                .withLm(lm)
                .withName(product.getName())
                .withFreeShipping(product.getFreeShipping())
                .withDescription(product.getDescription())
                .withPrice(product.getPrice())
                .build();
        return repository.save(product);
    }

    @Override
    public List<Product> saveAll(List<Product> products) {
        return (List<Product>) repository.saveAll(products);
    }
}
