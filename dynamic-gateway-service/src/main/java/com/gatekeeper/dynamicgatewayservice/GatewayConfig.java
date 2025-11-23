//package com.gatekeeper.dynamicgatewayservice;
//
//import com.gatekeeper.models.Route;
//import org.springframework.cloud.gateway.route.*;
//import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
//import org.springframework.context.annotation.*;
//
//import java.net.URI;
//import java.util.List;
//
//@Configuration
//public class GatewayConfig {
//
//    @Bean
//    public RouteLocator dynamicRoutes(RouteLocatorBuilder builder,
//                                      DynamicRouteService dynamicRoutesService,
//                                      RateLimiterConfig rateLimiterConfig) {
//
//        List<Route> routes = dynamicRoutesService.loadRoutes();
//
//        RouteLocatorBuilder.Builder routesBuilder = builder.routes();
//
//        routes.forEach(r -> routesBuilder.route(
//                r.getId().toString(),
//                p -> p.path(r.getPath())
//                        .filters(f -> f.requestRateLimiter(c -> {
//                            c.setKeyResolver(rateLimiterConfig.userKeyResolver());
//                            c.setRateLimiter(rateLimiterConfig.redisRateLimiter());
//                        }))
//                        .uri(URI.create(r.getDestinationUri()))
//        ));
//
//        return routesBuilder.build();
//    }
//}
