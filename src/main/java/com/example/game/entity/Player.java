package com.example.game.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal;

@Entity
@Data
public class Player {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private BigDecimal balance;
}
