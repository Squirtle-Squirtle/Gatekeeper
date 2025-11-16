package com.gatekeeper.models;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "routes")
@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
@Getter
@Setter

public class Route {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String path; // Example: /api/products/**

    @Column(nullable = false)
    private String destinationUri; // Example: http://localhost:8082
    private String methods; // GET, POST, PUT, DELETE
}
