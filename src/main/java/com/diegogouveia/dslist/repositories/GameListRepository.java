package com.diegogouveia.dslist.repositories;


import com.diegogouveia.dslist.entities.GameList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameListRepository extends JpaRepository<GameList, Long> {

}
