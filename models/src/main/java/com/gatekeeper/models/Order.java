package com.gatekeeper.models;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Order {
    private long orderId;
    private Product item;
    private int quantity;
}
