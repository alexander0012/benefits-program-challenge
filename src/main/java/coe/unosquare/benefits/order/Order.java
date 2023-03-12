/*
 *  Order
 *  1.0
 *  11/8/22, 8:28 PM
 *  Copyright (c) 2022 Unosquare
 *  Any illegal reproduction of this content will result in immediate legal action.
 */

package coe.unosquare.benefits.order;

import coe.unosquare.benefits.exceptions.OrderEmptyException;
import coe.unosquare.benefits.paymentTypes.IDiscounting;
import coe.unosquare.benefits.paymentTypes.PaymentType;
import coe.unosquare.benefits.paymentTypes.implementations.Mastercard;
import coe.unosquare.benefits.paymentTypes.implementations.Visa;
import coe.unosquare.benefits.product.Product;

import java.util.Map;

/**
 * Class that contains the logic for process a payment with its discount according to the payment type.
 */
public class Order {
    /**
     * Store the final list of products and quantity for each product.
     */
    private final Map<Product, Integer> products;

    /**
     * Constructor for create an Order with the products on it.
     *
     * @param productsMap Map with the Products ad a key and the value mapped is the total of that product in the order.
     */
    public Order(final Map<Product, Integer> productsMap) {
        products = productsMap;
    }

    /**
     * Method that process the payments according to the payment type used for know the amount of the order with its discount.
     * If the Products maps in the order is null or empty, returns a null value.
     *
     * @param paymentType Payment type used in the Order for process the payment and know the correct discount.
     * @return Value of the order once the discounts are applied according to the payment type got it. If the products object in the Order is null or empty, return a null value.
     */
    public Double pay(PaymentType paymentType) {

        if (products == null || products.isEmpty()) {
            new OrderEmptyException("There is not Products in the Order for process the pay.");
            return null;
        }

        Double amount = getAmount();
        IDiscounting discounting;

        switch(paymentType) {
            case VISA:
                Integer numberProducts = products.values().stream().mapToInt(Integer::intValue).sum();
                discounting = new Visa();
                return amount - amount*discounting.getDiscount(numberProducts);
            case MASTERCARD:
                discounting = new Mastercard();
                return amount - amount*discounting.getDiscount(amount);
        }

        return amount;
    }

    /**
     * Method that calculates the total amount of the products in the Order without consider any discount related.
     *
     * @return Total amount from the Order before any discount applicable.
     */
    private Double getAmount() {
        return products.entrySet()
                .stream()
                .mapToDouble(product -> product.getKey().getPrice() * product.getValue())
                .sum();
    }

    /**
     * Method to help for print the info from each product into the Order with its quantity in the Order.
     */
    public void print() {
         products.forEach((product, quantity) ->
                 System.out.println("Product:{" + product.getName() + ","
                         + product.getPrice() + ","
                         + product.getType()
                         + "},Quantity:" + quantity
                         + ",Total:" + product.getPrice() * quantity));
    }
}
