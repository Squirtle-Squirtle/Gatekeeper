package com.gatekeeper.dynamicgatewayservice;

import com.gatekeeper.models.Route;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Service
public class DynamicRouteService {

    private final WebClient client =
            WebClient.builder().baseUrl("http://localhost:8083").build();

    public List<Route> loadRoutes() {
        return client.get()
                .uri("/api/routes")
                .retrieve()
                .bodyToFlux(Route.class)
                .collectList()
                .block();
    }
}
