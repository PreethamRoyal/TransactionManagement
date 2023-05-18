package net.javaguides.springboottransactionmanagementdemo.service.impl;

import net.javaguides.springboottransactionmanagementdemo.dto.OrderRequest;
import net.javaguides.springboottransactionmanagementdemo.dto.OrderResponse;
import net.javaguides.springboottransactionmanagementdemo.entity.Order;
import net.javaguides.springboottransactionmanagementdemo.entity.Payment;
import net.javaguides.springboottransactionmanagementdemo.exception.PaymentException;
import net.javaguides.springboottransactionmanagementdemo.repository.OrderRepository;
import net.javaguides.springboottransactionmanagementdemo.repository.PaymentRepository;
import net.javaguides.springboottransactionmanagementdemo.service.OrderService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
public class OrderServiceImpl implements OrderService {

    private OrderRepository orderRepository;
    private PaymentRepository paymentRepository;

    public OrderServiceImpl(OrderRepository orderRepository, PaymentRepository paymentRepository) {
        this.orderRepository = orderRepository;
        this.paymentRepository = paymentRepository;
    }

    @Override
    @Transactional
    public OrderResponse placeOrder(OrderRequest orderRequest) {

        Order order=orderRequest.getOrder();
        order.setStatus("INPROGRESS");
        order.setOrderTrackingNumber(UUID.randomUUID().toString());
        orderRepository.save(order);

        Payment payment=orderRequest.getPayment();

        if(!payment.getType().equals("DEBIT")){

            throw new PaymentException("Payment Card Type Dont Support");

        }
        payment.setOrderId(order.getId());
        paymentRepository.save(payment);


        OrderResponse orderResponse=new OrderResponse();
        orderResponse.setOrderTrackingNumber(order.getOrderTrackingNumber());
        orderResponse.setStatus(order.getStatus());
        orderResponse.setMessage("SUCCESS");


        return orderResponse;
    }
}
