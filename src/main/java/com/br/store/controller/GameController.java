package com.br.store.controller;

import com.br.store.model.Game;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@ResponseBody
@RequestMapping(path = "/")
public interface GameController {

    @GetMapping(path = "/")
    String test();

    @GetMapping(path = "/Game")
    ResponseEntity gameAll();

    @GetMapping(path = "/Game/{id}")
    ResponseEntity gameById(@PathVariable Long id);

    @PostMapping(path = "/Game")
    ResponseEntity createGame(@RequestBody Game game);

    @PutMapping(path = "Game/{id}")
    ResponseEntity updateGame(@RequestBody Game game, @PathVariable Long id);

    @DeleteMapping(path = "Game/{id}")
    ResponseEntity deleteGame(@PathVariable Long id);

}
