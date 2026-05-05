package com.example.game.service;

import com.example.game.dto.*;
import com.example.game.entity.*;
import com.example.game.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Service
@RequiredArgsConstructor
public class GameService {

    private final PlayerRepository playerRepo;
    private final BetRepository betRepo;
    private final TransactionRepository txRepo;

    @Transactional
    public PlaceBetResponse placeBet(PlaceBetRequest request) {

        Player player = playerRepo.findById(request.getPlayerId())
                .orElseThrow();

        if (player.getBalance().compareTo(request.getStake()) < 0) {
            throw new RuntimeException("Insufficient balance");
        }

        int d1 = roll();
        int d2 = roll();
        int d3 = roll();

        int product = d1 * d2 * d3;

        int odds = (product < 9) ? 2 : (product < 120 ? 5 : 2);

        boolean won = product == request.getPredictedProduct();

        BigDecimal change = won
                ? request.getStake().multiply(BigDecimal.valueOf(odds))
                : request.getStake().negate();

        player.setBalance(player.getBalance().add(change));

        Bet bet = new Bet();
        bet.setPlayerId(player.getId());
        bet.setStake(request.getStake());
        bet.setPredictedProduct(request.getPredictedProduct());
        bet.setActualProduct(product);
        bet.setWon(won);
        bet.setDice1(d1);
        bet.setDice2(d2);
        bet.setDice3(d3);
        bet.setCreatedAt(LocalDateTime.now());

        betRepo.save(bet);

        Transaction tx = new Transaction();
        tx.setPlayerId(player.getId());
        tx.setAmount(change);
        tx.setType(won ? "WIN" : "LOSS");
        tx.setCreatedAt(LocalDateTime.now());

        txRepo.save(tx);

        return new PlaceBetResponse(
                List.of(d1, d2, d3),
                product,
                won ? "WON" : "LOST",
                player.getBalance()
        );
    }

    private int roll() {
        return ThreadLocalRandom.current().nextInt(1, 7);
    }
}
