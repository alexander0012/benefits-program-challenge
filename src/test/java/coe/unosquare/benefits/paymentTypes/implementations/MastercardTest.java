/*
 * package-info.java
 * 1.0
 * 2023-03-12
 * Copyright 2023
 * Any illegal reproduction of this content will result in immediate legal action.
 */

package coe.unosquare.benefits.paymentTypes.implementations;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MastercardTest {

    Mastercard mastercard;

    @BeforeEach
    void setup() {
        mastercard = new Mastercard();
    }
    @Test
    void discountOf8ForLessThan75TotalAmount() {
        Double discount = mastercard.getDiscount(74);
        assertEquals(0.08, discount);
    }
    @Test
    void discountOf12ForBetween75AndLess100TotalAmount() {
        Double discount = mastercard.getDiscount(75);
        assertEquals(0.12, discount);
    }
    @Test
    void discountOf17ForMoreThan100TotalAmount() {
        Double discount = mastercard.getDiscount(100);
        assertEquals(0.17, discount);
    }
}