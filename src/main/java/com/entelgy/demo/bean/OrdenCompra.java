package com.entelgy.demo.bean;

import java.math.BigDecimal;

/**
 * Created on 19/02/2018.
 *
 * @author Entelgy
 */
public class OrdenCompra {
    private String code;
    private String account;
    private String dni;
    private String reservationCode;
    private Local local;
    private int requestQuantity;
    private Product product;
    private String email;
    private BigDecimal amount;

    public OrdenCompra() {
    }

    public OrdenCompra(String reservationCode, Local local, int requestQuantity, Product product) {
        this.reservationCode = reservationCode;
        this.local = local;
        this.requestQuantity = requestQuantity;
        this.product = product;
    }

    public void calculateAmount(){
        amount = product.getAmount().multiply(new BigDecimal(requestQuantity));
    }

    public String getReservationCode() {
        return reservationCode;
    }

    public void setReservationCode(String reservationCode) {
        this.reservationCode = reservationCode;
    }

    public Local getLocal() {
        return local;
    }

    public void setLocal(Local local) {
        this.local = local;
    }

    public int getRequestQuantity() {
        return requestQuantity;
    }

    public void setRequestQuantity(int requestQuantity) {
        this.requestQuantity = requestQuantity;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }
}
