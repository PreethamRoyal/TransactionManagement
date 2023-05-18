package net.javaguides.springboottransactionmanagementdemo.dto;

import lombok.Getter;
import lombok.Setter;
import net.javaguides.springboottransactionmanagementdemo.entity.Order;
import net.javaguides.springboottransactionmanagementdemo.entity.Payment;

@Getter
@Setter
public class OrderRequest {
    private Order order;
    private Payment payment;

    //We use dto to actually send data from client to server


}
