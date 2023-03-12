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

import static org.junit.jupiter.api.Assertions.*;

class VisaTest {

    Visa visa;

    @BeforeEach
    void setup(){
        visa = new Visa();
    }
    @Test
    void discountOf5ForLessThan7Products() {
        Double discount = visa.getDiscount(6);
        assertEquals(0.05, discount);
    }
    @Test
    void discountOf10ForBetween7AndLess10Products() {
        Double discount = visa.getDiscount(7);
        assertEquals(0.10, discount);
    }
    @Test
    void discountOf15ForMoreThan10Products() {
        Double discount = visa.getDiscount(10);
        assertEquals(0.15, discount);
    }
}