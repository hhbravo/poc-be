package com.entelgy.demo.bean;

/**
 * Created on 19/02/2018.
 *
 * @author Entelgy
 */
public class OrdenEntrega {
    private OrdenCompra ordenCompra;
    private String address;

    public OrdenCompra getOrdenCompra() {
        return ordenCompra;
    }

    public void setOrdenCompra(OrdenCompra ordenCompra) {
        this.ordenCompra = ordenCompra;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
