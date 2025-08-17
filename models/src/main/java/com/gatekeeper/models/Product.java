package com.gatekeeper.models;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Product {
    private int  id;
    private String name;
    private int price;
}
