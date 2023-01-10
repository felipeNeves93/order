package com.order.controller;

import com.order.dto.OrderDTO;
import com.order.entity.OrderDocument;
import com.order.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {

    private final ModelMapper modelMapper;
    private final OrderService orderService;

    @PostMapping
    public ResponseEntity<ApiResponse<OrderDTO>> save(@RequestBody OrderDTO dto) {
        var convertedOrder = modelMapper.map(dto, OrderDocument.class);
        var savedOrder = orderService.save(convertedOrder);

        return ResponseEntity.ok(ApiResponse.<OrderDTO>builder()
                .object(modelMapper.map(savedOrder, OrderDTO.class))
                .status(HttpStatus.CREATED)
                .errorMessage(null)
                .build());
    }

}
