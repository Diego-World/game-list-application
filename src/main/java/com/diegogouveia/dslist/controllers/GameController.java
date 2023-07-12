package com.diegogouveia.dslist.controllers;

import com.diegogouveia.dslist.dto.GameDTO;
import com.diegogouveia.dslist.dto.GameMinDTO;
import com.diegogouveia.dslist.entities.Game;
import com.diegogouveia.dslist.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/games")
public class GameController {
    @Autowired
    private GameService gameService;

    @GetMapping(value = "/{id}")
    public GameDTO findById(@PathVariable Long id){
        GameDTO result = gameService.findById(id);
        return result;
    }

    @GetMapping
    public List<GameMinDTO> findAll(){
        List<GameMinDTO> dto = gameService.findaAll();
        return dto;
    }
}
