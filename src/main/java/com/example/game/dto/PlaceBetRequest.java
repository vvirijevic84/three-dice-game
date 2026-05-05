package com.example.game.dto;

import jakarta.validation.constraints.*;
import lombok.Data;
import java.math.BigDecimal;

@Data
public class PlaceBetRequest {

    @NotNull
    private Long playerId;

    @NotNull
    @DecimalMin("0.01")
    private BigDecimal stake;

    @NotNull
    private Integer predictedProduct;
}
