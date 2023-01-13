package com.order.controller;

import com.order.avro.orders.OrderValue;
import com.order.controller.responses.ApiResponse;
import com.order.dto.OrderDTO;
import com.order.messaging.service.MessageService;
import lombok.RequiredArgsConstructor;
import org.apache.avro.specific.SpecificRecord;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/messages")
@RequiredArgsConstructor
public class MessageController {

    private final ModelMapper modelMapper;
    private final MessageService<SpecificRecord> messageService;

    @PostMapping
    public ResponseEntity<ApiResponse<OrderDTO>> save(@RequestBody OrderDTO dto) {
        var convertedOrder = modelMapper.map(dto, OrderValue.class);
        messageService.send("order-created", convertedOrder);
        return ResponseEntity.ok().build();
    }

}
