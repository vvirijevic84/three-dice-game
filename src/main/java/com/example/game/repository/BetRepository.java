package com.example.game.repository;

import com.example.game.entity.Bet;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface BetRepository extends JpaRepository<Bet, Long> {
    List<Bet> findTop10ByPlayerIdOrderByCreatedAtDesc(Long playerId);
}
