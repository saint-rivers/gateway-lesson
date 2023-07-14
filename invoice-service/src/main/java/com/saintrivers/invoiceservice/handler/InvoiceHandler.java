package com.saintrivers.invoiceservice.handler;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.saintrivers.invoiceservice.model.Invoice;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class InvoiceHandler {

    private List<Invoice> products = new ArrayList<Invoice>() {
        {
            add(new Invoice(1, LocalDateTime.of(2023, 9, 15, 11, 11),
                    new ArrayList<>(Arrays.asList(new Integer[] { 1, 3 }))));

            add(new Invoice(2, LocalDateTime.of(2023, 5, 23, 13, 37),
                    new ArrayList<>(Arrays.asList(new Integer[] { 3, 2 }))));
        }
    };

    public Mono<ServerResponse> findInvoices(ServerRequest serverRequest) {
        var productsFlux = Flux.fromIterable(products);
        return ServerResponse.ok().body(productsFlux, Invoice.class);
    }
}
