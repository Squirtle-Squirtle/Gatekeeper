package com.gatekeeper.orderservice;

import com.gatekeeper.models.Order;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrderService {

    private final OrderRepo orderRepo;
    public OrderService(OrderRepo orderRepo) {
        this.orderRepo = orderRepo;
    }

    public Order save(Order order) {
        return orderRepo.save(order);
    }

    public Optional<Order> getOrderDetails(long orderId) {
        return orderRepo.findByOrderId(orderId);
    }


}
