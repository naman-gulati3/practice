package com.practice.machine_coding.online_war_game.repository;

import com.practice.lld.snake_game.Player;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class PlayersInQueueStore {

  private final Map<Long, Player> playerInQueue;

  public PlayersInQueueStore() {
    this.playerInQueue = new ConcurrentHashMap<>();
  }

  public Map<Long, Player> getPlayerInQueue() {
    return playerInQueue;
  }

  public void addPlayerInQueue(Player player) {}
}
