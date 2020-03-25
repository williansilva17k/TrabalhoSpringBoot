package com.br.store.controller.impl;

import com.br.store.controller.GameController;
import com.br.store.model.Game;
import com.br.store.repository.GameRepository;
import com.br.store.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;

@Controller
public class GameControllerImpl implements GameController {

    @Autowired
    GameService GameService;

    @Override
    public String test() {
        return "Ok";
    }

    @Override
    public ResponseEntity gameAll() {

        List<Game> games = GameService.returnGame();

        return new ResponseEntity(games, HttpStatus.OK);
    }

    @Override
    public ResponseEntity gameById(Long id) {
        Optional<Game> game = GameService.returnGameById(id);

        return new ResponseEntity(game, HttpStatus.OK);
    }

    @Override
    public ResponseEntity createGame(Game game) {
        HttpStatus httpStatus = GameService.createGame(game);
        return new ResponseEntity(game, httpStatus);
    }

    @Override
    public ResponseEntity updateGame(Game game, Long id) {
        HttpStatus httpStatus = GameService.updateGame(id, game);
        return new ResponseEntity(game, httpStatus);

    }

    @Override
    public ResponseEntity deleteGame(Long id) {
        HttpStatus httpStatus = GameService.deleteGame(id);
        return new ResponseEntity(httpStatus);
    }
}
