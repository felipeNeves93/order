package com.order.repositories.converters;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTypeConverter;

import java.time.LocalDateTime;

public class LocalDateTimeConverter implements DynamoDBTypeConverter<String, LocalDateTime> {

    @Override
    public String convert(LocalDateTime dateTime) {
        return dateTime.toString();
    }

    @Override
    public LocalDateTime unconvert(String dateTime) {
        return LocalDateTime.parse(dateTime);
    }
}
