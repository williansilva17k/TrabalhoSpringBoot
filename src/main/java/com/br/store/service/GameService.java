package com.br.store.service;

import com.br.store.model.Game;
import org.springframework.http.HttpStatus;

import java.util.List;
import java.util.Optional;

public interface GameService {

    List<Game> returnGame();

    HttpStatus createGame(Game game);

    Optional<Game> returnGameById(Long id);

    HttpStatus updateGame(Long id, Game game);

    HttpStatus deleteGame(Long id);
}
