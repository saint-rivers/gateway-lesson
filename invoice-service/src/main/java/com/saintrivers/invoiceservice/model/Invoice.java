package com.saintrivers.invoiceservice.model;

import java.time.LocalDateTime;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Invoice {
    private Integer id;
    private LocalDateTime timestamp;
    private List<Integer> products;
}
