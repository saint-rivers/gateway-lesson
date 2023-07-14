package com.saintrivers.productservice.router;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

import com.saintrivers.productservice.handler.HelloHandler;
import com.saintrivers.productservice.handler.ProductHandler;

@Configuration
public class Router {

    @Bean
    public RouterFunction<ServerResponse> routeHelloController(
            HelloHandler helloHandler,
            ProductHandler productHandler) {

        return route()
                .GET("/products", accept(MediaType.APPLICATION_JSON), productHandler::findProducts)
                .GET("/hello", accept(MediaType.APPLICATION_JSON), helloHandler::hello)
                .build();
    }
}
