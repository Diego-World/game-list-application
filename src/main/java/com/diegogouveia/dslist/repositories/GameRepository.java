package com.diegogouveia.dslist.repositories;

//Nome do dominio
// Se for Jogos = GameRepository
//Se fosse cliente = ClienteRepository
// Só conversa com o banco.

import com.diegogouveia.dslist.entities.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, Long> {

}
