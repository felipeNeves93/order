package com.order.repositories;

import com.order.entity.OrderDocument;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

@EnableScan
public interface OrderRepository extends CrudRepository<OrderDocument, String> {

}
