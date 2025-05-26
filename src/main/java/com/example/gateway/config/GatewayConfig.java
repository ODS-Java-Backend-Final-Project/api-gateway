package com.example.gateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {
    @Bean
    public RouteLocator routeLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("board-game_service", r -> r.path("/api/board-games/**")
                        .uri("lb://board-game-service"))
                .route("event_service", r -> r.path("/api/events/**")
                        .uri("lb://event-service"))

                        .build();
    }
}
