/*
 * package-info.java
 * 1.0
 * 2023-03-12
 * Copyright 2023
 * Any illegal reproduction of this content will result in immediate legal action.
 */

package coe.unosquare.benefits.exceptions;

/**
 * Exception thrown when an Order is empty. The Products map cannot be processed without products.
 */
public class OrderEmptyException extends Exception {

    /**
     * Constructor for create an OrderEmptyException in the Order object that wants to be paid.
     *
     * @param message Message to be displayed reporting the reason of the exception.
     */
    public OrderEmptyException(String message) {
        super(message);
    }
}
