package com.zlrx.jooqdemo.controller;

import com.zlrx.jooqdemo.model.OrderItemData;
import com.zlrx.jooqdemo.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;

    @GetMapping("order-items/{batchId}")
    public List<OrderItemData> loadOrderItems(@PathVariable int batchId) {
        return orderRepository.findByBatchId(batchId);
    }


}
