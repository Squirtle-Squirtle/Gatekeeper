package com.gatekeeper.routeservice;

import com.gatekeeper.models.Route;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

@Repository
public interface RouteRepo extends JpaRepository<Route,Long> {
    Optional<Route> findByPath(String path);
    boolean existsByPath(String path);
}
