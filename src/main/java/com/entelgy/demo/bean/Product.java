package com.entelgy.demo.bean;

import java.math.BigDecimal;
import java.util.Objects;

/**
 * Created on 19/02/2018.
 *
 * @author Entelgy
 */
public class Product {
    private String id;
    private String name;
    private BigDecimal amount;

    public Product() {
    }

    public Product(String id) {
        this.id = id;
    }

    public Product(String id, String name, BigDecimal amount) {
        this.id = id;
        this.name = name;
        this.amount =amount;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(getId(), product.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
