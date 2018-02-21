package com.entelgy.demo.bean;

/**
 * Created on 16/02/2018.
 *
 * @author Entelgy
 */
public class Movement {

    public Movement(int id, String date, String hour, String amount, String currency) {
        this.id = id;
        this.date = date;
        this.hour = hour;
        this.amount = amount;
        this.currency = currency;
    }

    private int id;
    private String date;
    private String hour;
    private String amount;
    private String currency;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
