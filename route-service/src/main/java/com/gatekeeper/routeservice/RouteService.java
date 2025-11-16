package com.gatekeeper.routeservice;

import com.gatekeeper.models.Route;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RouteService {

    private final RouteRepo routeRepo;

    public RouteService(RouteRepo routeRepo) {
        this.routeRepo = routeRepo;
    }

    public List<Route> getAllRoutes() {
        return routeRepo.findAll();
    }

    public Optional<Route> getRouteById(Long id) {
        return routeRepo.findById(id);
    }

    public Route addRoute(Route route) {
        if (routeRepo.existsByPath(route.getPath())) {
            throw new IllegalArgumentException("Route with this path already exists");
        }
        return routeRepo.save(route);
    }

    public Route updateRoute(Long id, Route updatedRoute) {
        Route route = routeRepo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Route not found"));
        route.setPath(updatedRoute.getPath());
        route.setDestinationUri(updatedRoute.getDestinationUri());
        route.setMethods(updatedRoute.getMethods());
        return routeRepo.save(route);
    }

    public void deleteRoute(Long id) {
        if (!routeRepo.existsById(id)) {
            throw new IllegalArgumentException("Route not found");
        }
        routeRepo.deleteById(id);
    }
}
