package com.example.game.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
public class PlaceBetResponse {

    private List<Integer> dice;
    private Integer product;
    private String status;
    private BigDecimal balance;
}
