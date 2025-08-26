package com.gatekeeper.models;


import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderDetails {
    private Order order;
    private OrderStatus status;
    private String userId;
}
