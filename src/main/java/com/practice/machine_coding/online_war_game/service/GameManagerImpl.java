package com.practice.machine_coding.online_war_game.service;

import com.practice.machine_coding.online_war_game.dto.Game;
import com.practice.machine_coding.online_war_game.dto.GameModeDTO;
import com.practice.machine_coding.online_war_game.dto.MatchRequest;
import com.practice.machine_coding.online_war_game.dto.Player;
import com.practice.machine_coding.online_war_game.dto.Team;
import com.practice.machine_coding.online_war_game.repository.InGamePlayerStore;
import com.practice.machine_coding.online_war_game.repository.PlayersInQueueStore;
import java.util.List;
import java.util.Optional;

public class GameManagerImpl implements GameManager {

  private final PlayersInQueueStore playersInQueueStore;

  private final InGamePlayerStore inGamePlayerStore;

  public GameManagerImpl(
      PlayersInQueueStore playersInQueueStore,
      InGamePlayerStore inGamePlayerStore,
      InGamePlayerStore inGamePlayerStore1) {
    this.playersInQueueStore = playersInQueueStore;
    this.inGamePlayerStore = inGamePlayerStore1;
  }

  @Override
  public synchronized boolean findGame(MatchRequest request) throws InterruptedException {
    validatePlayerState(request.getPlayers());
    validateGameMode(request.getPlayers(), request.getGameMode());
    return false;
  }

  @Override
  public Optional<Game> startGame() {
    return Optional.empty();
  }

  @Override
  public Team teamUp(GameModeDTO mode, List<Player> players) {
    if (players.size() > mode.numOfRequiredPlayers()) {
      throw new IllegalArgumentException(
          "Number of required players for this game mode is %s"
              .formatted(mode.numOfRequiredPlayers()));
    }

    return new Team(players);
  }

  private void validateGameMode(List<Player> players, GameModeDTO gameMode)
      throws InterruptedException {
    if (players.size() != gameMode.numOfRequiredPlayers()) {
      // mimic waiting for players to join
      Thread.sleep(1000);
    }
  }

  private void validatePlayerState(List<Player> players) {
    players.forEach(
        p -> {
          if (inGamePlayerStore.getActivePlayers().containsKey(p.getId())) {
            throw new IllegalStateException(
                "Player: %s with id: %s is already in a game".formatted(p.getAlias(), p.getId()));
          }
        });
  }
}
