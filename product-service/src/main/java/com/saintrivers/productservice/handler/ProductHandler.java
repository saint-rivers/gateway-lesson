package com.saintrivers.productservice.handler;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.saintrivers.productservice.model.Product;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class ProductHandler {
    private List<Product> products = new ArrayList<Product>() {
        {
            add(new Product(1, "Jack Daniels", 50, 20f));
            add(new Product(2, "Jameson", 42, 15f));
            add(new Product(3, "Johnny Walker", 20, 21.5f));
        }
    };

    public Mono<ServerResponse> findProducts(ServerRequest serverRequest) {
        var productsFlux = Flux.fromIterable(products);
        return ServerResponse.ok().body(productsFlux, Product.class);
    }
}
