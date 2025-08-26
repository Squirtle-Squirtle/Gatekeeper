package com.gatekeeper.orderservice;

import com.gatekeeper.models.Order;
import com.gatekeeper.models.OrderDetails;
import com.gatekeeper.models.OrderStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/v1/order")
public class OrderController {

    private final AtomicLong seq = new AtomicLong(100);

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE, path = "/create")
    public ResponseEntity<OrderDetails> createOrder(@RequestBody Order order, @RequestHeader(value = "X-user-Id", required = false) String userId) {
        long id = seq.incrementAndGet();
        OrderDetails orderDetails = OrderDetails.builder().userId(userId).order(order).status(OrderStatus.ORDER_PLACED).build();
        return ResponseEntity.ok(orderDetails);
    }

    @GetMapping("/{orderId}")
    public ResponseEntity<OrderDetails> getOrder(@PathVariable long orderId) {
        Order order = Order.builder().build();
        OrderDetails orderDetails = OrderDetails.builder().userId("123").order(order).status(OrderStatus.ORDER_PLACED).build();
        return ResponseEntity.ok(orderDetails);
    }
}
