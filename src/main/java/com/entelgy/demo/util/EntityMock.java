package com.entelgy.demo.util;

import com.entelgy.demo.bean.Local;
import com.entelgy.demo.bean.Movement;
import com.entelgy.demo.bean.Product;
import com.entelgy.demo.bean.Stock;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created on 16/02/2018.
 *
 * @author Entelgy
 */
@Component
public class EntityMock {
    public static final String PRODUCT_STOCK = "PROD00001";
    public static final String PRODUCT_NO_STOCK = "PROD00002";
    public static final String OTP = "159357";
    public static final String RESERVATION_CODE = "R00001";
    public static final String OC_CODE = "OC00001";
    public static final String ERROR_ACOUNT = "999999";
    public static final String ERROR_OTP = "999999";

    private List<Product> products;
    private List<Local> locales;
    private List<Stock> stocks;

    @PostConstruct
    private void init() {
        initStocks();
    }



    public List<Movement> getMovements() {
        List<Movement> movements = new ArrayList<>();
        movements.add(new Movement(1, "2018-01-10", "12:34", "8192.83", "PEN"));
        movements.add(new Movement(2, "2018-12-11", "20:11", "453.33", "PEN"));
        movements.add(new Movement(3, "2018-09-12", "13:19", "943.7", "USD"));
        movements.add(new Movement(4, "2018-03-13", "23:44", "1133.21", "USD"));
        movements.add(new Movement(5, "2018-08-14", "09:22", "383.56", "PEN"));
        return movements;
    }

    private void initStocks() {
        products = new ArrayList<>();
        products.add(new Product(PRODUCT_STOCK, "Camisa Basement", new BigDecimal("80.00")));
        products.add(new Product(PRODUCT_NO_STOCK, "Zapatillas Adidas", new BigDecimal("240.00")));

        locales = new ArrayList<>();
        locales.add(new Local("LC0001", "Ripley San Isidro", "Las Begonias, San Isidro"));
        locales.add(new Local("LC0002", "Ripley Real Plaza Jesus María", "Av Salaverry, Jesus María"));

        stocks = new ArrayList<>();
        stocks.add(new Stock(products.get(0), locales.get(0), 5));
        stocks.add(new Stock(products.get(1), locales.get(1), 0));
    }

    public List<Product> getProducts() {
        return products;
    }

    public List<Local> getLocales() {
        return locales;
    }

    public List<Stock> getStocks() {
        return stocks;
    }
}
