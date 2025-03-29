package com.practice.machine_coding.online_war_game.repository;

import com.practice.machine_coding.online_war_game.dto.Game;
import java.util.ArrayList;
import java.util.List;

public class OngoingGameStore implements InMemoryStore<Long, List<Game>> {

  private final List<Game> activeGames;

  public OngoingGameStore() {
    this.activeGames = new ArrayList<>();
  }

  public List<Game> getActiveGames() {
    return activeGames;
  }

  public void addActiveGame(Game game) {
    synchronized (activeGames) {
      activeGames.add(game);
    }
  }
}
