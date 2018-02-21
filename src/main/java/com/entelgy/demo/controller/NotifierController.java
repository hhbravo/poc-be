package com.entelgy.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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
@RequestMapping(value = "/notifier", produces = MediaType.APPLICATION_JSON_VALUE)
public class NotifierController {

    private static final Logger LOG = LoggerFactory.getLogger(NotifierController.class);

    @RequestMapping(value = "/sms", method = RequestMethod.POST)
    public ResponseEntity<?> sendSMS(@RequestParam(value = "phone.number") final String phoneNumber,
                                     @RequestParam(value = "message") final String message) {
        LOG.info("call sendSMS");
        LOG.info("Received param phone.number = {}", phoneNumber);
        LOG.info("Received param message = {}", message);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/email", method = RequestMethod.POST)
    public ResponseEntity<?> sendEmail(@RequestParam(value = "email") final String email,
                                       @RequestParam(value = "message") final String message) {
        LOG.info("call sendEmail");
        LOG.info("Received param email = {}", email);
        LOG.info("Received param message = {}", message);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
