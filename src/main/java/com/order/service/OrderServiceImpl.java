package com.order.service;

import com.order.entity.OrderDocument;
import com.order.repositories.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    @Override
    public OrderDocument save(OrderDocument order) {
        order.calculatePrice();
        return orderRepository.save(order);
    }
}
