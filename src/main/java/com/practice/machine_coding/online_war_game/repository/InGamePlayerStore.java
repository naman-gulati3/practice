package com.practice.machine_coding.online_war_game.repository;

import com.practice.machine_coding.online_war_game.dto.Player;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class InGamePlayerStore {

  private final Map<Long, Player> activePlayers;

  public InGamePlayerStore() {
    this.activePlayers = new ConcurrentHashMap<>();
  }

  public Map<Long, Player> getActivePlayers() {
    return activePlayers;
  }

  public void addPlayerToGame(Player player) {
    this.activePlayers.put(player.getId(), player);
  }
}
