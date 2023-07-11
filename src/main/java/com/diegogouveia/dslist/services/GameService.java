package com.diegogouveia.dslist.services;

import com.diegogouveia.dslist.dto.GameMinDTO;
import com.diegogouveia.dslist.entities.Game;
import com.diegogouveia.dslist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameService {
    @Autowired // Injeção de dependência (Componente = service)
    private GameRepository gameRepository;
    public List<GameMinDTO> findaAll(){
        List<Game> result = gameRepository.findAll();
        List<GameMinDTO> dto = result.stream().map(x->new GameMinDTO(x)).toList();
//        return result.stream().map(x->new GameMinDTO(x)).toList(); Também pode ser retornado dessa forma
        return dto;
    }
}
