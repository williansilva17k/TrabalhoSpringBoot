package com.br.store.service.impl;

import com.br.store.model.Game;
import com.br.store.repository.GameRepository;
import com.br.store.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class GameServiceImpl implements GameService {

    @Autowired
    GameRepository GameRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Game> returnGame() {
        List<Game> bike = GameRepository.findAll();
        return bike;
    }

    @Override
    @Transactional
    public HttpStatus createGame(Game game) {
        GameRepository.save(game);

        if (GameRepository.findById(game.getId()) == null) {
            return HttpStatus.I_AM_A_TEAPOT;
        }
        return HttpStatus.CREATED;
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Game> returnGameById(Long id) {
        Optional<Game> bike = GameRepository.findById(id);
        return bike;
    }

    @Override
    public HttpStatus updateGame(Long id, Game game) {
        if (id == null) {
            return HttpStatus.NOT_FOUND;
        }
        game.setId(id);
        GameRepository.save(game);

        return HttpStatus.ACCEPTED;
    }

    @Override
    public HttpStatus deleteGame(Long id) {
        if (id == null) {
            return HttpStatus.NOT_FOUND;
        }
        GameRepository.deleteById(id);

        return HttpStatus.OK;
    }


}
