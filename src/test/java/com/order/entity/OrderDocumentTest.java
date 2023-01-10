package com.order.entity;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class OrderDocumentTest {

    @Test
    void whenCalculateOrderPriceWithProductsThenShouldReturnCalculatedPrice() {
        final double excpectedPrice = 10_000;

        var order = OrderDocument.builder()
                .products(Arrays.asList(ProductDocument.builder()
                                .amount(3)
                                .price(3_000).build(),
                        ProductDocument.builder()
                                .amount(1)
                                .price(1_000)
                                .build()))
                .build();

        var orderPrice = order.getPrice();
        assertThat(orderPrice).isEqualTo(excpectedPrice);
    }
}
