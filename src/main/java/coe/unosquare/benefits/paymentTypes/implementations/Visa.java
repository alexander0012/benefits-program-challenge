/*
 * package-info.java
 * 1.0
 * 2023-03-12
 * Copyright 2023
 * Any illegal reproduction of this content will result in immediate legal action.
 */

package coe.unosquare.benefits.paymentTypes.implementations;

import coe.unosquare.benefits.paymentTypes.IDiscounting;

/**
 * Class related for VISA payments applying policies, discounts or any other rule for this kind of payment.
 */
public class Visa implements IDiscounting {
    /**
     * Returns the discount value related with a VISA payment type. This discount is linked with the number of products in the Order.
     *
     * @param value Number of products that will help to determinate the percentage number of the discount
     * @return Discount value from the Order, according to the number of products in the Order
     */
    @Override
    public Double getDiscount(final Number value) {
        Integer sumProducts = value.intValue();

        if (sumProducts >= 10) {
            return 0.15;
        } else if (sumProducts >= 7) {
            return 0.10;
        } else {
            return 0.05;
        }
    }
}
