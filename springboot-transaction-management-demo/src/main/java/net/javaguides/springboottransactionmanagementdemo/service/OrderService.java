package net.javaguides.springboottransactionmanagementdemo.service;

import net.javaguides.springboottransactionmanagementdemo.dto.OrderRequest;
import net.javaguides.springboottransactionmanagementdemo.dto.OrderResponse;

public interface OrderService {

    OrderResponse placeOrder(OrderRequest orderRequest);
}
