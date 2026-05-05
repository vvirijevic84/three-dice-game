package com.example.game.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Data
public class Bet {

    @Id
    @GeneratedValue
    private Long id;

    private Long playerId;
    private BigDecimal stake;
    private Integer predictedProduct;

    private Integer actualProduct;
    private boolean won;

    private int dice1;
    private int dice2;
    private int dice3;

    private LocalDateTime createdAt;
}
