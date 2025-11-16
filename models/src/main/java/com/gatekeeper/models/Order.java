package com.gatekeeper.models;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long orderId;
    @ManyToOne
    @JoinColumn(name = "item_id")
    private Product item;
    private int quantity;
    private OrderStatus status;
    private String userId;
}
