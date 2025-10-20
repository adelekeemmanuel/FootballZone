package com.pl.footballzone.player;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface PlayerRepository extends JpaRepository<Player, String> {

    Optional<Player> findByPlayerName(String playerName);

    void deleteByPlayerName(String playerName);

}



