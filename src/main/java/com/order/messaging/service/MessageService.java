package com.order.messaging.service;

public interface MessageService<T> {

    void send(String destination, T payload);
}
