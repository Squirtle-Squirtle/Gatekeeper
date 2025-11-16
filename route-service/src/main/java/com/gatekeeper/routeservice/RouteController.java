package com.gatekeeper.routeservice;

import com.gatekeeper.models.Route;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/routes")
public class RouteController {

    private final RouteService routeService;

    public RouteController(RouteService routeService) {
        this.routeService = routeService;
    }

    // Get all routes
    @GetMapping
    public ResponseEntity<List<Route>> getAllRoutes() {
        return ResponseEntity.ok(routeService.getAllRoutes());
    }

    // Get route by ID
    @GetMapping("/{id}")
    public ResponseEntity<Route> getRouteById(@PathVariable Long id) {
        return routeService.getRouteById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Add new route
    @PostMapping
    public ResponseEntity<Route> addRoute(@RequestBody Route route) {
        log.info("Adding route {}", route);
        Route savedRoute = routeService.addRoute(route);
        return ResponseEntity.ok(savedRoute);
    }

    // Update route
    @PostMapping("/{id}")
    public ResponseEntity<Route> updateRoute(@PathVariable Long id, @RequestBody Route route) {
        Route updatedRoute = routeService.updateRoute(id, route);
        return ResponseEntity.ok(updatedRoute);
    }

    // Delete route
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteRoute(@PathVariable Long id) {
        routeService.deleteRoute(id);
        return ResponseEntity.ok("Route deleted successfully");
    }


}
