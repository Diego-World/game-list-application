package com.diegogouveia.dslist.repositories;

//Nome do dominio
// Se for Jogos = GameRepository
//Se fosse cliente = ClienteRepository
// Só conversa com o banco.

import com.diegogouveia.dslist.entities.Game;
import com.diegogouveia.dslist.projections.GameMinProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface GameRepository extends JpaRepository<Game, Long> {
    // nativeQuery é uma anotação para demarcar que a consulta será feita em SQL.
    @Query(nativeQuery = true, value = """
		SELECT tb_game.id, tb_game.title, tb_game.game_year AS `year`, tb_game.img_url AS imgUrl,
		tb_game.short_description AS shortDescription, tb_belonging.position
		FROM tb_game
		INNER JOIN tb_belonging ON tb_game.id = tb_belonging.game_id
		WHERE tb_belonging.list_id = :listId
		ORDER BY tb_belonging.position
			""")
            // O parâmetro no metódo abaixo é usado na query para selecionar a lista na qual será feita a listagem.
    List<GameMinProjection> searchByList(Long listId);
            // O resultado dessa consulta deve ser uma interface(Chamada de projection).
}
