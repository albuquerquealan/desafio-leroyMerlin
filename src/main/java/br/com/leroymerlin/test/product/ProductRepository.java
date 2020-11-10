package br.com.leroymerlin.test.product;

import br.com.leroymerlin.test.product.entity.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends CrudRepository<Product, Double> {
    List<Product> findByLm(Double lm);
}
