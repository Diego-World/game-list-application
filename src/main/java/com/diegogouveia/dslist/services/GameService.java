package com.diegogouveia.dslist.services;

import com.diegogouveia.dslist.dto.GameDTO;
import com.diegogouveia.dslist.dto.GameMinDTO;
import com.diegogouveia.dslist.entities.Game;
import com.diegogouveia.dslist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

// Responsável por armazenar regras de negócio.

@Service
public class GameService {
    @Autowired // Injeção de dependência (Componente = service)
    private GameRepository gameRepository;


    @Transactional(readOnly = true)
    public GameDTO findById(@PathVariable Long id){
        Game result = gameRepository.findById(id).get();
        //Aqui cabe um tratamento de exception caso o id não exista por exemplo.
        return new GameDTO(result);
//        return result;
    }

    @Transactional(readOnly = true)
    public List<GameMinDTO> findaAll(){
        List<Game> result = gameRepository.findAll();
        List<GameMinDTO> dto = result.stream().map(x->new GameMinDTO(x)).toList();
//        return result.stream().map(x->new GameMinDTO(x)).toList(); Também pode ser retornado dessa forma
        return dto;
    }



}
