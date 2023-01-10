package com.order.entity;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDocument;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@DynamoDBDocument
public class ProductDocument {

    private String id;
    private String name;
    private double price;
    private int amount;
}
