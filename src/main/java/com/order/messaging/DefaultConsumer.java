package com.order.messaging;

import org.apache.avro.specific.SpecificRecord;

public interface DefaultConsumer<T extends SpecificRecord> {

    void consume(T avro);
}
