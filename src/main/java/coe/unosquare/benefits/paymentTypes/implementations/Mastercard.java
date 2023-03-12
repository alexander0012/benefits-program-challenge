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
 * Class related for Mastercard payments applying policies, discounts or any other rule for this kind of payment.
 */
public class Mastercard implements IDiscounting {
    /**
     * Returns the discount value related with a Mastercard payment type. This discount is linked with the total amount from the Order.
     *
     * @param value Total amount from the Order that will help to determinate the percentage number of the discount
     * @return Discount value from the Order, according to the total amount from the Order
     */
    @Override
    public Double getDiscount(final Number value) {
        Double amount = value.doubleValue();

        if (amount >= 100) {
            return 0.17;
        } else if (amount >= 75) {
            return 0.12;
        } else {
            return 0.08;
        }
    }
}
