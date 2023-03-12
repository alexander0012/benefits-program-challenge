/*
 *  OrderTest
 *  1.0
 *  11/8/22, 8:28 PM
 *  Copyright (c) 2022 Unosquare
 *  Any illegal reproduction of this content will result in immediate legal action.
 */

package coe.unosquare.benefits.order;

import coe.unosquare.benefits.paymentTypes.PaymentType;
import coe.unosquare.benefits.product.Product;
import coe.unosquare.benefits.util.ProductGenerator;
import org.junit.jupiter.api.Test;
import java.util.Map;
import static coe.unosquare.benefits.util.PayOrderSimulator.payOrder;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * The type Order test.
 */
class OrderTest {
    /**
     * Order with visa more than 10 products discount test.
     */
    @Test
    void orderWithVisaMoreThan10ProductsDiscountTest() {
        Map<Product, Integer> products = ProductGenerator.generateProducts(15);
        assertEquals(0.15, payOrder(products, PaymentType.VISA));
    }

    /**
     * Order with visa 10 products discount test.
     */
    @Test
    void orderWithVisa10ProductsDiscountTest() {
        Map<Product, Integer> products = ProductGenerator.generateProducts(10);
        assertEquals(0.15, payOrder(products, PaymentType.VISA));
    }

    /**
     * Order with visa 7 products discount test.
     */
    @Test
    void orderWithVisa7ProductsDiscountTest() {
        Map<Product, Integer> products = ProductGenerator.generateProducts(7);
        assertEquals(0.10, payOrder(products, PaymentType.VISA));
    }

    /**
     * Order with visa less than 7 products discount test.
     */
    @Test
    void orderWithVisaLessThan7ProductsDiscountTest() {
        Map<Product, Integer> products = ProductGenerator.generateProducts(5);
        assertEquals(0.05, payOrder(products, PaymentType.VISA));
    }

    /**
     * Order with visa more than 100 amount discount test.
     */
    @Test
    void orderWithVisaMoreThan100AmountDiscountTest() {
        Map<Product, Integer> products = ProductGenerator.generateProducts(150.0);
        assertEquals(0.17, payOrder(products, PaymentType.MASTERCARD));
    }

    /**
     * Order with visa 100 amount discount test.
     */
    @Test
    void orderWithVisa100AmountDiscountTest() {
        Map<Product, Integer> products = ProductGenerator.generateProducts(100.0);
        assertEquals(0.17, payOrder(products, PaymentType.MASTERCARD));
    }

    /**
     * Order with visa 75 amount discount test.
     */
    @Test
    void orderWithVisa75AmountDiscountTest() {
        Map<Product, Integer> products = ProductGenerator.generateProducts(75.0);
        assertEquals(0.12, payOrder(products, PaymentType.MASTERCARD));
    }

    /**
     * Order with mastercard less than 75 amount discount test.
     */
    @Test
    void orderWithMastercardLessThan75AmountDiscountTest() {
        Map<Product, Integer> products = ProductGenerator.generateProducts(50.0);
        assertEquals(0.08, payOrder(products, PaymentType.MASTERCARD));
    }
}
