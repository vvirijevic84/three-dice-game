package com.example.game.controller;

import com.example.game.dto.*;
import com.example.game.service.GameService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class GameController {

    private final GameService service;

    @PostMapping("/bet")
    public PlaceBetResponse placeBet(@Valid @RequestBody PlaceBetRequest request) {
        return service.placeBet(request);
    }
}
