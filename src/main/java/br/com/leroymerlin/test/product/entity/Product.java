package br.com.leroymerlin.test.product.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table
public class Product {
    @Id
    private Double lm;
    private String name;
    private Boolean freeShipping;
    private String description;
    private BigDecimal price;
    private Double category;

    public Product() {
        //to serialize
    }

    public Product(Builder builder) {
        this.name = builder.name;
        this.description = builder.description;
        this.lm = builder.lm;
        this.freeShipping = builder.freeShipping;
        this.price = builder.price;
        this.category = builder.category;
    }

    public static Builder builder() {
        return new Builder();
    }

    public Double getLm() {
        return lm;
    }

    public String getName() {
        return name;
    }

    public Boolean getFreeShipping() {
        return freeShipping;
    }

    public String getDescription() {
        return description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Double getCategory() {
        return category;
    }

    public static final class Builder {
        private Double lm;
        private String name;
        private Boolean freeShipping;
        private String description;
        private BigDecimal price;
        private Double category;

        private Builder() {
        }


        public Builder withLm(Double lm) {
            this.lm = lm;
            return this;
        }

        public Builder withName(String name) {
            this.name = name;
            return this;
        }

        public Builder withFreeShipping(Boolean freeShipping) {
            this.freeShipping = freeShipping;
            return this;
        }

        public Builder withDescription(String description) {
            this.description = description;
            return this;
        }

        public Builder withPrice(BigDecimal price) {
            this.price = price;
            return this;
        }

        public Builder withCategory(Double category) {
            this.category = category;
            return this;
        }

        public Product build() {
            return new Product(this);
        }
    }
}
