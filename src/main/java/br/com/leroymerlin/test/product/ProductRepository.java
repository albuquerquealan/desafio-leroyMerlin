package br.com.leroymerlin.test.product;

import br.com.leroymerlin.test.product.entity.Product;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface ProductRepository extends CrudRepository<Product, Double> {
    List<Product> findByLm(Double lm);
}
