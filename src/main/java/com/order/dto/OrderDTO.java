package com.order.dto;

import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderDTO {
    private String id;
    private LocalDateTime creationDate;
    private CustomerDTO customer;
    private List<ProductDTO> products;


}
