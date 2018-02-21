package com.entelgy.demo.controller;

import com.entelgy.demo.bean.OrdenCompra;
import com.entelgy.demo.bean.OrdenEntrega;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created on 20/02/2018.
 *
 * @author Entelgy
 */
@RestController
public class DeliveryController {

    public OrdenEntrega deliver(
            OrdenCompra ordenCompra, String address) {
        OrdenEntrega ordenEntrega = new OrdenEntrega();
        ordenEntrega.setOrdenCompra(ordenCompra);
        ordenEntrega.setAddress(address);
        return ordenEntrega;
    }
}
