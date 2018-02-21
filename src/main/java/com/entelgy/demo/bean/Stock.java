package com.entelgy.demo.bean;

import java.util.Objects;

/**
 * Created on 19/02/2018.
 *
 * @author Entelgy
 */
public class Stock {
    private Product product;
    private Local local;
    private int cantComprada;
    private int cantDisponible;

    public Stock() {
    }

    public Stock(Product product, Local local, int cantDisponible) {
        this.product = product;
        this.local = local;
        this.cantDisponible = cantDisponible;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Local getLocal() {
        return local;
    }

    public void setLocal(Local local) {
        this.local = local;
    }

    public int getCantComprada() {
        return cantComprada;
    }

    public void setCantComprada(int cantComprada) {
        this.cantComprada = cantComprada;
    }

    public int getCantDisponible() {
        return cantDisponible;
    }

    public void setCantDisponible(int cantDisponible) {
        this.cantDisponible = cantDisponible;
    }

    public void disminuir(int requestQuantity){
        cantComprada+=requestQuantity;
        cantDisponible-=requestQuantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Stock stock = (Stock) o;
        return Objects.equals(getProduct(), stock.getProduct()) &&
                Objects.equals(getLocal(), stock.getLocal());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getProduct(), getLocal());
    }
}
