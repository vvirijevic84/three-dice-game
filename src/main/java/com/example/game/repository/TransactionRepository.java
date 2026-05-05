package com.example.game.repository;

import com.example.game.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    List<Transaction> findTop10ByPlayerIdOrderByCreatedAtDesc(Long playerId);
}
