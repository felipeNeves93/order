package com.order.messaging.consumer;

import com.order.entity.OrderDocument;
import com.order.messaging.DefaultConsumer;
import com.order.service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.avro.specific.SpecificRecord;
import org.modelmapper.ModelMapper;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class OrderConsumer implements DefaultConsumer {

    private final OrderService orderService;
    private final ModelMapper modelMapper;

    @KafkaListener(topics = "${kafka.topics.order-created}", groupId = "${kafka.config.group-id}")
    public void consume(SpecificRecord specificRecord) {
        log.info("Message received with payload {}", specificRecord);
        var convertedOrder = modelMapper.map(specificRecord, OrderDocument.class);

        log.info("Saving converted order with id {}", convertedOrder.getId());
        orderService.save(convertedOrder);

    }
}
