package com.diegogouveia.dslist.services;

import com.diegogouveia.dslist.dto.GameListDTO;
import com.diegogouveia.dslist.dto.GameMinDTO;
import com.diegogouveia.dslist.entities.GameList;
import com.diegogouveia.dslist.projections.GameMinProjection;
import com.diegogouveia.dslist.repositories.GameListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class GameListService {
    @Autowired // Injeção de dependência (Componente = service)
    private GameListRepository gameListRepository;

    @Transactional(readOnly = true)
    public List<GameListDTO> findAll(){
        List<GameList> result = gameListRepository.findAll();
        return result.stream().map(GameListDTO::new).toList();
    }

}
