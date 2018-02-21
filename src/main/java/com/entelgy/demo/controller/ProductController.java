package com.entelgy.demo.controller;

import com.entelgy.demo.bean.Local;
import com.entelgy.demo.bean.OrdenCompra;
import com.entelgy.demo.bean.Stock;
import com.entelgy.demo.util.EntityMock;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created on 16/02/2018.
 *
 * @author Entelgy
 */
@RestController
@RequestMapping(path = "/products")
public class ProductController {

    private static final Logger LOG = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    private EntityMock mock;
    @Autowired
    private NotifierController notifierController;

    @RequestMapping(path = "/{product.id}/stock", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Stock> verifyStock(@PathVariable("product.id") String id,
                                               @RequestParam("request.quantity") int requestQuantity) {
        LOG.info("call verifyStock");
        LOG.debug("Received param id = {}, quantity = {}", id, requestQuantity);

        return new ResponseEntity(mock.getStocks().get(0), HttpStatus.OK);
    }


    @RequestMapping(path = "/{product.id}/stock", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<OrdenCompra> reserveStock(@PathVariable("product.id") String id,
                                                @RequestParam("request.quantity") int requestQuantity,
                                                @RequestParam("email") String email) {
        LOG.info("call reserveStock");
        LOG.debug("Received param id = {}", id);

        Local local = mock.getLocales().get(0);
        //Generar Otp
        String otp = EntityMock.OTP;
        //Notificar SMS (cel, otp)
        notifierController.sendEmail(email, otp);
        return new ResponseEntity(new OrdenCompra(EntityMock.RESERVATION_CODE,
                local, requestQuantity, mock.getProducts().get(0)), HttpStatus.OK);
    }

}
