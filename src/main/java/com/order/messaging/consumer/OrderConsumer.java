package com.order.messaging.consumer;

import com.order.messaging.DefaultConsumer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.avro.specific.SpecificRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class OrderConsumer implements DefaultConsumer {

    @KafkaListener(topics = "${kafka.topics.order-created}", groupId = "${kafka.config.group-id}")
    public void consume(SpecificRecord record) {
        log.info("Message received with payload {}", record);
    }
}
