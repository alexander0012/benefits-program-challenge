/*
 * package-info.java
 * 1.0
 * 2023-03-12
 * Copyright 2023
 * Any illegal reproduction of this content will result in immediate legal action.
 */

package coe.unosquare.benefits.paymentTypes;

/**
 * Interface that needs to be implemented for the classes related with the different types of payments that have or manage a discount.
 */
public interface IDiscounting {

    /**
     * Method that needs to be implemented the logic for determinate the amount of discount.
     *
     * @param value Parameter that will help for determinate and apply the rules to get the correct amount of discount.
     * @return Percentage of discount in decimal format that needs to be applied according to the value and rules implemented
     */
    Double getDiscount(Number value);
}
