package com.entelgy.demo.exception;

/**
 * Created on 21/02/2018.
 *
 * @author Entelgy
 */
public class CustomException extends RuntimeException{
    public CustomException(String message) {
        super(message);
    }
}
