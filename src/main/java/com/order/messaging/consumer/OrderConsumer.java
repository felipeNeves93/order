package com.order.messaging.consumer;

import com.order.avro.orders.OrderValue;
import com.order.messaging.DefaultConsumer;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OrderConsumer implements DefaultConsumer<OrderValue> {

    @KafkaListener(topics = "order-created", groupId = "order-avro-1")
    public void consume(OrderValue orderValue) {
        System.out.println(orderValue);
    }
}
