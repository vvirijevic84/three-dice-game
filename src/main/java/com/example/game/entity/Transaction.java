package com.example.game.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Data
public class Transaction {

    @Id
    @GeneratedValue
    private Long id;

    private Long playerId;
    private BigDecimal amount;
    private String type;

    private LocalDateTime createdAt;
}
