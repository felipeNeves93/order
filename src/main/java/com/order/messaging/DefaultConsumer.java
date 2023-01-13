package com.order.messaging;

import org.apache.avro.specific.SpecificRecord;

public interface DefaultConsumer {

    void consume(SpecificRecord payload);
}
