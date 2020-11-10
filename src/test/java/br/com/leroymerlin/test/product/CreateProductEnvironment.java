package br.com.leroymerlin.test.product;

import br.com.leroymerlin.test.product.entity.Product;

import java.math.BigDecimal;

public class CreateProductEnvironment {
    public static Product correctForm() {
        return Product.builder()
                .withName("Product Test")
                .withDescription("Product created for test")
                .withFreeShipping(Boolean.TRUE)
                .withLm(123D)
                .withPrice(new BigDecimal("4250"))
                .build();
    }

    public static Product updatedForm() {
        return Product.builder()
                .withName("Product Updated")
                .withDescription("Product created for update")
                .withFreeShipping(Boolean.TRUE)
                .withLm(123D)
                .withPrice(new BigDecimal("5000"))
                .build();
    }
}
