package com.entelgy.demo.controller;

import com.entelgy.demo.bean.Movement;
import com.entelgy.demo.exception.CustomException;
import com.entelgy.demo.util.EntityMock;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.entelgy.demo.util.EntityMock.ERROR_ACOUNT;

/**
 * Created on 16/02/2018.
 *
 * @author Entelgy
 */
@RestController
@RequestMapping(value = "/movements", produces = MediaType.APPLICATION_JSON_VALUE)
public class MovementController {

    private static final Logger LOG = LoggerFactory.getLogger(MovementController.class);
    @Autowired
    private EntityMock mock;
    @Autowired
    private NotifierController notifierController;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Movement>> getMovements(@RequestParam(value = "phone") final String phone,
                                                       @RequestParam(value = "account") final String account,
                                                       @RequestParam(value = "date") final String date) {
        LOG.info("call MovementController.getMovements");
        LOG.info("Received param account = {}", account);
        LOG.info("Received param date = {}", date);
        LOG.info("Received param phone = {}", phone);
        if (ERROR_ACOUNT.equals(account)) {
            throw new CustomException("Ocurrió un error al consultar los últimos movimientos");
        }
        notifierController.sendSMS(phone, "Test message");
        return new ResponseEntity<>(mock.getMovements(), HttpStatus.OK);
    }


    @RequestMapping(value = "/{movement.id}", method = RequestMethod.GET)
    public ResponseEntity<Movement> getMovement(@PathVariable("movement.id") String movementId) {
        LOG.info("call MovementController.getProduct");
        LOG.info("Received param phone.number = {}", movementId);

        return new ResponseEntity<>(mock.getMovements().get(0), HttpStatus.OK);
    }
}
