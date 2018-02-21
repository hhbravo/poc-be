package com.entelgy.demo.controller;

import com.entelgy.demo.bean.Local;
import com.entelgy.demo.bean.OrdenCompra;
import com.entelgy.demo.bean.OrdenEntrega;
import com.entelgy.demo.bean.Product;
import com.entelgy.demo.exception.CustomException;
import com.entelgy.demo.util.EntityMock;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static com.entelgy.demo.util.EntityMock.ERROR_OTP;

/**
 * Created on 16/02/2018.
 *
 * @author Entelgy
 */
@RestController
@RequestMapping(path = "/oc", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
public class OrdenCompraController {

    private static final Logger LOG = LoggerFactory.getLogger(OrdenCompraController.class);

    @Autowired
    private EntityMock mock;
    @Autowired
    private NotifierController notifierController;
    @Autowired
    private DeliveryController deliveryController;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Product> registrar(
            @RequestParam("otp") String otp,
            @RequestParam("address") String address,
            @RequestBody OrdenCompra ordenCompra) {
        LOG.info("call registrar ");
        LOG.debug("otp {}", otp);
        LOG.debug("address {}", address);

        validarOtp(otp);

        OrdenCompra ordenCompraGenerada = generarOC(ordenCompra);

        disminuirStock(ordenCompraGenerada.getProduct(), ordenCompraGenerada.getRequestQuantity(), ordenCompraGenerada.getLocal());

        notifierController.sendEmail(ordenCompra.getEmail(), "Orden de Compra Generada ["+ordenCompra.getCode()+"]");

        OrdenEntrega ordenEntrega = deliveryController.deliver(ordenCompraGenerada, address);

        return new ResponseEntity(ordenEntrega, HttpStatus.OK);
    }

    private void validarOtp(String otp){
        if(ERROR_OTP.equals(otp)){
            throw new CustomException("[ER001] Verifique la clave generada");
        }
        LOG.info("OTP validado");
    }

    private OrdenCompra generarOC(OrdenCompra ordenCompra){
        ordenCompra.setCode(EntityMock.OC_CODE);
        ordenCompra.calculateAmount();
        return ordenCompra;
    }

    private void disminuirStock(Product product, int requestQuantity, Local local) {
        LOG.debug("Disminuyendo stock [producto={}, local={}, cantidadSolicitada={}]", product, local, requestQuantity);
        mock.getStocks().get(0).disminuir(requestQuantity);
        LOG.debug("Stock actualizado disponible [{}]", mock.getStocks().get(0).getCantDisponible());
        LOG.info("Stock disminuido");
    }
}
