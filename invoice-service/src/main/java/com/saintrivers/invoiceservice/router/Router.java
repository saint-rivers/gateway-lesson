package com.saintrivers.invoiceservice.router;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

import com.saintrivers.invoiceservice.handler.HelloHandler;
import com.saintrivers.invoiceservice.handler.InvoiceHandler;

@Configuration
public class Router {

    @Bean
    public RouterFunction<ServerResponse> routeHelloController(
            HelloHandler helloHandler,
            InvoiceHandler productHandler) {

        return route()
                .GET("/invoices", accept(MediaType.APPLICATION_JSON), productHandler::findInvoices)
                .GET("/hello", accept(MediaType.APPLICATION_JSON), helloHandler::hello)
                .build();
    }
}
