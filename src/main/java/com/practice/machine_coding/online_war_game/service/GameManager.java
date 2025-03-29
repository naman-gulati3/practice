package com.practice.machine_coding.online_war_game.service;

import com.practice.machine_coding.online_war_game.dto.Game;
import com.practice.machine_coding.online_war_game.dto.GameModeDTO;
import com.practice.machine_coding.online_war_game.dto.MatchRequest;
import com.practice.machine_coding.online_war_game.dto.Player;
import com.practice.machine_coding.online_war_game.dto.Team;
import java.util.List;
import java.util.Optional;

public interface GameManager {

  boolean findGame(MatchRequest request) throws InterruptedException;

  Optional<Game> startGame();

  /** form teams */
  Team teamUp(GameModeDTO mode, List<Player> players);
}
